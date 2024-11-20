package io.agora.rest.services.cloudrecording.api.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StopResourceReq {

    @JsonProperty("cname")
    private String cname;

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("clientRequest")
    private StopClientRequest clientRequest;

    public static Builder builder() {
        return new Builder();
    }

    private StopResourceReq(Builder builder) {
        setCname(builder.cname);
        setUid(builder.uid);
        setClientRequest(builder.clientRequest);
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

    public StopClientRequest getClientRequest() {
        return clientRequest;
    }

    public void setClientRequest(StopClientRequest clientRequest) {
        this.clientRequest = clientRequest;
    }

    @Override
    public String toString() {
        return "StopResourceReq{" +
                "cname='" + cname + '\'' +
                ", uid='" + uid + '\'' +
                ", clientRequest=" + clientRequest +
                '}';
    }

    public static class StopClientRequest {
        @JsonProperty("async_stop")
        private boolean asyncStop;

        public static Builder builder() {
            return new Builder();
        }

        private StopClientRequest(Builder builder) {
            setAsyncStop(builder.asyncStop);
        }

        public boolean isAsyncStop() {
            return asyncStop;
        }

        public void setAsyncStop(boolean asyncStop) {
            this.asyncStop = asyncStop;
        }

        @Override
        public String toString() {
            return "StopClientRequest{" +
                    "asyncStop=" + asyncStop +
                    '}';
        }

        public static final class Builder {
            private boolean asyncStop;

            private Builder() {
            }

            public Builder asyncStop(boolean val) {
                asyncStop = val;
                return this;
            }

            public StopClientRequest build() {
                return new StopClientRequest(this);
            }
        }
    }

    public static final class Builder {

        private String cname;

        private String uid;

        private StopClientRequest clientRequest;

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

        public Builder clientRequest(StopClientRequest val) {
            clientRequest = val;
            return this;
        }

        public StopResourceReq build() {
            return new StopResourceReq(this);
        }
    }
}
