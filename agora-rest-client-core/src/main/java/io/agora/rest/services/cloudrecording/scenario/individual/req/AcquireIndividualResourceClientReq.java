package io.agora.rest.services.cloudrecording.scenario.individual.req;

import java.util.List;

public class AcquireIndividualResourceClientReq {

    private Integer resourceExpiredHour;

    private List<String> excludeResourceIds;

    private Integer regionAffinity;

    private StartIndividualRecordingClientReq startParameter;

    public static Builder builder() {
        return new Builder();
    }

    private AcquireIndividualResourceClientReq(Builder builder) {
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

    public StartIndividualRecordingClientReq getStartParameter() {
        return startParameter;
    }

    public void setStartParameter(StartIndividualRecordingClientReq startParameter) {
        this.startParameter = startParameter;
    }

    @Override
    public String toString() {
        return "AcquireIndividualResourceClientReq{" +
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
        private StartIndividualRecordingClientReq startParameter;

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

        public Builder startParameter(StartIndividualRecordingClientReq val) {
            startParameter = val;
            return this;
        }

        public AcquireIndividualResourceClientReq build() {
            return new AcquireIndividualResourceClientReq(this);
        }
    }
}
