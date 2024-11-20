package io.agora.rest.services.cloudrecording.scenario.web.req;

import io.agora.rest.services.cloudrecording.api.req.UpdateResourceReq;

public class UpdateWebRecordingResourceClientReq {

    private UpdateResourceReq.WebRecordingConfig webRecordingConfig;

    private UpdateResourceReq.RtmpPublishConfig rtmpPublishConfig;

    public static Builder builder() {
        return new Builder();
    }

    private UpdateWebRecordingResourceClientReq(Builder builder) {
        setWebRecordingConfig(builder.webRecordingConfig);
        setRtmpPublishConfig(builder.rtmpPublishConfig);
    }

    public UpdateResourceReq.WebRecordingConfig getWebRecordingConfig() {
        return webRecordingConfig;
    }

    public void setWebRecordingConfig(UpdateResourceReq.WebRecordingConfig webRecordingConfig) {
        this.webRecordingConfig = webRecordingConfig;
    }

    public UpdateResourceReq.RtmpPublishConfig getRtmpPublishConfig() {
        return rtmpPublishConfig;
    }

    public void setRtmpPublishConfig(UpdateResourceReq.RtmpPublishConfig rtmpPublishConfig) {
        this.rtmpPublishConfig = rtmpPublishConfig;
    }

    @Override
    public String toString() {
        return "UpdateWebRecordingResourceClientReq{" +
                "webRecordingConfig=" + webRecordingConfig +
                ", rtmpPublishConfig=" + rtmpPublishConfig +
                '}';
    }

    public static final class Builder {
        private UpdateResourceReq.WebRecordingConfig webRecordingConfig;
        private UpdateResourceReq.RtmpPublishConfig rtmpPublishConfig;

        private Builder() {
        }

        public Builder webRecordingConfig(UpdateResourceReq.WebRecordingConfig val) {
            webRecordingConfig = val;
            return this;
        }

        public Builder rtmpPublishConfig(UpdateResourceReq.RtmpPublishConfig val) {
            rtmpPublishConfig = val;
            return this;
        }

        public UpdateWebRecordingResourceClientReq build() {
            return new UpdateWebRecordingResourceClientReq(this);
        }
    }
}
