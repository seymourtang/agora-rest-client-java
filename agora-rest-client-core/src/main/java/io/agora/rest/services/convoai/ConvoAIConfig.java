package io.agora.rest.services.convoai;

import io.agora.rest.core.Credential;
import io.agora.rest.core.DomainArea;
import io.agora.rest.core.HttpProperty;

public class ConvoAIConfig {
    private final String appId;

    private final Credential credential;

    private final DomainArea domainArea;

    private final HttpProperty httpProperty;

    private final ConvoAIServiceRegionEnum serviceRegion;

    private ConvoAIConfig(Builder builder) {
        this.appId = builder.appId;
        this.credential = builder.credential;
        this.domainArea = builder.domainArea;
        this.httpProperty = builder.httpProperty;
        this.serviceRegion = builder.serviceRegion;
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
        return "ConvoAIConfig{" +
                "appId='" + appId + '\'' +
                ", credential=" + credential +
                ", domainArea=" + domainArea +
                ", httpProperty=" + httpProperty +
                ", serviceRegion=" + serviceRegion +
                '}';
    }

    public static class Builder {

        private String appId;

        private Credential credential;

        private DomainArea domainArea;

        private HttpProperty httpProperty;

        private ConvoAIServiceRegionEnum serviceRegion;

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

        private Builder httpProperty(HttpProperty httpProperty) {
            this.httpProperty = httpProperty;
            return this;
        }

        public Builder serverRegion(ConvoAIServiceRegionEnum serverRegion) {
            this.serviceRegion = serverRegion;
            return this;
        }

        public ConvoAIConfig build() {
            if (httpProperty == null) {
                this.httpProperty = HttpProperty.builder().build();
            }
            return new ConvoAIConfig(this);
        }
    }
}
