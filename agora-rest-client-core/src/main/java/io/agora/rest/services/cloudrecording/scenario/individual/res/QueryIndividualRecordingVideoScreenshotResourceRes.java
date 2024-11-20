package io.agora.rest.services.cloudrecording.scenario.individual.res;

import io.agora.rest.services.cloudrecording.api.res.QueryResourceRes;

public class QueryIndividualRecordingVideoScreenshotResourceRes {

    private String cname;

    private String uid;

    private String resourceId;

    private String sid;

    private QueryResourceRes.QueryIndividualVideoScreenshotServerResponse serverResponse;

    public static Builder builder() {
        return new Builder();
    }

    private QueryIndividualRecordingVideoScreenshotResourceRes(Builder builder) {
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

    public QueryResourceRes.QueryIndividualVideoScreenshotServerResponse getServerResponse() {
        return serverResponse;
    }

    public void setServerResponse(QueryResourceRes.QueryIndividualVideoScreenshotServerResponse serverResponse) {
        this.serverResponse = serverResponse;
    }

    @Override
    public String toString() {
        return "QueryIndividualRecordingVideoScreenshotResourceRes{" +
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
        private QueryResourceRes.QueryIndividualVideoScreenshotServerResponse serverResponse;

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

        public Builder serverResponse(QueryResourceRes.QueryIndividualVideoScreenshotServerResponse val) {
            serverResponse = val;
            return this;
        }

        public QueryIndividualRecordingVideoScreenshotResourceRes build() {
            return new QueryIndividualRecordingVideoScreenshotResourceRes(this);
        }
    }
}
