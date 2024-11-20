package io.agora.rest.services.cloudrecording.scenario.mix.res;

import io.agora.rest.services.cloudrecording.api.res.QueryResourceRes;

public class QueryMixHLSAndMP4RecordingResourceRes {

    private String cname;

    private String uid;

    private String resourceId;

    private String sid;

    private QueryResourceRes.MixRecordingHLSAndMP4ServerResponse serverResponse;

    public static Builder builder() {
        return new Builder();
    }

    private QueryMixHLSAndMP4RecordingResourceRes(Builder builder) {
        setCname(builder.cname);
        setUid(builder.uid);
        setResourceId(builder.resourceId);
        setSid(builder.sid);
        setServerResponse(builder.serverResponse);
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

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public QueryResourceRes.MixRecordingHLSAndMP4ServerResponse getServerResponse() {
        return serverResponse;
    }

    public void setServerResponse(QueryResourceRes.MixRecordingHLSAndMP4ServerResponse serverResponse) {
        this.serverResponse = serverResponse;
    }

    @Override
    public String toString() {
        return "QueryMixHLSAndMP4RecordingResourceRes{" +
                "cname='" + cname + '\'' +
                ", uid='" + uid + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", sid='" + sid + '\'' +
                ", serverResponse=" + serverResponse +
                '}';
    }

    public static final class Builder {
        private String cname;
        private String uid;
        private String resourceId;
        private String sid;
        private QueryResourceRes.MixRecordingHLSAndMP4ServerResponse serverResponse;

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

        public Builder resourceId(String val) {
            resourceId = val;
            return this;
        }

        public Builder sid(String val) {
            sid = val;
            return this;
        }

        public Builder serverResponse(QueryResourceRes.MixRecordingHLSAndMP4ServerResponse val) {
            serverResponse = val;
            return this;
        }

        public QueryMixHLSAndMP4RecordingResourceRes build() {
            return new QueryMixHLSAndMP4RecordingResourceRes(this);
        }
    }
}
