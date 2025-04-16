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

    /**
     * @brief Configuration for the application.
     * @since v0.4.0
     */
    public static class AppsCollection {

        /**
         * The combination of cloud recording applications.(Optional)
         * <p>
         * The combination policy can be set to:
         * <p>
         * - "default": Use this policy except for postponed transcoding and audio
         * mixing.(Default)
         * <p>
         * - "postpone_transcoding": Use this policy if you need to postpone transcoding
         * or audio mixing.
         */
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

    /**
     * @brief Configuration for recorded audio and video streams.
     * @since v0.4.0
     */
    public static class RecordingConfig {

        /**
         * The channel type.(Required)
         * 
         * The channel type can be set to:
         * <p>
         * - 0: The communication use-case (Default)
         * <p>
         * - 1: Live streaming scene
         */
        @JsonProperty("channelType")
        private Integer channelType;

        /**
         * Subscribed media stream type.(Optional)
         * <p>
         * The stream type can be set to:
         * <p>
         * - 0: Subscribes to audio streams only. Suitable for smart voice review
         * use-cases.
         * <p>
         * - 1: Subscribes to video streams only.
         * <p>
         * - 2: Subscribes to both audio and video streams.(Default)
         */
        @JsonProperty("streamTypes")
        private Integer streamTypes;

        /**
         * Output mode of media stream.(Optional)
         * <p>
         * The stream mode can be set to:
         * <p>
         * - "default": Default mode.
         * Recording with audio transcoding will separately generate an M3U8 audio index
         * file and a video index file.
         * <p>
         * - "standard": Standard mode. Agora recommends using this mode.
         * Recording with audio transcoding will separately generate an M3U8 audio index
         * file, a video index file,
         * and a merged audio and video index file. If VP8 encoding is used on the Web
         * client, a merged MPD audio-video index file will be generated.
         * <p>
         * - "original": Original encoding mode. It is applicable to individual
         * non-transcoding audio recording.
         * This field only takes effect when subscribing to audio only (streamTypes is
         * 0).
         * During the recording process, the audio is not transcoded, and an M3U8 audio
         * index file is generated.
         */
        @JsonProperty("streamMode")
        private String streamMode;

        /**
         * The decryption mode.(Optional)
         * <p>
         * If you have set channel encryption in the SDK client,
         * you need to set the same decryption mode for the cloud recording service.
         * <p>
         * The decryption mode can be set to:
         * <p>
         * - 0: Not encrypted.(Default)
         * <p>
         * - 1: AES_128_XTS encryption mode. 128-bit AES encryption, XTS mode.
         * <p>
         * - 2: AES_128_ECB encryption mode. 128-bit AES encryption, ECB mode.
         * <p>
         * - 3: AES_256_XTS encryption mode. 256-bit AES encryption, XTS mode.
         * <p>
         * - 4: SM4_128_ECB encryption mode. 128-bit SM4 encryption, ECB mode.
         * <p>
         * - 5: AES_128_GCM encryption mode. 128-bit AES encryption, GCM mode.
         * <p>
         * - 6: AES_256_GCM encryption mode. 256-bit AES encryption, GCM mode.
         * <p>
         * - 7: AES_128_GCM2 encryption mode. 128-bit AES encryption, GCM mode.
         * Compared to AES_128_GCM encryption mode, AES_128_GCM2 encryption mode has
         * higher security and requires setting a key and salt.
         * <p>
         * - 8: AES_256_GCM2 encryption mode. 256-bit AES encryption, GCM mode.
         * Compared to the AES_256_GCM encryption mode, the AES_256_GCM2 encryption mode
         * is more secure and requires setting a key and salt.
         */
        @JsonProperty("decryptionMode")
        private Integer decryptionMode;

        /**
         * Keys related to encryption and decryption.(Optional)
         * <p>
         * Only needs to be set when decryptionMode is not 0.
         */
        @JsonProperty("secret")
        private String secret;

        /**
         * Salt related to encryption and decryption.(Optional)
         * <p>
         * Base64 encoding, 32-bit bytes.
         * <p>
         * Only need to set when decryptionMode is 7 or 8.
         */
        @JsonProperty("salt")
        private String salt;

        /**
         * Set the sampling rate, bitrate, encoding mode, and number of channels for the
         * output audio.(Optional)
         * <p>
         * The audio profile can be set to:
         * <p>
         * - 0: 48 kHz sampling rate, music encoding, mono audio channel, and the
         * encoding bitrate is about 48 Kbps.（Default）
         * <p>
         * - 1: 48 kHz sampling rate, music encoding, mono audio channel, and the
         * encoding bitrate is approximately 128 Kbps.
         * <p>
         * - 2: 48 kHz sampling rate, music encoding, stereo audio channel, and the
         * encoding bitrate is approximately 192 Kbps.
         */
        @JsonProperty("audioProfile")
        private Integer audioProfile;

        /**
         * Sets the stream type of the remote video.(Optional)
         * <p>
         * If you enable dual-stream mode in the SDK client,
         * you can choose to subscribe to either the high-quality video stream or the
         * low-quality video stream.
         * <p>
         * The video stream type can be set to:
         * <p>
         * - 0: High-quality video stream refers to high-resolution and high-bitrate
         * video stream.(Default)
         * <p>
         * - 1: Low-quality video stream refers to low-resolution and low-bitrate video
         * stream.
         */
        @JsonProperty("videoStreamType")
        private Integer videoStreamType;

        /**
         * Maximum channel idle time.(Optional)
         * <p>
         * The unit is seconds.
         * <p>
         * The value range is [5,259200].
         * <p>
         * The default value is 30.
         */
        @JsonProperty("maxIdleTime")
        private Integer maxIdleTime;

        /**
         * Configurations for transcoded video output.(Optional)
         */
        @JsonProperty("transcodingConfig")
        private TranscodingConfig transcodingConfig;

        /**
         * Specify which UIDs' audio streams to subscribe to.(Optional)
         * <p>
         * If you want to subscribe to the audio stream of all UIDs, no need to set this
         * field.
         */
        @JsonProperty("subscribeAudioUids")
        private List<String> subscribeAudioUIDs;

        /**
         * Specify which UIDs' audio streams not to subscribe to.(Optional)
         * <p>
         * The cloud recording service will subscribe to the video streams of all UIDs
         * except the specified ones.
         */
        @JsonProperty("unSubscribeAudioUids")
        private List<String> unsubscribeAudioUIDs;

        /**
         * Specify which UIDs' video streams to subscribe to.(Optional)
         * <p>
         * If you want to subscribe to the video streams of all UIDs, no need to set
         * this field.
         */
        @JsonProperty("subscribeVideoUids")
        private List<String> subscribeVideoUIDs;

        /**
         * Specify which UIDs' video streams not to subscribe to.(Optional)
         * <p>
         * The cloud recording service will subscribe to the video streams of all UIDs
         * except the specified ones.
         */
        @JsonProperty("unSubscribeVideoUids")
        private List<String> unsubscribeVideoUIDs;

        /**
         * Estimated peak number of subscribers.(Optional)
         * <p>
         * The subscription group can be set to:
         * <p>
         * - 0: 1 to 2 UIDs.
         * <p>
         * - 1: 3 to 7 UIDs.
         * <p>
         * - 2: 8 to 12 UIDs
         * <p>
         * - 3: 13 to 17 UIDs
         * <p>
         * - 4: 18 to 32 UIDs.
         * <p>
         * - 5: 33 to 49 UIDs.
         */
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

    /**
     * @brief Container format.
     * @since v0.4.0
     */
    public static class Container {

        /**
         * The container format of the file.(Optional)
         * <p>
         * The container format can be set to:
         * <p>
         * - "mp4": the default format for the postponed transcoding. MP4 format.
         * <p>
         * - "mp3": The default format for postponed audio mixing. MP3 format.
         * <p>
         * - "m4a": M4A format.
         * <p>
         * - "aac": AAC format.
         */
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

    /**
     * @brief Configurations for the recorded files generated under postponed
     *        transcoding or audio mixing.
     * @since v0.4.0
     */
    public static class TranscodeOptions {
        /**
         * The container format of the recorded files.(Optional) See
         * {@link TranscodeOptions.Container}.
         */
        @JsonProperty("container")
        private Container container;

        /**
         * The configuration for transcoding.(Required) See
         * {@link TranscodeOptions.TransConfig}.
         */
        @JsonProperty("transConfig")
        private TransConfig transConfig;

        /**
         * Audio properties of the file. See {@link TranscodeOptions.Audio}.
         */
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

    /**
     * @brief Configuration for transcoding.
     * @since v0.4.0
     */
    public static class TransConfig {

        /**
         * The transcoding mode.(Required)
         * <p>
         * The transcoding mode can be set to:
         * <p>
         * - "postponeTranscoding": Postponed transcoding.
         * <p>
         * - "audioMix": Postponed audio mixing.
         */
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

    /**
     * @brief Audio properties of the file.
     * @since v0.4.0
     */
    public static class Audio {

        /**
         * Audio sampling rate.(Optional)
         * <p>
         * The sampling rate can be set to:
         * <p>
         * - "48000": 48 kHz.（Default）
         * <p>
         * - "32000": 32 kHz.
         * <p>
         * - "16000": 16 kHz.
         */
        @JsonProperty("sampleRate")
        private String sampleRate;

        /**
         * Audio bitrate(Kbps).(Optional)
         * <p>
         * It supports a customized value and the default value is "48000".
         */
        @JsonProperty("bitrate")
        private String bitRate;

        /**
         * Audio channels.(Optional)
         * <p>
         * The channels can be set to:
         * <p>
         * - "1": Mono.
         * <p>
         * - "2": Stereo.（Default）
         */
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

    /**
     * @brief Configurations for transcoded video output.
     * @since v0.4.0
     */
    public static class TranscodingConfig {

        /**
         * The width of the video (pixels).(Optional)
         * <p>
         * Width × Height cannot exceed 1920 × 1080.
         * <p>
         * The default value is 360.
         */
        @JsonProperty("width")
        private Integer width;

        /**
         * The height of the video (pixels).(Optional)
         * <p>
         * width × height cannot exceed 1920 × 1080.
         * <p>
         * The default value is 640.
         */
        @JsonProperty("height")
        private Integer height;

        /**
         * The frame rate of the video (fps).(Optional)
         * <p>
         * The default value is 15.
         */
        @JsonProperty("fps")
        private Integer fps;

        /**
         * The bitrate of the video (Kbps).(Optional)
         * <p>
         * The default value is 1500.
         */
        @JsonProperty("bitrate")
        private Integer bitrate;

        /**
         * Only need to set it in vertical layout.(Optional)
         * <p>
         * Specify the user ID of the large video window.
         */
        @JsonProperty("maxResolutionUid")
        private String maxResolutionUid;

        /**
         * Composite video layout.(Optional)
         * <p>
         * The video layout can be set to:
         * <p>
         * - 0: Floating layout(Default).
         * The first user to join the channel will be displayed as a large window,
         * filling the entire canvas.
         * The video windows of other users will be displayed as small windows, arranged
         * horizontally from bottom to top,
         * up to 4 rows, each with 4 windows. It supports up to a total of 17 windows of
         * different users' videos.
         * <p>
         * - 1: Adaptive layout.
         * Automatically adjust the size of each user's video window according to the
         * number of users,
         * each user's video window size is consistent, and supports up to 17 windows.
         * <p>
         * - 2: Vertical layout.
         * The maxResolutionUid is specified to display the large video window on the
         * left side of the screen,
         * and the small video windows of other users are vertically arranged on the
         * right side,
         * with a maximum of two columns, 8 windows per column, supporting up to 17
         * windows.
         * <p>
         * - 3: Customized layout.
         * Set the layoutConfig field to customize the mixed layout.
         */
        @JsonProperty("mixedVideoLayout")
        private Integer mixedVideoLayout;

        /**
         * The background color of the video canvas.(Optional)
         * <p>
         * The RGB color table is supported, with strings formatted as a # sign and 6
         * hexadecimal digits.
         * <p>
         * The default value is "#000000", representing the black color.
         */
        @JsonProperty("backgroundColor")
        private String backgroundColor;

        /**
         * The URL of the background image of the video canvas.(Optional)
         * <p>
         * The display mode of the background image is set to cropped mode.
         * <p>
         * Cropped mode: Will prioritize to ensure that the screen is filled.
         * <p>
         * The background image size is scaled in equal proportion until the entire
         * screen is filled with the background image.
         * <p>
         * If the length and width of the background image differ from the video window,
         * the background image will be peripherally cropped to fill the window.
         */
        @JsonProperty("backgroundImage")
        private String backgroundImage;

        /**
         * The URL of the default user screen background image.(Optional)
         */
        @JsonProperty("defaultUserBackgroundImage")
        private String defaultUserBackgroundImage;

        /**
         * Configurations of user's layout.(Optional)
         */
        @JsonProperty("layoutConfig")
        private List<LayoutConfig> layoutConfig;

        /**
         * Configurations of user's background image.(Optional)
         */
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

    /**
     * @brief Configurations of user's layout.
     * @since v0.4.0
     */
    public static class LayoutConfig {

        /**
         * The content of the string is the UID of the user to be displayed in the area,
         * 32-bit unsigned integer.
         */
        @JsonProperty("uid")
        private String uid;

        /**
         * The relative value of the horizontal coordinate of the upper-left corner of
         * the screen, accurate to six decimal places.
         * <p>
         * Layout from left to right, with 0.0 at the far left and 1.0 at the far right.
         * <p>
         * This field can also be set to the integer 0 or 1.
         * <p>
         * The value range is [0,1].
         */
        @JsonProperty("x_axis")
        private Float xAxis;

        /**
         * The relative value of the vertical coordinate of the upper-left corner of
         * this screen in the screen, accurate to six decimal places.
         * <p>
         * Layout from top to bottom, with 0.0 at the top and 1.0 at the bottom.
         * <p>
         * This field can also be set to the integer 0 or 1.
         * <p>
         * The value range is [0,1].
         */
        @JsonProperty("y_axis")
        private Float yAxis;

        /**
         * The relative value of the width of this screen, accurate to six decimal
         * places.
         * <p>
         * This field can also be set to the integer 0 or 1.
         * <p>
         * The value range is [0,1].
         */
        @JsonProperty("width")
        private Float width;

        /**
         * The relative value of the height of this screen, accurate to six decimal
         * places.
         * <p>
         * This field can also be set to the integer 0 or 1.
         * <p>
         * The value range is [0,1].
         */
        @JsonProperty("height")
        private Float height;

        /**
         * The transparency of the user's video window. Accurate to six decimal places.
         * <p>
         * 0.0 means the user's video window is transparent, and 1.0 indicates that it
         * is completely opaque.
         * <p>
         * The value range is [0,1].
         * <p>
         * The default value is 1.
         */
        @JsonProperty("alpha")
        private Float alpha;

        /**
         * The display mode of users' video windows.
         * <p>
         * The rendering mode can be set to:
         * <p>
         * - 0: Cropped mode.(Default)
         * Prioritize to ensure the screen is filled.
         * The video window size is proportionally scaled until it fills the screen.
         * If the video's length and width differ from the video window,
         * the video stream will be cropped from its edges to fit the window,
         * under the aspect ratio set for the video window.
         * <p>
         * - 1: Fit mode.
         * Prioritize to ensure that all video content is displayed.
         * The video size is scaled proportionally until one side of the video window is
         * aligned with the screen border.
         * If the video scale does not comply with the window size,
         * the video will be scaled to fill the screen while maintaining its aspect
         * ratio.
         * <p>
         * This scaling may result in a black border around the edges of the video.
         */
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

    /**
     * @brief Configuration for the recorded files.
     * @since v0.4.0
     */
    public static class RecordingFileConfig {

        /**
         * Type of video files generated by recording.(Optional)
         * <p>
         * The file type can be set to:
         * <p>
         * - "hls": default value. M3U8 and TS files.
         * <p>
         * - "mp4": MP4 files.
         */
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

    /**
     * @brief Configuration for screenshot capture.
     * @since v0.4.0
     */
    public static class SnapshotConfig {

        /**
         * The cycle for regular screenshots in the cloud recording.(Optional)
         * <p>
         * The unit is seconds.
         * <p>
         * The value range is [5,3600].
         * <p>
         * The default value is 10.
         */
        @JsonProperty("captureInterval")
        private Integer captureInterval;

        /**
         * The file format of screenshots.
         * <p>
         * Currently only ["jpg"] is supported, which generates screenshot files in JPG
         * format.
         */
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

    /**
     * @brief Configuration for third-party cloud storage.
     * @since v0.4.0
     */
    public static class StorageConfig {
        /**
         * Third-party cloud storage platforms.(Required)
         * <p>
         * The vendor can be set to:
         * <p>
         * - 1: Amazon S3
         * <p>
         * - 2: Alibaba Cloud
         * <p>
         * - 3: Tencent Cloud
         * <p>
         * - 5: Microsoft Azure
         * <p>
         * - 6: Google Cloud
         * <p>
         * - 7: Huawei Cloud
         * <p>
         * - 8: Baidu IntelligentCloud
         */
        @JsonProperty("vendor")
        private Integer vendor;

        /**
         * The region information specified for the third-party cloud storage.(Required)
         */
        @JsonProperty("region")
        private Integer region;

        /**
         * Third-party cloud storage bucket.(Required)
         */
        @JsonProperty("bucket")
        private String bucket;

        /**
         * The access key of third-party cloud storage.(Required)
         */
        @JsonProperty("accessKey")
        private String accessKey;

        /**
         * The secret key of third-party cloud storage.(Required)
         */
        @JsonProperty("secretKey")
        private String secretKey;

        /**
         * The storage location of the recorded files in the third-party cloud is
         * related to the prefix of the file name.(Optional)
         */
        @JsonProperty("fileNamePrefix")
        private List<String> fileNamePrefix;

        /**
         * A temporary security token for third-party cloud storage.
         * <p>
         * This token is issued by the cloud service provider's Security Token Service
         * (STS) and used to grant limited access rights to third-party cloud storage
         * resources.
         * <p>
         * Currently supported cloud service providers include only the following:
         * <p>
         * - 1: Amazon S3
         * <p>
         * - 2: Alibaba Cloud
         * <p>
         * - 3: Tencent Cloud.
         */
        @JsonProperty("stsToken")
        private String stsToken;

        /**
         * The stsToken expiration timestamp used to mark UNIX time, in
         * seconds.(Optional)
         */
        @JsonProperty("stsExpiration")
        private Integer stsExpiration;

        /**
         * Third-party cloud storage services will encrypt and tag the uploaded
         * recording files according to this field.(Optional)
         */
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

    /**
     * @brief Third-party cloud storage services will encrypt and tag the uploaded
     *        recording files according to this field.
     * @since v0.4.0
     */
    public static class ExtensionParams {
        /**
         * The encryption mode.(Required)
         * <p>
         * This field is only applicable to Amazon S3,
         * and the value can be set to:
         * <p>
         * - "kms": KMS encryption.
         * <p>
         * - "aes256": AES256 encryption.
         */
        @JsonProperty("sse")
        private String sse;

        /**
         * Tag content.(Required)
         * <p>
         * After setting this field, the third-party cloud storage service
         * will tag the uploaded recording files according to the content of this tag.
         * <p>
         * This field is only applicable to Alibaba Cloud and Amazon S3.
         * For other third-party cloud storage services, this field is not required.
         */
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

    /**
     * @brief Configurations for extended services.
     * @since v0.4.0
     */
    public static class ExtensionServiceConfig {
        /**
         * Error handling policy.(Optional)
         * <p>
         * You can only set it to the default value, "error_abort",
         * which means that once an error occurs to an extension service,
         * all other non-extension services, such as stream subscription, also stop.
         */
        @JsonProperty("errorHandlePolicy")
        private String errorHandlePolicy;

        /**
         * Extended services.(Required)
         */
        @JsonProperty("extensionServices")
        private List<ExtensionService> extensionServices;

        public static Builder builder() {
            return new Builder();
        }

        private ExtensionServiceConfig(Builder builder) {
            setErrorHandlePolicy(builder.errorHandlePolicy);
            setExtensionServices(builder.extensionServices);
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

        @Override
        public String toString() {
            return "ExtensionServiceConfig{" +
                    "errorHandlePolicy='" + errorHandlePolicy + '\'' +
                    ", extensionServices=" + extensionServices +
                    '}';
        }

        public static final class Builder {

            private String errorHandlePolicy;

            private List<ExtensionService> extensionServices;

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

            public ExtensionServiceConfig build() {
                return new ExtensionServiceConfig(this);
            }
        }
    }

    /**
     * @brief Configuration for extended services.
     * @since v0.4.0
     */
    public static class ExtensionService {
        /**
         * Name of the extended service.(Required)
         * <p>
         * The service name can be set to:
         * <p>
         * - "web_recorder_service": Represents the extended service is web page
         * recording.
         * <p>
         * - "rtmp_publish_service": Represents the extended service is to push web page
         * recording to the CDN.
         */
        @JsonProperty("serviceName")
        private String serviceName;

        /**
         * Error handling strategy within the extension service.(Optional)
         * <p>
         * The error handling strategy can be set to:
         * <p>
         * - "error_abort": the default and only value during web page recording.
         * Stop other extension services when the current extension service encounters
         * an error.
         * <p>
         * - "error_ignore": The only default value when you push the web page recording
         * to the CDN.
         * <p>
         * Other extension services are not affected when the current extension service
         * encounters an error.
         */
        @JsonProperty("errorHandlePolicy")
        private String errorHandlePolicy;

        /**
         * Specific configurations for extension services.(Required)
         * <p>
         * - "WebRecordingServiceParam" for web page recording. See
         * WebRecordingServiceParam for details.
         * <p>
         * - "RtmpPublishServiceParam" for pushing web page recording to the CDN. See
         * RtmpPublishServiceParam for details.
         */
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

    /**
     * @brief The CDN address to which you push the stream.
     * @since v0.4.0
     */
    public static class Outputs {
        /**
         * The CDN address to which you push the stream.(Required)
         */
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

    /**
     * @brief Service parameter configuration for web page recording.
     * @since v0.4.0
     */
    public static class WebRecordingServiceParam implements ServiceParam {
        /**
         * The address of the page to be recorded.(Required)
         */
        @JsonProperty("url")
        private String url;

        /**
         * The bitrate of the output video (Kbps).(Optional)
         * <p>
         * For different output video resolutions, the default value of videoBitrate is
         * different:
         * <p>
         * - Output video resolution is greater than or equal to 1280 × 720, and the
         * default value is 2000.
         * <p>
         * - Output video resolution is less than 1280 × 720, and the default value is
         * 1500.
         */
        @JsonProperty("VideoBitrate")
        private Integer videoBitRate;

        /**
         * The frame rate of the output video (fps).(Optional)
         * <p>
         * The value range is [5,60].
         * <p>
         * The default value is 15.
         */
        @JsonProperty("videoFps")
        private Integer videoFPS;

        /**
         * Sampling rate, bitrate, encoding mode, and number of channels for the audio
         * output.(Required)
         * <p>
         * The audio profile can be set to:
         * <p>
         * - 0: 48 kHz sampling rate, music encoding, mono audio channel, and the
         * encoding bitrate is approximately 48 Kbps.
         * <p>
         * - 1: 48 kHz sampling rate, music encoding, mono audio channel, and the
         * encoding bitrate is approximately 128 Kbps.
         * <p>
         * - 2: 48 kHz sampling rate, music encoding, stereo audio channel, and the
         * encoding bitrate is approximately 192 Kbps.
         */
        @JsonProperty("audioProfile")
        private Integer audioProfile;

        /**
         * Whether to enable the mobile web mode.(Optional)
         * <p>
         * - true: Enables the mode. After enabling, the recording service uses the
         * mobile web rendering mode to record the current page.
         * <p>
         * - false: Disables the mode.(Default)
         */
        @JsonProperty("mobile")
        private Boolean mobile;

        /**
         * The output video width (pixel).(Required)
         * <p>
         * The product of videoWidth and videoHeight should be less than or equal to
         * 1920 × 1080.
         */
        @JsonProperty("videoWidth")
        private Integer videoWidth;

        /**
         * The output video height (pixel).(Required)
         * <p>
         * The product of videoWidth and videoHeight should be less than or equal to
         * 1920 × 1080.
         */
        @JsonProperty("videoHeight")
        private Integer videoHeight;

        /**
         * The maximum duration of web page recording (hours). (Required)
         * <p>
         * The web page recording will automatically stop after exceeding this value.
         * <p>
         * The value range is [1,720].
         */
        @JsonProperty("maxRecordingHour")
        private Integer maxRecordingHour;

        /**
         * Maximum length of MP4 slice file generated by web page recording, in
         * minutes.(Optional)
         * <p>
         * During the web page recording process, the recording service will create a
         * new MP4 slice file when the current MP4 file duration exceeds the
         * maxVideoDuration approximately.
         * <p>
         * The value range is [30,240].
         * <p>
         * The default value is 120.
         */
        @JsonProperty("maxVideoDuration")
        private Integer maxVideoDuration;

        /**
         * Whether to pause page recording when starting a web page recording task.
         * (Optional)
         * <p>
         * - true: Pauses the web page recording that has been started. Immediately
         * pause the recording after starting the web page recording task. The
         * recording service will open and render the page to be recorded, but will
         * not generate slice files.
         * <p>
         * - false: Starts a web page recording task and performs web page
         * recording.(Default)
         */
        @JsonProperty("onhold")
        private Boolean onhold;

        /**
         * Set the page load timeout in seconds.(Optional)
         * <p>
         * The value range is [0,60].
         * <p>
         * The default value is 0.
         */
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

    /**
     * @brief Service parameter configuration for pushing web page recording to the
     *        CDN.
     *
     * @since v0.4.0
     */
    public static class RtmpPublishServiceParam implements ServiceParam {

        /**
         * The array of CDN addresses to which you push the stream.(Required)
         */
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

    /**
     * @brief Configurations of user's background image.
     * 
     * @since v0.4.0
     */
    public static class BackgroundConfig {

        /**
         * The string content is the UID.(Required)
         */
        @JsonProperty("uid")
        private String uid;

        /**
         * The URL of the user's background image.(Required)
         * <p>
         * After setting the background image, if the user stops sending the video
         * stream for more than 3.5 seconds,
         * the screen will switch to the background image.
         * <p>
         * URL supports the HTTP and HTTPS protocols, and the image formats supported
         * are JPG and BMP.
         * <p>
         * The image size must not exceed 6 MB.
         * <p>
         * The settings will only take effect after the recording service successfully
         * downloads the image;
         * if the download fails, the settings will not take effect.
         * <p>
         * Different field settings may overlap each other.
         */
        @JsonProperty("image_url")
        private String imageUrl;

        /**
         * The display mode of users' video windows.(Optional)
         * <p>
         * The value can be set to:
         * <p>
         * - 0: cropped mode.(Default)
         * Prioritize to ensure the screen is filled.
         * The video window size is proportionally scaled until it fills the screen.
         * If the video's length and width differ from the video window,
         * the video stream will be cropped from its edges to fit the window, under the
         * aspect ratio set for the video window.
         * <p>
         * - 1: Fit mode.
         * Prioritize to ensure that all video content is displayed.
         * The video size is scaled proportionally until one side of the video window is
         * aligned with the screen border.
         */
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
