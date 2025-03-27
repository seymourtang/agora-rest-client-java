package io.agora.rest.core;

public class AgoraConfig {
    private final String appId;

    private final Credential credential;

    private final DomainArea domainArea;

    private final HttpProperty httpProperty;

    private AgoraConfig(Builder builder) {
        this.appId = builder.appId;
        this.credential = builder.credential;
        this.domainArea = builder.domainArea;
        this.httpProperty = builder.httpProperty;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getAppId() {
        return appId;
    }

    public Credential getCredential() {
        return credential;
    }

    public DomainArea getDomainArea() {
        return domainArea;
    }

    public HttpProperty getHttpProperty() {
        return httpProperty;
    }

    @Override
    public String toString() {
        return "AgoraConfig{" +
                "appId='" + appId + '\'' +
                ", credential=" + credential +
                ", domainArea=" + domainArea +
                ", httpProperty=" + httpProperty +
                '}';
    }

    public static class Builder {

        private String appId;

        private Credential credential;

        private DomainArea domainArea;

        private HttpProperty httpProperty;

        private Builder() {
        }

        public Builder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public Builder credential(Credential credential) {
            this.credential = credential;
            return this;
        }

        public Builder domainArea(DomainArea domainArea) {
            this.domainArea = domainArea;
            return this;
        }

        public Builder httpProperty(HttpProperty httpProperty) {
            this.httpProperty = httpProperty;
            return this;
        }

        public AgoraConfig build() {
            if (httpProperty == null) {
                this.httpProperty = HttpProperty.builder().build();
            }
            return new AgoraConfig(this);
        }
    }
}
