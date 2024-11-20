package io.agora.rest.services.cloudrecording.scenario.mix.req;

import io.agora.rest.services.cloudrecording.api.req.UpdateResourceReq;

public class UpdateMixRecordingResourceClientReq {

    private UpdateResourceReq.StreamSubscribe streamSubscribe;

    public static Builder builder() {
        return new Builder();
    }

    private UpdateMixRecordingResourceClientReq(Builder builder) {
        setStreamSubscribe(builder.streamSubscribe);
    }

    public UpdateResourceReq.StreamSubscribe getStreamSubscribe() {
        return streamSubscribe;
    }

    public void setStreamSubscribe(UpdateResourceReq.StreamSubscribe streamSubscribe) {
        this.streamSubscribe = streamSubscribe;
    }

    @Override
    public String toString() {
        return "UpdateMixRecordingResourceClientReq{" +
                "streamSubscribe=" + streamSubscribe +
                '}';
    }

    public static final class Builder {
        private UpdateResourceReq.StreamSubscribe streamSubscribe;

        private Builder() {
        }

        public Builder streamSubscribe(UpdateResourceReq.StreamSubscribe val) {
            streamSubscribe = val;
            return this;
        }

        public UpdateMixRecordingResourceClientReq build() {
            return new UpdateMixRecordingResourceClientReq(this);
        }
    }
}
