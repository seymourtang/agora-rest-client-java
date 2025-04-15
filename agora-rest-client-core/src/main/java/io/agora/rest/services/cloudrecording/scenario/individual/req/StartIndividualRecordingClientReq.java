package io.agora.rest.services.cloudrecording.scenario.individual.req;

import io.agora.rest.services.cloudrecording.api.req.StartResourceReq;

/**
 * @brief Client request for starting individual recording.
 * @since v0.4.0
 */
public class StartIndividualRecordingClientReq {

    /**
     * Agora App Token.(Optional)
     */
    private String token;

    /**
     * Configuration for the application.(Optional) See
     * {@link StartResourceReq.AppsCollection}.
     */
    private StartResourceReq.AppsCollection appsCollection;

    /**
     * Configuration for recorded audio and video streams.(Optional) See
     * {@link StartResourceReq.RecordingConfig}.
     */
    private StartResourceReq.RecordingConfig recordingConfig;

    /**
     * Configurations for the recorded files generated under postponed transcoding
     * or audio mixing.(Optional) See {@link StartResourceReq.TranscodeOptions}.
     */
    private StartResourceReq.TranscodeOptions transcodeOptions;

    /**
     * Configuration for recorded files.(Optional) See
     * {@link StartResourceReq.RecordingFileConfig}.
     */
    private StartResourceReq.RecordingFileConfig recordingFileConfig;

    /**
     * Configurations for screenshot capture.(Optional) See
     * {@link StartResourceReq.SnapshotConfig}.
     */
    private StartResourceReq.SnapshotConfig snapshotConfig;

    /**
     * Configuration for third-party cloud storage.(Required) See
     * {@link StartResourceReq.StorageConfig}.
     */
    private StartResourceReq.StorageConfig storageConfig;

    public static Builder builder() {
        return new Builder();
    }

    private StartIndividualRecordingClientReq(Builder builder) {
        setToken(builder.token);
        setAppsCollection(builder.appsCollection);
        setRecordingConfig(builder.recordingConfig);
        setTranscodeOptions(builder.transcodeOptions);
        setRecordingFileConfig(builder.recordingFileConfig);
        setSnapshotConfig(builder.snapshotConfig);
        setStorageConfig(builder.storageConfig);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public StartResourceReq.AppsCollection getAppsCollection() {
        return appsCollection;
    }

    public void setAppsCollection(StartResourceReq.AppsCollection appsCollection) {
        this.appsCollection = appsCollection;
    }

    public StartResourceReq.RecordingConfig getRecordingConfig() {
        return recordingConfig;
    }

    public void setRecordingConfig(StartResourceReq.RecordingConfig recordingConfig) {
        this.recordingConfig = recordingConfig;
    }

    public StartResourceReq.TranscodeOptions getTranscodeOptions() {
        return transcodeOptions;
    }

    public void setTranscodeOptions(StartResourceReq.TranscodeOptions transcodeOptions) {
        this.transcodeOptions = transcodeOptions;
    }

    public StartResourceReq.RecordingFileConfig getRecordingFileConfig() {
        return recordingFileConfig;
    }

    public void setRecordingFileConfig(StartResourceReq.RecordingFileConfig recordingFileConfig) {
        this.recordingFileConfig = recordingFileConfig;
    }

    public StartResourceReq.SnapshotConfig getSnapshotConfig() {
        return snapshotConfig;
    }

    public void setSnapshotConfig(StartResourceReq.SnapshotConfig snapshotConfig) {
        this.snapshotConfig = snapshotConfig;
    }

    public StartResourceReq.StorageConfig getStorageConfig() {
        return storageConfig;
    }

    public void setStorageConfig(StartResourceReq.StorageConfig storageConfig) {
        this.storageConfig = storageConfig;
    }

    @Override
    public String toString() {
        return "StartIndividualRecordingClientReq{" +
                "token='" + token + '\'' +
                ", appsCollection=" + appsCollection +
                ", recordingConfig=" + recordingConfig +
                ", transcodeOptions=" + transcodeOptions +
                ", recordingFileConfig=" + recordingFileConfig +
                ", snapshotConfig=" + snapshotConfig +
                ", storageConfig=" + storageConfig +
                '}';
    }

    public static final class Builder {
        private String token;
        private StartResourceReq.AppsCollection appsCollection;
        private StartResourceReq.RecordingConfig recordingConfig;
        private StartResourceReq.TranscodeOptions transcodeOptions;
        private StartResourceReq.RecordingFileConfig recordingFileConfig;
        private StartResourceReq.SnapshotConfig snapshotConfig;
        private StartResourceReq.StorageConfig storageConfig;

        private Builder() {
        }

        public Builder token(String val) {
            token = val;
            return this;
        }

        public Builder appsCollection(StartResourceReq.AppsCollection val) {
            appsCollection = val;
            return this;
        }

        public Builder recordingConfig(StartResourceReq.RecordingConfig val) {
            recordingConfig = val;
            return this;
        }

        public Builder transcodeOptions(StartResourceReq.TranscodeOptions val) {
            transcodeOptions = val;
            return this;
        }

        public Builder recordingFileConfig(StartResourceReq.RecordingFileConfig val) {
            recordingFileConfig = val;
            return this;
        }

        public Builder snapshotConfig(StartResourceReq.SnapshotConfig val) {
            snapshotConfig = val;
            return this;
        }

        public Builder storageConfig(StartResourceReq.StorageConfig val) {
            storageConfig = val;
            return this;
        }

        public StartIndividualRecordingClientReq build() {
            return new StartIndividualRecordingClientReq(this);
        }
    }
}
