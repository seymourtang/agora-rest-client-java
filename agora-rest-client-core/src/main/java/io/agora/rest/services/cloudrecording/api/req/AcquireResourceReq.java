package io.agora.rest.services.cloudrecording.api.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AcquireResourceReq {

    @JsonProperty("cname")
    private String cname;

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("clientRequest")
    private ClientRequest clientRequest;

    private AcquireResourceReq(Builder builder) {
        this.cname = builder.cname;
        this.uid = builder.uid;
        this.clientRequest = builder.clientRequest;
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

    public static class ClientRequest {
        @JsonProperty("scene")
        private Integer scene;

        @JsonProperty("resourceExpiredHour")
        private Integer resourceExpiredHour;

        @JsonProperty("excludeResourceIds")
        private List<String> excludeResourceIds;

        @JsonProperty("regionAffinity")
        private Integer regionAffinity;

        @JsonProperty("startParameter")
        private StartResourceReq.StartClientRequest startParameter;

        private ClientRequest(Builder builder) {
            this.scene = builder.scene;
            this.resourceExpiredHour = builder.resourceExpiredHour;
            this.excludeResourceIds = builder.excludeResourceIds;
            this.regionAffinity = builder.regionAffinity;
            this.startParameter = builder.startParameter;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder {

            private Integer scene;

            private Integer resourceExpiredHour;

            private List<String> excludeResourceIds;

            private Integer regionAffinity;

            private StartResourceReq.StartClientRequest startParameter;

            public Builder scene(Integer scene) {
                this.scene = scene;
                return this;
            }

            public Builder resourceExpiredHour(Integer resourceExpiredHour) {
                this.resourceExpiredHour = resourceExpiredHour;
                return this;
            }

            public Builder excludeResourceIds(List<String> excludeResourceIds) {
                this.excludeResourceIds = excludeResourceIds;
                return this;
            }

            public Builder regionAffinity(Integer regionAffinity) {
                this.regionAffinity = regionAffinity;
                return this;
            }

            public Builder startParameter(StartResourceReq.StartClientRequest startParameter) {
                this.startParameter = startParameter;
                return this;
            }

            public ClientRequest build() {
                return new ClientRequest(this);
            }
        }

        @Override
        public String toString() {
            return "ClientRequest{" +
                    "scene=" + scene +
                    ", resourceExpiredHour=" + resourceExpiredHour +
                    ", excludeResourceIds=" + excludeResourceIds +
                    ", regionAffinity=" + regionAffinity +
                    ", startParameter=" + startParameter +
                    '}';
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String cname;

        private String uid;

        private ClientRequest clientRequest;

        public Builder cname(String cname) {
            this.cname = cname;
            return this;
        }

        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        public Builder clientRequest(ClientRequest clientRequest) {
            this.clientRequest = clientRequest;
            return this;
        }

        public AcquireResourceReq build() {
            return new AcquireResourceReq(this);
        }
    }

    @Override
    public String toString() {
        return "AcquireResourceReq{" +
                "cname='" + cname + '\'' +
                ", uid='" + uid + '\'' +
                ", clientRequest=" + clientRequest +
                '}';
    }
}
