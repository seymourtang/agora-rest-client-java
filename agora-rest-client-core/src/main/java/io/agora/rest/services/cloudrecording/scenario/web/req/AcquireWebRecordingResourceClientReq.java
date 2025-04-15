package io.agora.rest.services.cloudrecording.scenario.web.req;

import java.util.List;

/**
 * @brief Client request for acquiring web cloud recording resources.
 * @since v0.4.0
 */
public class AcquireWebRecordingResourceClientReq {

    /**
     * The validity period for calling the cloud recording RESTful API.
     * <p>
     * Start calculating after you successfully initiate the cloud recording service
     * and obtain the sid (Recording ID).
     * <p>
     * The calculation unit is hours.
     * <p>
     * The value range is [1,720]. The default value is 72.
     */
    private Integer resourceExpiredHour;

    /**
     * The resourceId of another or several other recording tasks.
     */
    private List<String> excludeResourceIds;

    /**
     * Specify regions that the cloud recording service can access.
     * <p>
     * The region can be set to:
     * <p>
     * - 0: Closest to request origin (default)
     * <p>
     * - 1: China
     * <p>
     * - 2: Southeast Asia
     * <p>
     * - 3: Europe
     * <p>
     * - 4: North America
     */
    private Integer regionAffinity;

    /**
     * The start parameter improves availability and optimizes load balancing.
     */
    private StartWebRecordingResourceClientReq startParameter;

    public static Builder builder() {
        return new Builder();
    }

    private AcquireWebRecordingResourceClientReq(Builder builder) {
        setResourceExpiredHour(builder.resourceExpiredHour);
        setExcludeResourceIds(builder.excludeResourceIds);
        setRegionAffinity(builder.regionAffinity);
        setStartParameter(builder.startParameter);
    }

    public Integer getResourceExpiredHour() {
        return resourceExpiredHour;
    }

    public void setResourceExpiredHour(Integer resourceExpiredHour) {
        this.resourceExpiredHour = resourceExpiredHour;
    }

    public List<String> getExcludeResourceIds() {
        return excludeResourceIds;
    }

    public void setExcludeResourceIds(List<String> excludeResourceIds) {
        this.excludeResourceIds = excludeResourceIds;
    }

    public Integer getRegionAffinity() {
        return regionAffinity;
    }

    public void setRegionAffinity(Integer regionAffinity) {
        this.regionAffinity = regionAffinity;
    }

    public StartWebRecordingResourceClientReq getStartParameter() {
        return startParameter;
    }

    public void setStartParameter(StartWebRecordingResourceClientReq startParameter) {
        this.startParameter = startParameter;
    }

    @Override
    public String toString() {
        return "AcquireWebRecordingResourceClientReq{" +
                "resourceExpiredHour=" + resourceExpiredHour +
                ", excludeResourceIds=" + excludeResourceIds +
                ", regionAffinity=" + regionAffinity +
                ", startParameter=" + startParameter +
                '}';
    }

    public static final class Builder {
        private Integer resourceExpiredHour;
        private List<String> excludeResourceIds;
        private Integer regionAffinity;
        private StartWebRecordingResourceClientReq startParameter;

        private Builder() {
        }

        public Builder resourceExpiredHour(Integer val) {
            resourceExpiredHour = val;
            return this;
        }

        public Builder excludeResourceIds(List<String> val) {
            excludeResourceIds = val;
            return this;
        }

        public Builder regionAffinity(Integer val) {
            regionAffinity = val;
            return this;
        }

        public Builder startParameter(StartWebRecordingResourceClientReq val) {
            startParameter = val;
            return this;
        }

        public AcquireWebRecordingResourceClientReq build() {
            return new AcquireWebRecordingResourceClientReq(this);
        }
    }
}
