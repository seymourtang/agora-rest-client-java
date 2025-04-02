package io.agora.rest.services.cloudrecording.api;

import io.agora.rest.core.Context;
import io.agora.rest.exception.AgoraNeedRetryException;
import io.agora.rest.services.cloudrecording.api.req.StartResourceReq;
import io.agora.rest.services.cloudrecording.api.res.StartResourceRes;
import io.agora.rest.services.cloudrecording.enums.CloudRecordingModeEnum;
import io.netty.handler.codec.http.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import reactor.util.retry.RetryBackoffSpec;

import java.time.Duration;
import java.util.function.Predicate;


public class StartResourceAPI {

    private static final Logger logger = LoggerFactory.getLogger(StartResourceAPI.class);

    private final Context context;

    private final static int MAX_ATTEMPTS = 3;

    public StartResourceAPI(Context context) {
        this.context = context;
    }

    public Mono<StartResourceRes> handle(String resourceId, CloudRecordingModeEnum mode, StartResourceReq request) {
        String path = String.format("/v1/apps/%s/cloud_recording/resourceid/%s/mode/%s/start",
                this.context.getAgoraConfig().getAppId(), resourceId, mode.getMode());

        return this.context.sendRequest(path, HttpMethod.POST, request, StartResourceRes.class)
                .retryWhen(customRetry(MAX_ATTEMPTS, e -> e instanceof AgoraNeedRetryException));
    }


    private RetryBackoffSpec customRetry(int maxAttempts, Predicate<Throwable> retryPredicate) {
        return Retry.backoff(maxAttempts, Duration.ofSeconds(1)) // Maximum 5 retry attempts, initial 1-second interval
                .maxBackoff(Duration.ofSeconds(5)) // Maximum 5-second interval
                .filter(retryPredicate) // Retry condition
                .doBeforeRetry(retrySignal -> {
                    long retryCount = retrySignal.totalRetries() + 1; // Current retry attempt number
                    Duration nextBackoff = Duration.ofSeconds(retryCount); // Next retry interval
                    logger.warn("Retry attempt: {}, next backoff: {}", retryCount, nextBackoff);
                }).onRetryExhaustedThrow((retryBackoffSpec, retrySignal) -> {
                    logger.error("Retry exhausted: {}", retrySignal.totalRetries());
                    return retrySignal.failure();
                });
    }

}
