package io.agora.rest.services.cloudrecording.api.res;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AcquireResourceRes {
    @JsonProperty("cname")
    private String cname;

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("resourceId")
    private String resourceId;

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

    @Override
    public String toString() {
        return "AcquireResourceRes{" +
                "cname='" + cname + '\'' +
                ", uid='" + uid + '\'' +
                ", resourceId='" + resourceId + '\'' +
                '}';
    }
}
