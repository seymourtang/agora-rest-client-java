package io.agora.rest.core;

import io.agora.rest.AgoraVersion;
import io.netty.handler.logging.LogLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.time.Duration;

public class HttpClientFactory {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientFactory.class);

    public static HttpClient createHttpClient(AgoraProperty agoraProperty) {
        ConnectionProvider connectionProvider = ConnectionProvider.builder("agora-rest-client")
                .maxConnections(agoraProperty.getHttpProperty().getHttpConnectionPoolSize())
                .pendingAcquireTimeout(Duration.ofMillis(agoraProperty.getHttpProperty().getHttpConnectionPendingAcquireTimout()))
                .maxIdleTime(Duration.ofMillis(agoraProperty.getHttpProperty().getHttpConnectionMaxIdleTime()))
                .maxLifeTime(Duration.ofMillis(agoraProperty.getHttpProperty().getHttpConnectionMaxLifeTime()))
                .evictInBackground(Duration.ofMillis(agoraProperty.getHttpProperty().getHttpConnectionEvictInBackground()))
                .pendingAcquireMaxCount(agoraProperty.getHttpProperty().getHttpConnectionPendingAcquireMaxCount())
                .lifo()
                .build();

        return HttpClient.create(connectionProvider)
                .headers(h -> {
                    h.add("User-Agent", String.format(
                            "AgoraRESTClient  Language/java LanguageVersion/%s Arch/%s OS/%s SDKVersion/%s",
                            System.getProperty("java.version"),
                            System.getProperty("os.arch"),
                            System.getProperty("os.name"),
                            AgoraVersion.getVersion()));
                    if (agoraProperty.getCredential() != null) {
                        agoraProperty.getCredential().setAuthorization(h);
                    }
                })
                .wiretap("io.agora.rest.core.http", LogLevel.DEBUG, agoraProperty.getHttpProperty().getHttpLogFormat())
                .doOnRequestError((req, t) -> logger.error("request error:{}", t.getMessage()));

    }
}
