package io.agora.rest.services.cloudrecording.api.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StartResourceReq {

    @JsonProperty("cname")
    private String cname;

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("clientRequest")
    private StartClientRequest clientRequest;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public StartClientRequest getClientRequest() {
        return clientRequest;
    }

    public void setClientRequest(StartClientRequest clientRequest) {
        this.clientRequest = clientRequest;
    }

    @Override
    public String toString() {
        return "StartResourceReq{" +
                "cname='" + cname + '\'' +
                ", uid='" + uid + '\'' +
                ", clientRequest=" + clientRequest +
                '}';
    }

    public interface ServiceParam {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class StartClientRequest {

        @JsonProperty("token")
        private String token;

        @JsonProperty("appsCollection")
        private AppsCollection appsCollection;

        @JsonProperty("recordingConfig")
        private RecordingConfig recordingConfig;

        @JsonProperty("transcodeOptions")
        private TranscodeOptions transcodeOptions;

        @JsonProperty("recordingFileConfig")
        private RecordingFileConfig recordingFileConfig;

        @JsonProperty("snapshotConfig")
        private SnapshotConfig snapshotConfig;

        @JsonProperty("storageConfig")
        private StorageConfig storageConfig;

        @JsonProperty("extensionServiceConfig")
        private ExtensionServiceConfig extensionServiceConfig;

        public static Builder builder() {
            return new Builder();
        }

        private StartClientRequest(Builder builder) {
            setToken(builder.token);
            setAppsCollection(builder.appsCollection);
            setRecordingConfig(builder.recordingConfig);
            setTranscodeOptions(builder.transcodeOptions);
            setRecordingFileConfig(builder.recordingFileConfig);
            setSnapshotConfig(builder.snapshotConfig);
            setStorageConfig(builder.storageConfig);
            setExtensionServiceConfig(builder.extensionServiceConfig);
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public AppsCollection getAppsCollection() {
            return appsCollection;
        }

        public void setAppsCollection(AppsCollection appsCollection) {
            this.appsCollection = appsCollection;
        }

        public RecordingConfig getRecordingConfig() {
            return recordingConfig;
        }

        public void setRecordingConfig(RecordingConfig recordingConfig) {
            this.recordingConfig = recordingConfig;
        }

        public TranscodeOptions getTranscodeOptions() {
            return transcodeOptions;
        }

        public void setTranscodeOptions(TranscodeOptions transcodeOptions) {
            this.transcodeOptions = transcodeOptions;
        }

        public RecordingFileConfig getRecordingFileConfig() {
            return recordingFileConfig;
        }

        public void setRecordingFileConfig(RecordingFileConfig recordingFileConfig) {
            this.recordingFileConfig = recordingFileConfig;
        }

        public SnapshotConfig getSnapshotConfig() {
            return snapshotConfig;
        }

        public void setSnapshotConfig(SnapshotConfig snapshotConfig) {
            this.snapshotConfig = snapshotConfig;
        }

        public StorageConfig getStorageConfig() {
            return storageConfig;
        }

        public void setStorageConfig(StorageConfig storageConfig) {
            this.storageConfig = storageConfig;
        }

        public ExtensionServiceConfig getExtensionServiceConfig() {
            return extensionServiceConfig;
        }

        public void setExtensionServiceConfig(ExtensionServiceConfig extensionServiceConfig) {
            this.extensionServiceConfig = extensionServiceConfig;
        }

        @Override
        public String toString() {
            return "StartClientRequest{" +
                    "token='" + token + '\'' +
                    ", appsCollection=" + appsCollection +
                    ", recordingConfig=" + recordingConfig +
                    ", transcodeOptions=" + transcodeOptions +
                    ", recordingFileConfig=" + recordingFileConfig +
                    ", snapshotConfig=" + snapshotConfig +
                    ", storageConfig=" + storageConfig +
                    ", extensionServiceConfig=" + extensionServiceConfig +
                    '}';
        }

        public static final class Builder {

            private String token;

            private AppsCollection appsCollection;

            private RecordingConfig recordingConfig;

            private TranscodeOptions transcodeOptions;

            private RecordingFileConfig recordingFileConfig;

            private SnapshotConfig snapshotConfig;

            private StorageConfig storageConfig;

            private ExtensionServiceConfig extensionServiceConfig;

            private Builder() {
            }

            public static Builder builder() {
                return new Builder();
            }

            public Builder token(String val) {
                token = val;
                return this;
            }

            public Builder appsCollection(AppsCollection val) {
                appsCollection = val;
                return this;
            }

            public Builder recordingConfig(RecordingConfig val) {
                recordingConfig = val;
                return this;
            }

            public Builder transcodeOptions(TranscodeOptions val) {
                transcodeOptions = val;
                return this;
            }

            public Builder recordingFileConfig(RecordingFileConfig val) {
                recordingFileConfig = val;
                return this;
            }

            public Builder snapshotConfig(SnapshotConfig val) {
                snapshotConfig = val;
                return this;
            }

            public Builder storageConfig(StorageConfig val) {
                storageConfig = val;
                return this;
            }

            public Builder extensionServiceConfig(ExtensionServiceConfig val) {
                extensionServiceConfig = val;
                return this;
            }

            public StartClientRequest build() {
                return new StartClientRequest(this);
            }
        }
    }

    public static class AppsCollection {

        @JsonProperty("combinationPolicy")
        private String combinationPolicy;

        public static Builder builder() {
            return new Builder();
        }

        private AppsCollection(Builder builder) {
            setCombinationPolicy(builder.combinationPolicy);
        }

        public String getCombinationPolicy() {
            return combinationPolicy;
        }

        public void setCombinationPolicy(String combinationPolicy) {
            this.combinationPolicy = combinationPolicy;
        }

        @Override
        public String toString() {
            return "AppsCollection{" +
                    "combinationPolicy='" + combinationPolicy + '\'' +
                    '}';
        }

        public static final class Builder {

            private String combinationPolicy;

            private Builder() {
            }

            public static Builder builder() {
                return new Builder();
            }

            public Builder combinationPolicy(String val) {
                combinationPolicy = val;
                return this;
            }

            public AppsCollection build() {
                return new AppsCollection(this);
            }
        }
    }

    public static class RecordingConfig {

        @JsonProperty("channelType")
        private Integer channelType;

        @JsonProperty("streamTypes")
        private Integer streamTypes;

        @JsonProperty("streamMode")
        private String streamMode;

        @JsonProperty("decryptionMode")
        private Integer decryptionMode;

        @JsonProperty("secret")
        private String secret;

        @JsonProperty("salt")
        private String salt;

        @JsonProperty("audioProfile")
        private Integer audioProfile;

        @JsonProperty("videoStreamType")
        private Integer videoStreamType;

        @JsonProperty("maxIdleTime")
        private Integer maxIdleTime;

        @JsonProperty("transcodingConfig")
        private TranscodingConfig transcodingConfig;

        @JsonProperty("subscribeAudioUids")
        private List<String> subscribeAudioUIDs;

        @JsonProperty("unSubscribeAudioUids")
        private List<String> unsubscribeAudioUIDs;

        @JsonProperty("subscribeVideoUids")
        private List<String> subscribeVideoUIDs;

        @JsonProperty("unSubscribeVideoUids")
        private List<String> unsubscribeVideoUIDs;

        @JsonProperty("subscribeUidGroup")
        private Integer subscribeUidGroup;

        public static Builder builder() {
            return new Builder();
        }

        private RecordingConfig(Builder builder) {
            setChannelType(builder.channelType);
            setStreamTypes(builder.streamTypes);
            setStreamMode(builder.streamMode);
            setDecryptionMode(builder.decryptionMode);
            setSecret(builder.secret);
            setSalt(builder.salt);
            setAudioProfile(builder.audioProfile);
            setVideoStreamType(builder.videoStreamType);
            setMaxIdleTime(builder.maxIdleTime);
            setTranscodingConfig(builder.transcodingConfig);
            setSubscribeAudioUIDs(builder.subscribeAudioUIDs);
            setUnsubscribeAudioUIDs(builder.unsubscribeAudioUIDs);
            setSubscribeVideoUIDs(builder.subscribeVideoUIDs);
            setUnsubscribeVideoUIDs(builder.unsubscribeVideoUIDs);
            setSubscribeUidGroup(builder.subscribeUidGroup);
        }

        public Integer getChannelType() {
            return channelType;
        }

        public void setChannelType(Integer channelType) {
            this.channelType = channelType;
        }

        public Integer getStreamTypes() {
            return streamTypes;
        }

        public void setStreamTypes(Integer streamTypes) {
            this.streamTypes = streamTypes;
        }

        public String getStreamMode() {
            return streamMode;
        }

        public void setStreamMode(String streamMode) {
            this.streamMode = streamMode;
        }

        public Integer getDecryptionMode() {
            return decryptionMode;
        }

        public void setDecryptionMode(Integer decryptionMode) {
            this.decryptionMode = decryptionMode;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public Integer getAudioProfile() {
            return audioProfile;
        }

        public void setAudioProfile(Integer audioProfile) {
            this.audioProfile = audioProfile;
        }

        public Integer getVideoStreamType() {
            return videoStreamType;
        }

        public void setVideoStreamType(Integer videoStreamType) {
            this.videoStreamType = videoStreamType;
        }

        public Integer getMaxIdleTime() {
            return maxIdleTime;
        }

        public void setMaxIdleTime(Integer maxIdleTime) {
            this.maxIdleTime = maxIdleTime;
        }

        public TranscodingConfig getTranscodingConfig() {
            return transcodingConfig;
        }

        public void setTranscodingConfig(TranscodingConfig transcodingConfig) {
            this.transcodingConfig = transcodingConfig;
        }

        public List<String> getSubscribeAudioUIDs() {
            return subscribeAudioUIDs;
        }

        public void setSubscribeAudioUIDs(List<String> subscribeAudioUIDs) {
            this.subscribeAudioUIDs = subscribeAudioUIDs;
        }

        public List<String> getUnsubscribeAudioUIDs() {
            return unsubscribeAudioUIDs;
        }

        public void setUnsubscribeAudioUIDs(List<String> unsubscribeAudioUIDs) {
            this.unsubscribeAudioUIDs = unsubscribeAudioUIDs;
        }

        public List<String> getSubscribeVideoUIDs() {
            return subscribeVideoUIDs;
        }

        public void setSubscribeVideoUIDs(List<String> subscribeVideoUIDs) {
            this.subscribeVideoUIDs = subscribeVideoUIDs;
        }

        public List<String> getUnsubscribeVideoUIDs() {
            return unsubscribeVideoUIDs;
        }

        public void setUnsubscribeVideoUIDs(List<String> unsubscribeVideoUIDs) {
            this.unsubscribeVideoUIDs = unsubscribeVideoUIDs;
        }

        public Integer getSubscribeUidGroup() {
            return subscribeUidGroup;
        }

        public void setSubscribeUidGroup(Integer subscribeUidGroup) {
            this.subscribeUidGroup = subscribeUidGroup;
        }

        @Override
        public String toString() {
            return "RecordingConfig{" +
                    "channelType=" + channelType +
                    ", streamTypes=" + streamTypes +
                    ", streamMode='" + streamMode + '\'' +
                    ", decryptionMode=" + decryptionMode +
                    ", secret='" + secret + '\'' +
                    ", salt='" + salt + '\'' +
                    ", audioProfile=" + audioProfile +
                    ", videoStreamType=" + videoStreamType +
                    ", maxIdleTime=" + maxIdleTime +
                    ", transcodingConfig=" + transcodingConfig +
                    ", subscribeAudioUIDs=" + subscribeAudioUIDs +
                    ", unsubscribeAudioUIDs=" + unsubscribeAudioUIDs +
                    ", subscribeVideoUIDs=" + subscribeVideoUIDs +
                    ", unsubscribeVideoUIDs=" + unsubscribeVideoUIDs +
                    ", subscribeUidGroup=" + subscribeUidGroup +
                    '}';
        }

        public static final class Builder {

            private Integer channelType;
            private Integer streamTypes;
            private String streamMode;
            private Integer decryptionMode;
            private String secret;
            private String salt;
            private Integer audioProfile;
            private Integer videoStreamType;
            private Integer maxIdleTime;
            private TranscodingConfig transcodingConfig;
            private List<String> subscribeAudioUIDs;
            private List<String> unsubscribeAudioUIDs;
            private List<String> subscribeVideoUIDs;
            private List<String> unsubscribeVideoUIDs;
            private Integer subscribeUidGroup;

            private Builder() {
            }

            public Builder channelType(Integer val) {
                channelType = val;
                return this;
            }

            public Builder streamTypes(Integer val) {
                streamTypes = val;
                return this;
            }

            public Builder streamMode(String val) {
                streamMode = val;
                return this;
            }

            public Builder decryptionMode(Integer val) {
                decryptionMode = val;
                return this;
            }

            public Builder secret(String val) {
                secret = val;
                return this;
            }

            public Builder salt(String val) {
                salt = val;
                return this;
            }

            public Builder audioProfile(Integer val) {
                audioProfile = val;
                return this;
            }

            public Builder videoStreamType(Integer val) {
                videoStreamType = val;
                return this;
            }

            public Builder maxIdleTime(Integer val) {
                maxIdleTime = val;
                return this;
            }

            public Builder transcodingConfig(TranscodingConfig val) {
                transcodingConfig = val;
                return this;
            }

            public Builder subscribeAudioUIDs(List<String> val) {
                subscribeAudioUIDs = val;
                return this;
            }

            public Builder unsubscribeAudioUIDs(List<String> val) {
                unsubscribeAudioUIDs = val;
                return this;
            }

            public Builder subscribeVideoUIDs(List<String> val) {
                subscribeVideoUIDs = val;
                return this;
            }

            public Builder unsubscribeVideoUIDs(List<String> val) {
                unsubscribeVideoUIDs = val;
                return this;
            }

            public Builder subscribeUidGroup(Integer val) {
                subscribeUidGroup = val;
                return this;
            }

            public RecordingConfig build() {
                return new RecordingConfig(this);
            }
        }
    }

    public static class Container {

        @JsonProperty("format")
        private String format;

        public static Builder builder() {
            return new Builder();
        }

        private Container(Builder builder) {
            setFormat(builder.format);
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        @Override
        public String toString() {
            return "Container{" +
                    "format='" + format + '\'' +
                    '}';
        }

        public static final class Builder {

            private String format;

            private Builder() {
            }

            public Builder format(String val) {
                format = val;
                return this;
            }

            public Container build() {
                return new Container(this);
            }
        }
    }

    public static class TranscodeOptions {

        @JsonProperty("container")
        private Container container;

        @JsonProperty("transConfig")
        private TransConfig transConfig;

        @JsonProperty("audio")
        private Audio audio;

        public static Builder builder() {
            return new Builder();
        }

        private TranscodeOptions(Builder builder) {
            setContainer(builder.container);
            setTransConfig(builder.transConfig);
            setAudio(builder.audio);
        }

        public Container getContainer() {
            return container;
        }

        public void setContainer(Container container) {
            this.container = container;
        }

        public TransConfig getTransConfig() {
            return transConfig;
        }

        public void setTransConfig(TransConfig transConfig) {
            this.transConfig = transConfig;
        }

        public Audio getAudio() {
            return audio;
        }

        public void setAudio(Audio audio) {
            this.audio = audio;
        }

        @Override
        public String toString() {
            return "TranscodeOptions{" +
                    "container=" + container +
                    ", transConfig=" + transConfig +
                    ", audio=" + audio +
                    '}';
        }

        public static final class Builder {

            private Container container;
            private TransConfig transConfig;
            private Audio audio;

            private Builder() {
            }

            public Builder container(Container val) {
                container = val;
                return this;
            }

            public Builder transConfig(TransConfig val) {
                transConfig = val;
                return this;
            }

            public Builder audio(Audio val) {
                audio = val;
                return this;
            }

            public TranscodeOptions build() {
                return new TranscodeOptions(this);
            }
        }
    }

    public static class TransConfig {

        @JsonProperty("transMode")
        private String transMode;

        public static Builder builder() {
            return new Builder();
        }

        private TransConfig(Builder builder) {
            setTransMode(builder.transMode);
        }

        public String getTransMode() {
            return transMode;
        }

        public void setTransMode(String transMode) {
            this.transMode = transMode;
        }

        @Override
        public String toString() {
            return "TransConfig{" +
                    "transMode='" + transMode + '\'' +
                    '}';
        }

        public static final class Builder {

            private String transMode;

            private Builder() {
            }

            public Builder transMode(String val) {
                transMode = val;
                return this;
            }

            public TransConfig build() {
                return new TransConfig(this);
            }
        }
    }

    public static class Audio {

        @JsonProperty("sampleRate")
        private String sampleRate;

        @JsonProperty("bitrate")
        private String bitRate;

        @JsonProperty("channels")
        private String channels;

        public static Builder builder() {
            return new Builder();
        }

        private Audio(Builder builder) {
            setSampleRate(builder.sampleRate);
            setBitRate(builder.bitRate);
            setChannels(builder.channels);
        }

        public String getSampleRate() {
            return sampleRate;
        }

        public void setSampleRate(String sampleRate) {
            this.sampleRate = sampleRate;
        }

        public String getBitRate() {
            return bitRate;
        }

        public void setBitRate(String bitRate) {
            this.bitRate = bitRate;
        }

        public String getChannels() {
            return channels;
        }

        public void setChannels(String channels) {
            this.channels = channels;
        }

        @Override
        public String toString() {
            return "Audio{" +
                    "sampleRate='" + sampleRate + '\'' +
                    ", bitRate='" + bitRate + '\'' +
                    ", channels='" + channels + '\'' +
                    '}';
        }

        public static final class Builder {

            private String sampleRate;

            private String bitRate;

            private String channels;

            private Builder() {
            }

            public Builder sampleRate(String val) {
                sampleRate = val;
                return this;
            }

            public Builder bitRate(String val) {
                bitRate = val;
                return this;
            }

            public Builder channels(String val) {
                channels = val;
                return this;
            }

            public Audio build() {
                return new Audio(this);
            }
        }
    }

    public static class TranscodingConfig {

        @JsonProperty("width")
        private Integer width;

        @JsonProperty("height")
        private Integer height;

        @JsonProperty("fps")
        private Integer fps;

        @JsonProperty("bitrate")
        private Integer bitrate;

        @JsonProperty("maxResolutionUid")
        private String maxResolutionUid;

        @JsonProperty("mixedVideoLayout")
        private Integer mixedVideoLayout;

        @JsonProperty("backgroundColor")
        private String backgroundColor;

        @JsonProperty("backgroundImage")
        private String backgroundImage;

        @JsonProperty("defaultUserBackgroundImage")
        private String defaultUserBackgroundImage;

        @JsonProperty("layoutConfig")
        private List<LayoutConfig> layoutConfig;

        @JsonProperty("backgroundConfig")
        private List<BackgroundConfig> backgroundConfig;

        public static Builder builder() {
            return new Builder();
        }

        private TranscodingConfig(Builder builder) {
            setWidth(builder.width);
            setHeight(builder.height);
            setFps(builder.fps);
            setBitrate(builder.bitrate);
            setMaxResolutionUid(builder.maxResolutionUid);
            setMixedVideoLayout(builder.mixedVideoLayout);
            setBackgroundColor(builder.backgroundColor);
            setBackgroundImage(builder.backgroundImage);
            setDefaultUserBackgroundImage(builder.defaultUserBackgroundImage);
            setLayoutConfig(builder.layoutConfig);
            setBackgroundConfig(builder.backgroundConfig);
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public Integer getFps() {
            return fps;
        }

        public void setFps(Integer fps) {
            this.fps = fps;
        }

        public Integer getBitrate() {
            return bitrate;
        }

        public void setBitrate(Integer bitrate) {
            this.bitrate = bitrate;
        }

        public String getMaxResolutionUid() {
            return maxResolutionUid;
        }

        public void setMaxResolutionUid(String maxResolutionUid) {
            this.maxResolutionUid = maxResolutionUid;
        }

        public Integer getMixedVideoLayout() {
            return mixedVideoLayout;
        }

        public void setMixedVideoLayout(Integer mixedVideoLayout) {
            this.mixedVideoLayout = mixedVideoLayout;
        }

        public String getBackgroundColor() {
            return backgroundColor;
        }

        public void setBackgroundColor(String backgroundColor) {
            this.backgroundColor = backgroundColor;
        }

        public String getBackgroundImage() {
            return backgroundImage;
        }

        public void setBackgroundImage(String backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        public String getDefaultUserBackgroundImage() {
            return defaultUserBackgroundImage;
        }

        public void setDefaultUserBackgroundImage(String defaultUserBackgroundImage) {
            this.defaultUserBackgroundImage = defaultUserBackgroundImage;
        }

        public List<LayoutConfig> getLayoutConfig() {
            return layoutConfig;
        }

        public void setLayoutConfig(List<LayoutConfig> layoutConfig) {
            this.layoutConfig = layoutConfig;
        }

        public List<BackgroundConfig> getBackgroundConfig() {
            return backgroundConfig;
        }

        public void setBackgroundConfig(List<BackgroundConfig> backgroundConfig) {
            this.backgroundConfig = backgroundConfig;
        }

        @Override
        public String toString() {
            return "TranscodingConfig{" +
                    "width=" + width +
                    ", height=" + height +
                    ", fps=" + fps +
                    ", bitrate=" + bitrate +
                    ", maxResolutionUid='" + maxResolutionUid + '\'' +
                    ", mixedVideoLayout=" + mixedVideoLayout +
                    ", backgroundColor='" + backgroundColor + '\'' +
                    ", backgroundImage='" + backgroundImage + '\'' +
                    ", defaultUserBackgroundImage='" + defaultUserBackgroundImage + '\'' +
                    ", layoutConfig=" + layoutConfig +
                    ", backgroundConfig=" + backgroundConfig +
                    '}';
        }

        public static final class Builder {

            private Integer width;

            private Integer height;

            private Integer fps;

            private Integer bitrate;

            private String maxResolutionUid;

            private Integer mixedVideoLayout;

            private String backgroundColor;

            private String backgroundImage;

            private String defaultUserBackgroundImage;

            private List<LayoutConfig> layoutConfig;

            private List<BackgroundConfig> backgroundConfig;

            private Builder() {
            }

            public Builder width(Integer val) {
                width = val;
                return this;
            }

            public Builder height(Integer val) {
                height = val;
                return this;
            }

            public Builder fps(Integer val) {
                fps = val;
                return this;
            }

            public Builder bitrate(Integer val) {
                bitrate = val;
                return this;
            }

            public Builder maxResolutionUid(String val) {
                maxResolutionUid = val;
                return this;
            }

            public Builder mixedVideoLayout(Integer val) {
                mixedVideoLayout = val;
                return this;
            }

            public Builder backgroundColor(String val) {
                backgroundColor = val;
                return this;
            }

            public Builder backgroundImage(String val) {
                backgroundImage = val;
                return this;
            }

            public Builder defaultUserBackgroundImage(String val) {
                defaultUserBackgroundImage = val;
                return this;
            }

            public Builder layoutConfig(List<LayoutConfig> val) {
                layoutConfig = val;
                return this;
            }

            public Builder backgroundConfig(List<BackgroundConfig> val) {
                backgroundConfig = val;
                return this;
            }

            public TranscodingConfig build() {
                return new TranscodingConfig(this);
            }
        }
    }

    public static class LayoutConfig {

        @JsonProperty("uid")
        private String uid;

        @JsonProperty("x_axis")
        private Float xAxis;

        @JsonProperty("y_axis")
        private Float yAxis;

        @JsonProperty("width")
        private Float width;

        @JsonProperty("height")
        private Float height;

        @JsonProperty("alpha")
        private Float alpha;

        @JsonProperty("render_mode")
        private Integer renderMode;

        public static Builder builder() {
            return new Builder();
        }

        private LayoutConfig(Builder builder) {
            setUid(builder.uid);
            setxAxis(builder.xAxis);
            setyAxis(builder.yAxis);
            setWidth(builder.width);
            setHeight(builder.height);
            setAlpha(builder.alpha);
            setRenderMode(builder.renderMode);
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public Float getxAxis() {
            return xAxis;
        }

        public void setxAxis(Float xAxis) {
            this.xAxis = xAxis;
        }

        public Float getyAxis() {
            return yAxis;
        }

        public void setyAxis(Float yAxis) {
            this.yAxis = yAxis;
        }

        public Float getWidth() {
            return width;
        }

        public void setWidth(Float width) {
            this.width = width;
        }

        public Float getHeight() {
            return height;
        }

        public void setHeight(Float height) {
            this.height = height;
        }

        public Float getAlpha() {
            return alpha;
        }

        public void setAlpha(Float alpha) {
            this.alpha = alpha;
        }

        public Integer getRenderMode() {
            return renderMode;
        }

        public void setRenderMode(Integer renderMode) {
            this.renderMode = renderMode;
        }

        @Override
        public String toString() {
            return "LayoutConfig{" +
                    "uid='" + uid + '\'' +
                    ", xAxis=" + xAxis +
                    ", yAxis=" + yAxis +
                    ", width=" + width +
                    ", height=" + height +
                    ", alpha=" + alpha +
                    ", renderMode=" + renderMode +
                    '}';
        }

        public static final class Builder {

            private String uid;

            private Float xAxis;

            private Float yAxis;

            private Float width;

            private Float height;

            private Float alpha;

            private Integer renderMode;

            private Builder() {
            }

            public Builder uid(String val) {
                uid = val;
                return this;
            }

            public Builder yAxis(Float val) {
                yAxis = val;
                return this;
            }

            public Builder xAxis(Float val) {
                xAxis = val;
                return this;
            }

            public Builder width(Float val) {
                width = val;
                return this;
            }

            public Builder height(Float val) {
                height = val;
                return this;
            }

            public Builder alpha(Float val) {
                alpha = val;
                return this;
            }

            public Builder renderMode(Integer val) {
                renderMode = val;
                return this;
            }

            public LayoutConfig build() {
                return new LayoutConfig(this);
            }
        }
    }

    public static class RecordingFileConfig {

        @JsonProperty("avFileType")
        private List<String> avFileType;

        public static Builder builder() {
            return new Builder();
        }

        private RecordingFileConfig(Builder builder) {
            setAvFileType(builder.avFileType);
        }

        public List<String> getAvFileType() {
            return avFileType;
        }

        public void setAvFileType(List<String> avFileType) {
            this.avFileType = avFileType;
        }

        @Override
        public String toString() {
            return "RecordingFileConfig{" +
                    "avFileType=" + avFileType +
                    '}';
        }

        public static final class Builder {

            private List<String> avFileType;

            private Builder() {
            }

            public Builder avFileType(List<String> val) {
                avFileType = val;
                return this;
            }

            public RecordingFileConfig build() {
                return new RecordingFileConfig(this);
            }
        }
    }

    public static class SnapshotConfig {

        @JsonProperty("captureInterval")
        private Integer captureInterval;

        @JsonProperty("fileType")
        private List<String> fileType;

        public static Builder builder() {
            return new Builder();
        }

        private SnapshotConfig(Builder builder) {
            setCaptureInterval(builder.captureInterval);
            setFileType(builder.fileType);
        }

        public Integer getCaptureInterval() {
            return captureInterval;
        }

        public void setCaptureInterval(Integer captureInterval) {
            this.captureInterval = captureInterval;
        }

        public List<String> getFileType() {
            return fileType;
        }

        public void setFileType(List<String> fileType) {
            this.fileType = fileType;
        }

        @Override
        public String toString() {
            return "SnapshotConfig{" +
                    "captureInterval=" + captureInterval +
                    ", fileType=" + fileType +
                    '}';
        }

        public static final class Builder {

            private Integer captureInterval;

            private List<String> fileType;

            private Builder() {
            }

            public Builder captureInterval(Integer val) {
                captureInterval = val;
                return this;
            }

            public Builder fileType(List<String> val) {
                fileType = val;
                return this;
            }

            public SnapshotConfig build() {
                return new SnapshotConfig(this);
            }
        }
    }

    public static class StorageConfig {

        @JsonProperty("vendor")
        private Integer vendor;

        @JsonProperty("region")
        private Integer region;

        @JsonProperty("bucket")
        private String bucket;

        @JsonProperty("accessKey")
        private String accessKey;

        @JsonProperty("secretKey")
        private String secretKey;

        @JsonProperty("fileNamePrefix")
        private List<String> fileNamePrefix;

        @JsonProperty("stsToken")
        private String stsToken;

        @JsonProperty("stsExpiration")
        private Integer stsExpiration;

        @JsonProperty("extensionParams")
        private ExtensionParams extensionParams;

        public static Builder builder() {
            return new Builder();
        }

        private StorageConfig(Builder builder) {
            setVendor(builder.vendor);
            setRegion(builder.region);
            setBucket(builder.bucket);
            setAccessKey(builder.accessKey);
            setSecretKey(builder.secretKey);
            setFileNamePrefix(builder.fileNamePrefix);
            setStsToken(builder.stsToken);
            setStsExpiration(builder.stsExpiration);
            setExtensionParams(builder.extensionParams);
        }

        public Integer getVendor() {
            return vendor;
        }

        public void setVendor(Integer vendor) {
            this.vendor = vendor;
        }

        public Integer getRegion() {
            return region;
        }

        public void setRegion(Integer region) {
            this.region = region;
        }

        public String getBucket() {
            return bucket;
        }

        public void setBucket(String bucket) {
            this.bucket = bucket;
        }

        public String getAccessKey() {
            return accessKey;
        }

        public void setAccessKey(String accessKey) {
            this.accessKey = accessKey;
        }

        public String getSecretKey() {
            return secretKey;
        }

        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }

        public List<String> getFileNamePrefix() {
            return fileNamePrefix;
        }

        public void setFileNamePrefix(List<String> fileNamePrefix) {
            this.fileNamePrefix = fileNamePrefix;
        }

        public String getStsToken() {
            return stsToken;
        }

        public void setStsToken(String stsToken) {
            this.stsToken = stsToken;
        }

        public Integer getStsExpiration() {
            return stsExpiration;
        }

        public void setStsExpiration(Integer stsExpiration) {
            this.stsExpiration = stsExpiration;
        }

        public ExtensionParams getExtensionParams() {
            return extensionParams;
        }

        public void setExtensionParams(ExtensionParams extensionParams) {
            this.extensionParams = extensionParams;
        }

        @Override
        public String toString() {
            return "StorageConfig{" +
                    "vendor=" + vendor +
                    ", region=" + region +
                    ", bucket='" + bucket + '\'' +
                    ", accessKey='" + accessKey + '\'' +
                    ", secretKey='" + secretKey + '\'' +
                    ", fileNamePrefix=" + fileNamePrefix +
                    ", stsToken='" + stsToken + '\'' +
                    ", stsExpiration=" + stsExpiration +
                    ", extensionParams=" + extensionParams +
                    '}';
        }

        public static final class Builder {

            private Integer vendor;

            private Integer region;

            private String bucket;

            private String accessKey;

            private String secretKey;

            private List<String> fileNamePrefix;

            private String stsToken;

            private Integer stsExpiration;

            private ExtensionParams extensionParams;

            private Builder() {
            }

            public Builder vendor(Integer val) {
                vendor = val;
                return this;
            }

            public Builder region(Integer val) {
                region = val;
                return this;
            }

            public Builder bucket(String val) {
                bucket = val;
                return this;
            }

            public Builder accessKey(String val) {
                accessKey = val;
                return this;
            }

            public Builder secretKey(String val) {
                secretKey = val;
                return this;
            }

            public Builder fileNamePrefix(List<String> val) {
                fileNamePrefix = val;
                return this;
            }

            public Builder stsToken(String val) {
                stsToken = val;
                return this;
            }

            public Builder stsExpiration(Integer val) {
                stsExpiration = val;
                return this;
            }

            public Builder extensionParams(ExtensionParams val) {
                extensionParams = val;
                return this;
            }

            public StorageConfig build() {
                return new StorageConfig(this);
            }
        }
    }

    public static class ExtensionParams {

        @JsonProperty("sse")
        private String sse;

        @JsonProperty("tag")
        private String tag;

        public static Builder builder() {
            return new Builder();
        }

        private ExtensionParams(Builder builder) {
            setSse(builder.sse);
            setTag(builder.tag);
        }

        public String getSse() {
            return sse;
        }

        public void setSse(String sse) {
            this.sse = sse;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        @Override
        public String toString() {
            return "ExtensionParams{" +
                    "sse='" + sse + '\'' +
                    ", tag='" + tag + '\'' +
                    '}';
        }

        public static final class Builder {

            private String sse;

            private String tag;

            private Builder() {
            }

            public Builder sse(String val) {
                sse = val;
                return this;
            }

            public Builder tag(String val) {
                tag = val;
                return this;
            }

            public ExtensionParams build() {
                return new ExtensionParams(this);
            }
        }
    }

    public static class ExtensionServiceConfig {

        @JsonProperty("errorHandlePolicy")
        private String errorHandlePolicy;

        @JsonProperty("extensionServices")
        private List<ExtensionService> extensionServices;

        @JsonProperty("serviceParam")
        private ServiceParam serviceParam;

        public static Builder builder() {
            return new Builder();
        }

        private ExtensionServiceConfig(Builder builder) {
            setErrorHandlePolicy(builder.errorHandlePolicy);
            setExtensionServices(builder.extensionServices);
            setServiceParam(builder.serviceParam);
        }

        public String getErrorHandlePolicy() {
            return errorHandlePolicy;
        }

        public void setErrorHandlePolicy(String errorHandlePolicy) {
            this.errorHandlePolicy = errorHandlePolicy;
        }

        public List<ExtensionService> getExtensionServices() {
            return extensionServices;
        }

        public void setExtensionServices(List<ExtensionService> extensionServices) {
            this.extensionServices = extensionServices;
        }

        public ServiceParam getServiceParam() {
            return serviceParam;
        }

        public void setServiceParam(ServiceParam serviceParam) {
            this.serviceParam = serviceParam;
        }

        @Override
        public String toString() {
            return "ExtensionServiceConfig{" +
                    "errorHandlePolicy='" + errorHandlePolicy + '\'' +
                    ", extensionServices=" + extensionServices +
                    ", serviceParam=" + serviceParam +
                    '}';
        }

        public static final class Builder {

            private String errorHandlePolicy;

            private List<ExtensionService> extensionServices;

            private ServiceParam serviceParam;

            private Builder() {
            }

            public Builder errorHandlePolicy(String val) {
                errorHandlePolicy = val;
                return this;
            }

            public Builder extensionServices(List<ExtensionService> val) {
                extensionServices = val;
                return this;
            }

            public Builder serviceParam(ServiceParam val) {
                serviceParam = val;
                return this;
            }

            public ExtensionServiceConfig build() {
                return new ExtensionServiceConfig(this);
            }
        }
    }

    public static class ExtensionService {

        @JsonProperty("serviceName")
        private String serviceName;

        @JsonProperty("errorHandlePolicy")
        private String errorHandlePolicy;

        @JsonProperty("serviceParam")
        private ServiceParam serviceParam;

        public static Builder builder() {
            return new Builder();
        }

        private ExtensionService(Builder builder) {
            setServiceName(builder.serviceName);
            setErrorHandlePolicy(builder.errorHandlePolicy);
            setServiceParam(builder.serviceParam);
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getErrorHandlePolicy() {
            return errorHandlePolicy;
        }

        public void setErrorHandlePolicy(String errorHandlePolicy) {
            this.errorHandlePolicy = errorHandlePolicy;
        }

        public ServiceParam getServiceParam() {
            return serviceParam;
        }

        public void setServiceParam(ServiceParam serviceParam) {
            this.serviceParam = serviceParam;
        }

        @Override
        public String toString() {
            return "ExtensionService{" +
                    "serviceName='" + serviceName + '\'' +
                    ", errorHandlePolicy='" + errorHandlePolicy + '\'' +
                    ", serviceParam=" + serviceParam +
                    '}';
        }

        public static final class Builder {

            private String serviceName;

            private String errorHandlePolicy;

            private ServiceParam serviceParam;

            private Builder() {
            }

            public Builder serviceName(String val) {
                serviceName = val;
                return this;
            }

            public Builder errorHandlePolicy(String val) {
                errorHandlePolicy = val;
                return this;
            }

            public Builder serviceParam(ServiceParam val) {
                serviceParam = val;
                return this;
            }

            public ExtensionService build() {
                return new ExtensionService(this);
            }
        }
    }

    public static class Outputs {

        @JsonProperty("rtmpUrl")
        private String rtmpUrl;

        public static Builder builder() {
            return new Builder();
        }

        private Outputs(Builder builder) {
            setRtmpUrl(builder.rtmpUrl);
        }

        public String getRtmpUrl() {
            return rtmpUrl;
        }

        public void setRtmpUrl(String rtmpUrl) {
            this.rtmpUrl = rtmpUrl;
        }

        @Override
        public String toString() {
            return "Outputs{" +
                    "rtmpUrl='" + rtmpUrl + '\'' +
                    '}';
        }

        public static final class Builder {
            private String rtmpUrl;

            private Builder() {
            }

            public Builder rtmpUrl(String val) {
                rtmpUrl = val;
                return this;
            }

            public Outputs build() {
                return new Outputs(this);
            }
        }
    }

    public static class WebRecordingServiceParam implements ServiceParam {

        @JsonProperty("url")
        private String url;

        @JsonProperty("VideoBitrate")
        private Integer videoBitRate;

        @JsonProperty("videoFps")
        private Integer videoFPS;

        @JsonProperty("audioProfile")
        private Integer audioProfile;

        @JsonProperty("mobile")
        private Boolean mobile;

        @JsonProperty("videoWidth")
        private Integer videoWidth;

        @JsonProperty("videoHeight")
        private Integer videoHeight;

        @JsonProperty("maxRecordingHour")
        private Integer maxRecordingHour;

        @JsonProperty("maxVideoDuration")
        private Integer maxVideoDuration;

        @JsonProperty("onhold")
        private Boolean onhold;

        @JsonProperty("readyTimeout")
        private Integer readyTimeout;

        public static Builder builder() {
            return new Builder();
        }

        private WebRecordingServiceParam(Builder builder) {
            setUrl(builder.url);
            setVideoBitRate(builder.videoBitRate);
            setVideoFPS(builder.videoFPS);
            setAudioProfile(builder.audioProfile);
            setMobile(builder.mobile);
            setVideoWidth(builder.videoWidth);
            setVideoHeight(builder.videoHeight);
            setMaxRecordingHour(builder.maxRecordingHour);
            setMaxVideoDuration(builder.maxVideoDuration);
            setOnhold(builder.onhold);
            setReadyTimeout(builder.readyTimeout);
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getVideoBitRate() {
            return videoBitRate;
        }

        public void setVideoBitRate(Integer videoBitRate) {
            this.videoBitRate = videoBitRate;
        }

        public Integer getVideoFPS() {
            return videoFPS;
        }

        public void setVideoFPS(Integer videoFPS) {
            this.videoFPS = videoFPS;
        }

        public Integer getAudioProfile() {
            return audioProfile;
        }

        public void setAudioProfile(Integer audioProfile) {
            this.audioProfile = audioProfile;
        }

        public Boolean getMobile() {
            return mobile;
        }

        public void setMobile(Boolean mobile) {
            this.mobile = mobile;
        }

        public Integer getVideoWidth() {
            return videoWidth;
        }

        public void setVideoWidth(Integer videoWidth) {
            this.videoWidth = videoWidth;
        }

        public Integer getVideoHeight() {
            return videoHeight;
        }

        public void setVideoHeight(Integer videoHeight) {
            this.videoHeight = videoHeight;
        }

        public Integer getMaxRecordingHour() {
            return maxRecordingHour;
        }

        public void setMaxRecordingHour(Integer maxRecordingHour) {
            this.maxRecordingHour = maxRecordingHour;
        }

        public Integer getMaxVideoDuration() {
            return maxVideoDuration;
        }

        public void setMaxVideoDuration(Integer maxVideoDuration) {
            this.maxVideoDuration = maxVideoDuration;
        }

        public Boolean getOnhold() {
            return onhold;
        }

        public void setOnhold(Boolean onhold) {
            this.onhold = onhold;
        }

        public Integer getReadyTimeout() {
            return readyTimeout;
        }

        public void setReadyTimeout(Integer readyTimeout) {
            this.readyTimeout = readyTimeout;
        }

        @Override
        public String toString() {
            return "WebRecordingServiceParam{" +
                    "url='" + url + '\'' +
                    ", videoBitRate=" + videoBitRate +
                    ", videoFPS=" + videoFPS +
                    ", audioProfile=" + audioProfile +
                    ", mobile=" + mobile +
                    ", videoWidth=" + videoWidth +
                    ", videoHeight=" + videoHeight +
                    ", maxRecordingHour=" + maxRecordingHour +
                    ", maxVideoDuration=" + maxVideoDuration +
                    ", onhold=" + onhold +
                    ", readyTimeout=" + readyTimeout +
                    '}';
        }

        public static final class Builder {

            private String url;

            private Integer videoBitRate;

            private Integer videoFPS;

            private Integer audioProfile;

            private Boolean mobile;

            private Integer videoWidth;

            private Integer videoHeight;

            private Integer maxRecordingHour;

            private Integer maxVideoDuration;

            private Boolean onhold;

            private Integer readyTimeout;

            private Builder() {
            }

            public Builder url(String val) {
                url = val;
                return this;
            }

            public Builder videoBitRate(Integer val) {
                videoBitRate = val;
                return this;
            }

            public Builder videoFPS(Integer val) {
                videoFPS = val;
                return this;
            }

            public Builder audioProfile(Integer val) {
                audioProfile = val;
                return this;
            }

            public Builder mobile(Boolean val) {
                mobile = val;
                return this;
            }

            public Builder videoWidth(Integer val) {
                videoWidth = val;
                return this;
            }

            public Builder videoHeight(Integer val) {
                videoHeight = val;
                return this;
            }

            public Builder maxRecordingHour(Integer val) {
                maxRecordingHour = val;
                return this;
            }

            public Builder maxVideoDuration(Integer val) {
                maxVideoDuration = val;
                return this;
            }

            public Builder onhold(Boolean val) {
                onhold = val;
                return this;
            }

            public Builder readyTimeout(Integer val) {
                readyTimeout = val;
                return this;
            }

            public WebRecordingServiceParam build() {
                return new WebRecordingServiceParam(this);
            }
        }
    }

    public static class RtmpPublishServiceParam implements ServiceParam {

        @JsonProperty("outputs")
        private List<Outputs> outputs;

        public static Builder builder() {
            return new Builder();
        }

        private RtmpPublishServiceParam(Builder builder) {
            setOutputs(builder.outputs);
        }

        public List<Outputs> getOutputs() {
            return outputs;
        }

        public void setOutputs(List<Outputs> outputs) {
            this.outputs = outputs;
        }

        @Override
        public String toString() {
            return "RtmpPublishServiceParam{" +
                    "outputs=" + outputs +
                    '}';
        }

        public static final class Builder {

            private List<Outputs> outputs;

            private Builder() {
            }

            public Builder outputs(List<Outputs> val) {
                outputs = val;
                return this;
            }

            public RtmpPublishServiceParam build() {
                return new RtmpPublishServiceParam(this);
            }
        }
    }

    public static class BackgroundConfig {

        @JsonProperty("uid")
        private String uid;

        @JsonProperty("image_url")
        private String imageUrl;

        @JsonProperty("render_mode")
        private Integer renderMode;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Integer getRenderMode() {
            return renderMode;
        }

        public void setRenderMode(Integer renderMode) {
            this.renderMode = renderMode;
        }

        @Override
        public String toString() {
            return "BackgroundConfig{" +
                    "uid='" + uid + '\'' +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", renderMode=" + renderMode +
                    '}';
        }
    }

    public static class Builder {

        private String cname;

        private String uid;

        private StartClientRequest clientRequest;

        private Builder() {
        }

        public Builder cname(String cname) {
            this.cname = cname;
            return this;
        }

        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        public Builder clientRequest(StartClientRequest clientRequest) {
            this.clientRequest = clientRequest;
            return this;
        }

        public StartResourceReq build() {
            StartResourceReq startResourceReq = new StartResourceReq();
            startResourceReq.setCname(cname);
            startResourceReq.setUid(uid);
            startResourceReq.setClientRequest(clientRequest);
            return startResourceReq;
        }
    }
}
