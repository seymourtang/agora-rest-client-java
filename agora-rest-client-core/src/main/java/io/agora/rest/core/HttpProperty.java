package io.agora.rest.core;

public class HttpProperty {

    private final int httpConnectionPoolSize;

    private final int httpConnectionMaxIdleTime;

    private final int httpConnectionMaxLifeTime;

    private final int httpConnectionEvictInBackground;

    private final int httpConnectionPendingAcquireTimout;

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
