package io.agora.rest.services.cloudrecording.scenario.web.req;

import io.agora.rest.services.cloudrecording.api.req.StartResourceReq;

/**
 * @brief Client request for starting web recording.
 * @since v0.4.0
 */
public class StartWebRecordingResourceClientReq {

    /**
     * Configuration for recorded files.(Optional)
     */
    private StartResourceReq.RecordingFileConfig recordingFileConfig;

    /**
     * Configuration for third-party cloud storage.(Required)
     */
    private StartResourceReq.StorageConfig storageConfig;

    /**
     * Configurations for extended services.(Optional)
     */
    private StartResourceReq.ExtensionServiceConfig extensionServiceConfig;

    public static Builder builder() {
        return new Builder();
    }

    private StartWebRecordingResourceClientReq(Builder builder) {
        setRecordingFileConfig(builder.recordingFileConfig);
        setStorageConfig(builder.storageConfig);
        setExtensionServiceConfig(builder.extensionServiceConfig);
    }

    public StartResourceReq.RecordingFileConfig getRecordingFileConfig() {
        return recordingFileConfig;
    }

    public void setRecordingFileConfig(StartResourceReq.RecordingFileConfig recordingFileConfig) {
        this.recordingFileConfig = recordingFileConfig;
    }

    public StartResourceReq.StorageConfig getStorageConfig() {
        return storageConfig;
    }

    public void setStorageConfig(StartResourceReq.StorageConfig storageConfig) {
        this.storageConfig = storageConfig;
    }

    public StartResourceReq.ExtensionServiceConfig getExtensionServiceConfig() {
        return extensionServiceConfig;
    }

    public void setExtensionServiceConfig(StartResourceReq.ExtensionServiceConfig extensionServiceConfig) {
        this.extensionServiceConfig = extensionServiceConfig;
    }

    @Override
    public String toString() {
        return "StartWebRecordingResourceClientReq{" +
                "recordingFileConfig=" + recordingFileConfig +
                ", storageConfig=" + storageConfig +
                ", extensionServiceConfig=" + extensionServiceConfig +
                '}';
    }

    public static final class Builder {
        private StartResourceReq.RecordingFileConfig recordingFileConfig;
        private StartResourceReq.StorageConfig storageConfig;
        private StartResourceReq.ExtensionServiceConfig extensionServiceConfig;

        private Builder() {
        }

        public Builder recordingFileConfig(StartResourceReq.RecordingFileConfig val) {
            recordingFileConfig = val;
            return this;
        }

        public Builder storageConfig(StartResourceReq.StorageConfig val) {
            storageConfig = val;
            return this;
        }

        public Builder extensionServiceConfig(StartResourceReq.ExtensionServiceConfig val) {
            extensionServiceConfig = val;
            return this;
        }

        public StartWebRecordingResourceClientReq build() {
            return new StartWebRecordingResourceClientReq(this);
        }
    }
}
