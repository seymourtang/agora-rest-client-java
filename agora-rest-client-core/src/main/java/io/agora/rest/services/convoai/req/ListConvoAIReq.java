package io.agora.rest.services.convoai.req;

import java.util.HashMap;
import java.util.Map;

public class ListConvoAIReq {
    private final Map<String, Object> params;

    public static Builder builder() {
        return new Builder();
    }

    private ListConvoAIReq(Builder builder) {
        this.params = builder.params;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public String toQueryString() {
        if (params.isEmpty()) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }

    public static class Builder {
        private final Map<String, Object> params = new HashMap<>();

        private Builder() {

        }


        public Builder channel(String channel) {
            params.put("channel", channel);
            return this;
        }

        public Builder limit(Integer limit) {
            params.put("limit", limit);
            return this;
        }

        public Builder state(Integer state) {
            params.put("state", state);
            return this;
        }

        public Builder cursor(String cursor) {
            params.put("cursor", cursor);
            return this;
        }

        public Builder fromTime(Long fromTime) {
            params.put("fromTime", fromTime);
            return this;
        }

        public Builder toTime(Long toTime) {
            params.put("toTime", toTime);
            return this;
        }

        public ListConvoAIReq build() {
            return new ListConvoAIReq(this);
        }
    }
}
