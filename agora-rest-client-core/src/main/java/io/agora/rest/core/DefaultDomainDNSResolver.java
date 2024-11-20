package io.agora.rest.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.net.InetAddress;
import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DefaultDomainDNSResolver implements DomainDNSResolver {

    private final Logger logger = LoggerFactory.getLogger(DefaultDomainDNSResolver.class);

    private final Duration timeout = Duration.ofSeconds(3);

    public Mono<String> resolve(List<String> domains, String regionPrefix) {
        return Flux.fromIterable(domains)
                .flatMap(domain -> {
                    String url = regionPrefix + "." + domain;
                    long startTime = System.nanoTime();
                    return Mono.fromCallable(() -> InetAddress.getAllByName(url))
                            .subscribeOn(Schedulers.boundedElastic())
                            .map(addrs -> {
                                long took = System.nanoTime() - startTime;
                                logger.debug("url:{}, IP:{}, took:{}ms", url, addrs,
                                        TimeUnit.NANOSECONDS.toMillis(took));

                                return new DomainResult(domain, took);
                            })
                            .onErrorResume(e -> {
                                long took = System.nanoTime() - startTime;
                                logger.error("resolve domain failed, url:{}, err:{}, took:{}ms", url, e.getMessage(),
                                        TimeUnit.NANOSECONDS.toMillis(took));

                                return Mono.empty();
                            });
                })
                .collectList()
                .map(results -> results.stream()
                        .min(Comparator.comparingLong(DomainResult::getTime))
                        .map(DomainResult::getDomain)
                        .orElse(null))
                .timeout(timeout)
                .onErrorResume(e -> {
                    logger.error("all domain resolve failed, err:{}", e.getMessage());

                    return Mono.empty();
                });
    }

    private static class DomainResult {
        private final String domain;
        private final long time;

        public DomainResult(String domain, long time) {
            this.domain = domain;
            this.time = time;
        }

        public String getDomain() {
            return domain;
        }

        public long getTime() {
            return time;
        }
    }
}
