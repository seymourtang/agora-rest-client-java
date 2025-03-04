package io.agora.rest.services.convoai.api.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListConvoAIRes {

    @JsonProperty("data")
    private Data data;

    @JsonProperty("meta")
    private Meta meta;

    @JsonProperty("status")
    private String status;

    public static class Data {

        @JsonProperty("count")
        private Integer count;

        @JsonProperty("list")
        private List<Agent> list;
    }

    public static class Agent{

        @JsonProperty("start_ts")
        private Integer startTs;

        @JsonProperty("status")
        private String status;

        @JsonProperty("agent_id")
        private String agentId;
    }

    public static class Meta{

        @JsonProperty("total")
        private Integer total;

        @JsonProperty("cursor")
        private String cursor;
    }
}
