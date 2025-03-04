package io.agora.rest.services.convoai.api.res;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QueryConvoAIRes {

    @JsonProperty("message")
    private String message;

    @JsonProperty("start_ts")
    private Integer startTs;

    @JsonProperty("stop_ts")
    private Integer stopTs;

    @JsonProperty("status")
    private String status;

    @JsonProperty("agent_id")
    private String agentId;
}
