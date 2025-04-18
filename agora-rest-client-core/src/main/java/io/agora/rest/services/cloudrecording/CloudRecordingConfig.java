package io.agora.rest.services.cloudrecording;

import io.agora.rest.core.Credential;
import io.agora.rest.core.DomainArea;
import io.agora.rest.core.HttpProperty;

/**
 * @brief Defines the configuration for the Cloud Recording client
 * @since v0.4.0
 */
public class CloudRecordingConfig {
    /**
     * Agora AppID
     */
    private final String appId;

    /**
     * Credential for accessing the Agora service.
     * <p>
     * Available credential types:
     * <p>
     * - BasicAuthCredential: See {@link io.agora.rest.core.BasicAuthCredential}
     */
    private final Credential credential;

    /**
     * Domain area for the REST Client. See {@link DomainArea}
     */
    private final DomainArea domainArea;

    /**
     * HTTP properties for the REST Client. See {@link HttpProperty}
     */
    private final HttpProperty httpProperty;

    private CloudRecordingConfig(Builder builder) {
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
        return "CloudRecordingConfig{" +
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

        public CloudRecordingConfig build() {
            if (httpProperty == null) {
                this.httpProperty = HttpProperty.builder().build();
            }
            return new CloudRecordingConfig(this);
        }
    }
}
