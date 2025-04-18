package io.agora.rest.services.cloudrecording.api.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UpdateResourceReq {

    @JsonProperty("cname")
    private String cname;

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("clientRequest")
    private ClientRequest clientRequest;

    public static Builder builder() {
        return new Builder();
    }

    private UpdateResourceReq(Builder builder) {
        setCname(builder.cname);
        setUid(builder.uid);
        setClientRequest(builder.clientRequest);
    }

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

    public ClientRequest getClientRequest() {
        return clientRequest;
    }

    public void setClientRequest(ClientRequest clientRequest) {
        this.clientRequest = clientRequest;
    }

    @Override
    public String toString() {
        return "UpdateResourceReq{" +
                "cname='" + cname + '\'' +
                ", uid='" + uid + '\'' +
                ", clientRequest=" + clientRequest +
                '}';
    }

    public static class ClientRequest {

        @JsonProperty("streamSubscribe")
        private StreamSubscribe streamSubscribe;

        @JsonProperty("webRecordingConfig")
        private WebRecordingConfig webRecordingConfig;

        @JsonProperty("rtmpPublishConfig")
        private RtmpPublishConfig rtmpPublishConfig;

        public static Builder builder() {
            return new Builder();
        }

        private ClientRequest(Builder builder) {
            setStreamSubscribe(builder.streamSubscribe);
            setWebRecordingConfig(builder.webRecordingConfig);
            setRtmpPublishConfig(builder.rtmpPublishConfig);
        }

        public StreamSubscribe getStreamSubscribe() {
            return streamSubscribe;
        }

        public void setStreamSubscribe(StreamSubscribe streamSubscribe) {
            this.streamSubscribe = streamSubscribe;
        }

        public WebRecordingConfig getWebRecordingConfig() {
            return webRecordingConfig;
        }

        public void setWebRecordingConfig(WebRecordingConfig webRecordingConfig) {
            this.webRecordingConfig = webRecordingConfig;
        }

        public RtmpPublishConfig getRtmpPublishConfig() {
            return rtmpPublishConfig;
        }

        public void setRtmpPublishConfig(RtmpPublishConfig rtmpPublishConfig) {
            this.rtmpPublishConfig = rtmpPublishConfig;
        }

        @Override
        public String toString() {
            return "ClientRequest{" +
                    "streamSubscribe=" + streamSubscribe +
                    ", webRecordingConfig=" + webRecordingConfig +
                    ", rtmpPublishConfig=" + rtmpPublishConfig +
                    '}';
        }

        public static final class Builder {

            private StreamSubscribe streamSubscribe;

            private WebRecordingConfig webRecordingConfig;

            private RtmpPublishConfig rtmpPublishConfig;

            private Builder() {
            }

            public Builder streamSubscribe(StreamSubscribe val) {
                streamSubscribe = val;
                return this;
            }

            public Builder webRecordingConfig(WebRecordingConfig val) {
                webRecordingConfig = val;
                return this;
            }

            public Builder rtmpPublishConfig(RtmpPublishConfig val) {
                rtmpPublishConfig = val;
                return this;
            }

            public ClientRequest build() {
                return new ClientRequest(this);
            }
        }
    }

    /**
     * @brief Update subscription lists.
     * @since v0.4.0
     */
    public static class StreamSubscribe {
        /*
         * The audio subscription list.(Optional)
         */
        @JsonProperty("audioUidList")
        private AudioUIDList audioUidList;

        /**
         * The video subscription list.(Optional)
         */
        @JsonProperty("videoUidList")
        private VideoUIDList videoUidList;

        public static Builder builder() {
            return new Builder();
        }

        private StreamSubscribe(Builder builder) {
            setAudioUidList(builder.audioUidList);
            setVideoUidList(builder.videoUidList);
        }

        public AudioUIDList getAudioUidList() {
            return audioUidList;
        }

        public void setAudioUidList(AudioUIDList audioUidList) {
            this.audioUidList = audioUidList;
        }

        public VideoUIDList getVideoUidList() {
            return videoUidList;
        }

        public void setVideoUidList(VideoUIDList videoUidList) {
            this.videoUidList = videoUidList;
        }

        @Override
        public String toString() {
            return "StreamSubscribe{" +
                    "audioUidList=" + audioUidList +
                    ", videoUidList=" + videoUidList +
                    '}';
        }

        public static final class Builder {

            private AudioUIDList audioUidList;

            private VideoUIDList videoUidList;

            private Builder() {
            }

            public Builder audioUidList(AudioUIDList val) {
                audioUidList = val;
                return this;
            }

            public Builder videoUidList(VideoUIDList val) {
                videoUidList = val;
                return this;
            }

            public StreamSubscribe build() {
                return new StreamSubscribe(this);
            }
        }
    }

    /**
     * @brief Update audio subscription list.
     * @since v0.4.0
     */
    public static class AudioUIDList {

        /**
         * Specify which UIDs' audio streams to subscribe to.
         * 
         * If you want to subscribe to the audio stream of all UIDs, no need to set
         * this field.
         * 
         * Set as ["#allstream#"] to subscribe to the audio streams of all UIDs in
         * the channel.
         */
        @JsonProperty("subscribeAudioUids")
        private List<String> subscribeAudioUIDs;

        /**
         * Specify which UIDs' audio streams not to subscribe to.
         * 
         * The cloud recording service will subscribe to the audio streams of all other
         * UIDs except the specified ones.
         */
        @JsonProperty("unSubscribeAudioUids")
        private List<String> unsubscribeAudioUIDs;

        public static Builder builder() {
            return new Builder();
        }

        private AudioUIDList(Builder builder) {
            setSubscribeAudioUIDs(builder.subscribeAudioUIDs);
            setUnsubscribeAudioUIDs(builder.unsubscribeAudioUIDs);
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

        @Override
        public String toString() {
            return "AudioUIDList{" +
                    "subscribeAudioUIDs=" + subscribeAudioUIDs +
                    ", unsubscribeAudioUIDs=" + unsubscribeAudioUIDs +
                    '}';
        }

        public static final class Builder {

            private List<String> subscribeAudioUIDs;

            private List<String> unsubscribeAudioUIDs;

            private Builder() {
            }

            public Builder subscribeAudioUIDs(List<String> val) {
                subscribeAudioUIDs = val;
                return this;
            }

            public Builder unsubscribeAudioUIDs(List<String> val) {
                unsubscribeAudioUIDs = val;
                return this;
            }

            public AudioUIDList build() {
                return new AudioUIDList(this);
            }
        }
    }

    /**
     * @brief Update video subscription list.
     * @since v0.4.0
     */
    public static class VideoUIDList {

        /**
         * Specify which UIDs' video streams to subscribe to.
         * 
         * If you want to subscribe to the video stream of all UIDs, no need to set this
         * field.
         * 
         * Set as ["#allstream#"] to subscribe to the video streams of all UIDs in the
         * channel.
         */
        @JsonProperty("subscribeVideoUids")
        private List<String> subscribeVideoUIDs;

        /*
         * Specify which UIDs' video streams not to subscribe to.
         * 
         * The cloud recording service will subscribe to the video streams of all other
         * UIDs except the specified ones.
         */
        @JsonProperty("unSubscribeVideoUids")
        private List<String> unsubscribeVideoUIDs;

        public static Builder builder() {
            return new Builder();
        }

        private VideoUIDList(Builder builder) {
            setSubscribeVideoUIDs(builder.subscribeVideoUIDs);
            setUnsubscribeVideoUIDs(builder.unsubscribeVideoUIDs);
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

        @Override
        public String toString() {
            return "VideoUIDList{" +
                    "subscribeVideoUIDs=" + subscribeVideoUIDs +
                    ", unsubscribeVideoUIDs=" + unsubscribeVideoUIDs +
                    '}';
        }

        public static final class Builder {

            private List<String> subscribeVideoUIDs;

            private List<String> unsubscribeVideoUIDs;

            private Builder() {
            }

            public Builder subscribeVideoUIDs(List<String> val) {
                subscribeVideoUIDs = val;
                return this;
            }

            public Builder unsubscribeVideoUIDs(List<String> val) {
                unsubscribeVideoUIDs = val;
                return this;
            }

            public VideoUIDList build() {
                return new VideoUIDList(this);
            }
        }
    }

    /**
     * @brief Used to update the web page recording configurations.
     * @since v0.4.0
     */
    public static class WebRecordingConfig {
        /**
         * Set whether to pause the web page recording.
         * <p>
         * - true: Pauses web page recording and generating recording files.
         * <p>
         * - false: (Default) Continues web page recording and generates recording
         * files.
         * <p>
         * If you want to resume a paused web page recording, you can call the
         * update method and set onhold to false.
         */
        @JsonProperty("onhold")
        private Boolean onHold;

        public static Builder builder() {
            return new Builder();
        }

        private WebRecordingConfig(Builder builder) {
            setOnHold(builder.onHold);
        }

        public Boolean getOnHold() {
            return onHold;
        }

        public void setOnHold(Boolean onHold) {
            this.onHold = onHold;
        }

        @Override
        public String toString() {
            return "WebRecordingConfig{" +
                    "onHold=" + onHold +
                    '}';
        }

        public static final class Builder {

            private Boolean onHold;

            private Builder() {
            }

            public Builder onHold(Boolean val) {
                onHold = val;
                return this;
            }

            public WebRecordingConfig build() {
                return new WebRecordingConfig(this);
            }
        }
    }

    /**
     * @brief Used to update the configurations for pushing web page recording to
     *        the CDN.
     * @since v0.4.0
     */
    public static class RtmpPublishConfig {

        /**
         * The output of pushing web page recording to the CDN.
         */
        @JsonProperty("outputs")
        private List<UpdateOutput> outputs;

        public static Builder builder() {
            return new Builder();
        }

        private RtmpPublishConfig(Builder builder) {
            setOutputs(builder.outputs);
        }

        public List<UpdateOutput> getOutputs() {
            return outputs;
        }

        public void setOutputs(List<UpdateOutput> outputs) {
            this.outputs = outputs;
        }

        @Override
        public String toString() {
            return "RtmpPublishConfig{" +
                    "outputs=" + outputs +
                    '}';
        }

        public static final class Builder {

            private List<UpdateOutput> outputs;

            private Builder() {
            }

            public Builder outputs(List<UpdateOutput> val) {
                outputs = val;
                return this;
            }

            public RtmpPublishConfig build() {
                return new RtmpPublishConfig(this);
            }
        }
    }

    /**
     * @brief Used to update the output of pushing web page recording to the CDN.
     * @since v0.4.0
     */
    public static class UpdateOutput {

        /**
         * The CDN URL where you push the stream to.
         * <p>
         * URLs only support the RTMP and RTMPS protocols.
         * <p>
         * The maximum number of streams being pushed to the CDN is 1.
         */
        @JsonProperty("rtmpUrl")
        private String rtmpURL;

        public static Builder builder() {
            return new Builder();
        }

        private UpdateOutput(Builder builder) {
            setRtmpURL(builder.rtmpURL);
        }

        public String getRtmpURL() {
            return rtmpURL;
        }

        public void setRtmpURL(String rtmpURL) {
            this.rtmpURL = rtmpURL;
        }

        @Override
        public String toString() {
            return "UpdateOutput{" +
                    "rtmpURL='" + rtmpURL + '\'' +
                    '}';
        }

        public static final class Builder {

            private String rtmpURL;

            private Builder() {
            }

            public Builder rtmpURL(String val) {
                rtmpURL = val;
                return this;
            }

            public UpdateOutput build() {
                return new UpdateOutput(this);
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

    public static final class Builder {

        private String cname;

        private String uid;

        private ClientRequest clientRequest;

        private Builder() {
        }

        public Builder cname(String val) {
            cname = val;
            return this;
        }

        public Builder uid(String val) {
            uid = val;
            return this;
        }

        public Builder clientRequest(ClientRequest val) {
            clientRequest = val;
            return this;
        }

        public UpdateResourceReq build() {
            return new UpdateResourceReq(this);
        }
    }
}
