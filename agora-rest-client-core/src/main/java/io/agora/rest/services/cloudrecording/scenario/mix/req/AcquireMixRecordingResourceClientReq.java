package io.agora.rest.services.cloudrecording.scenario.mix.req;

import java.util.List;

public class AcquireMixRecordingResourceClientReq {

    private Integer resourceExpiredHour;

    private List<String> excludeResourceIds;

    private Integer regionAffinity;

    private StartMixRecordingResourceClientReq startParameter;

    public static Builder builder() {
        return new Builder();
    }

    private AcquireMixRecordingResourceClientReq(Builder builder) {
        setResourceExpiredHour(builder.resourceExpiredHour);
        setExcludeResourceIds(builder.excludeResourceIds);
        setRegionAffinity(builder.regionAffinity);
        setStartParameter(builder.startParameter);
    }

    public Integer getRegionAffinity() {
        return regionAffinity;
    }

    public void setRegionAffinity(Integer regionAffinity) {
        this.regionAffinity = regionAffinity;
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

    public StartMixRecordingResourceClientReq getStartParameter() {
        return startParameter;
    }

    public void setStartParameter(StartMixRecordingResourceClientReq startParameter) {
        this.startParameter = startParameter;
    }

    @Override
    public String toString() {
        return "AcquireMixRecordingResourceClientReq{" +
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
        private StartMixRecordingResourceClientReq startParameter;

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

        public Builder startParameter(StartMixRecordingResourceClientReq val) {
            startParameter = val;
            return this;
        }

        public AcquireMixRecordingResourceClientReq build() {
            return new AcquireMixRecordingResourceClientReq(this);
        }
    }
}
