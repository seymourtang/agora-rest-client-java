package io.agora.rest.core;

/**
 * @brief HttpProperty represents the properties of the HTTP client
 * @since v0.3.0
 */
public class HttpProperty {

    /**
     * Maximum number of connections in the connection pool
     */
    private final int httpConnectionPoolSize;

    /**
     * Maximum idle time of a connection in the connection pool, unit: ms
     */
    private final int httpConnectionMaxIdleTime;

    /**
     * Maximum lifetime of a connection in the connection pool，unit: ms
     */
    private final int httpConnectionMaxLifeTime;

    /**
     * Time to evict connections in the background, unit: ms
     */
    private final int httpConnectionEvictInBackground;

    /**
     * Timeout for acquiring a connection from the connection pool, unit: ms
     */
    private final int httpConnectionPendingAcquireTimout;

    /**
     * The maximum number of registered requests for acquire to keep in a pending queue
     */
    private final int httpConnectionPendingAcquireMaxCount;

    public static Builder builder() {
        return new Builder();
    }

    private HttpProperty(Builder builder) {
        httpConnectionPoolSize = builder.httpConnectionPoolSize;
        httpConnectionMaxIdleTime = builder.httpConnectionMaxIdleTime;
        httpConnectionMaxLifeTime = builder.httpConnectionMaxLifeTime;
        httpConnectionEvictInBackground = builder.httpConnectionEvictInBackground;
        httpConnectionPendingAcquireTimout = builder.httpConnectionPendingAcquireTimout;
        httpConnectionPendingAcquireMaxCount = builder.httpConnectionPendingAcquireMaxCount;
    }

    public int getHttpConnectionPoolSize() {
        return httpConnectionPoolSize;
    }

    public int getHttpConnectionMaxIdleTime() {
        return httpConnectionMaxIdleTime;
    }

    public int getHttpConnectionMaxLifeTime() {
        return httpConnectionMaxLifeTime;
    }

    public int getHttpConnectionEvictInBackground() {
        return httpConnectionEvictInBackground;
    }

    public int getHttpConnectionPendingAcquireTimout() {
        return httpConnectionPendingAcquireTimout;
    }

    public int getHttpConnectionPendingAcquireMaxCount() {
        return httpConnectionPendingAcquireMaxCount;
    }

    @Override
    public String toString() {
        return "HttpProperty{" +
                "httpConnectionPoolSize=" + httpConnectionPoolSize +
                ", httpConnectionMaxIdleTime=" + httpConnectionMaxIdleTime +
                ", httpConnectionMaxLifeTime=" + httpConnectionMaxLifeTime +
                ", httpConnectionEvictInBackground=" + httpConnectionEvictInBackground +
                ", httpConnectionPendingAcquireTimout=" + httpConnectionPendingAcquireTimout +
                ", httpConnectionPendingAcquireMaxCount=" + httpConnectionPendingAcquireMaxCount +
                '}';
    }


    public static final class Builder {
        private int httpConnectionPoolSize = 50;

        private int httpConnectionMaxIdleTime = 10 * 1000;

        private int httpConnectionMaxLifeTime = 60 * 1000;

        private int httpConnectionEvictInBackground = 120 * 1000;

        private int httpConnectionPendingAcquireTimout = 60 * 1000;

        private int httpConnectionPendingAcquireMaxCount = 100;

        private Builder() {

        }

        public Builder httpConnectionPoolSize(int val) {
            httpConnectionPoolSize = val;
            return this;
        }

        public Builder httpConnectionMaxIdleTime(int val) {
            httpConnectionMaxIdleTime = val;
            return this;
        }

        public Builder httpConnectionMaxLifeTime(int val) {
            httpConnectionMaxLifeTime = val;
            return this;
        }

        public Builder httpConnectionEvictInBackground(int val) {
            httpConnectionEvictInBackground = val;
            return this;
        }

        public Builder httpConnectionPendingAcquireTimout(int val) {
            httpConnectionPendingAcquireTimout = val;
            return this;
        }

        public Builder httpConnectionPendingAcquireMaxCount(int val) {
            httpConnectionPendingAcquireMaxCount = val;
            return this;
        }

        public HttpProperty build() {
            return new HttpProperty(this);
        }
    }
}
