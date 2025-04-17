package io.agora.rest.services.cloudrecording.api.res;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @brief Returned by the various of cloud recording scenarios start API.
 * @since v0.4.0
 */
public class StartResourceRes {
    /**
     * The name of the channel to be recorded.
     */
    @JsonProperty("cname")
    private String cname;

    /**
     * The user ID used by the cloud recording service in the RTC channel to
     * identify the recording service in the channel.
     */
    @JsonProperty("uid")
    private String uid;

    /**
     * Unique identifier of the resource.
     */
    @JsonProperty("resourceId")
    private String resourceId;

    /**
     * Unique identifier of the recording session.
     */
    @JsonProperty("sid")
    private String sid;

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

    @Override
    public String toString() {
        return "StartResourceRes{" +
                "cname='" + cname + '\'' +
                ", uid='" + uid + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", sid='" + sid + '\'' +
                '}';
    }
}
