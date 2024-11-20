package io.agora.rest.core;

import reactor.core.publisher.Mono;

import java.util.List;

public interface DomainDNSResolver {
    Mono<String> resolve(List<String> domains, String regionPrefix);
}
