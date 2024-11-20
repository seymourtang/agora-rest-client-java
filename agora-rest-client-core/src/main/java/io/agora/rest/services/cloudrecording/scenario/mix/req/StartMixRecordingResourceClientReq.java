package io.agora.rest.services.cloudrecording.scenario.mix.req;

import io.agora.rest.services.cloudrecording.api.req.StartResourceReq;

public class StartMixRecordingResourceClientReq {

    private String token;

    private StartResourceReq.RecordingConfig recordingConfig;

    private StartResourceReq.RecordingFileConfig recordingFileConfig;

    private StartResourceReq.StorageConfig storageConfig;

    public static Builder builder() {
        return new Builder();
    }

    private StartMixRecordingResourceClientReq(Builder builder) {
        setToken(builder.token);
        setRecordingConfig(builder.recordingConfig);
        setRecordingFileConfig(builder.recordingFileConfig);
        setStorageConfig(builder.storageConfig);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public StartResourceReq.RecordingConfig getRecordingConfig() {
        return recordingConfig;
    }

    public void setRecordingConfig(StartResourceReq.RecordingConfig recordingConfig) {
        this.recordingConfig = recordingConfig;
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

    @Override
    public String toString() {
        return "StartMixRecordingResourceClientReq{" +
                "token='" + token + '\'' +
                ", recordingConfig=" + recordingConfig +
                ", recordingFileConfig=" + recordingFileConfig +
                ", storageConfig=" + storageConfig +
                '}';
    }

    public static final class Builder {
        private String token;
        private StartResourceReq.RecordingConfig recordingConfig;
        private StartResourceReq.RecordingFileConfig recordingFileConfig;
        private StartResourceReq.StorageConfig storageConfig;

        private Builder() {
        }

        public Builder token(String val) {
            token = val;
            return this;
        }

        public Builder recordingConfig(StartResourceReq.RecordingConfig val) {
            recordingConfig = val;
            return this;
        }

        public Builder recordingFileConfig(StartResourceReq.RecordingFileConfig val) {
            recordingFileConfig = val;
            return this;
        }

        public Builder storageConfig(StartResourceReq.StorageConfig val) {
            storageConfig = val;
            return this;
        }

        public StartMixRecordingResourceClientReq build() {
            return new StartMixRecordingResourceClientReq(this);
        }
    }
}
