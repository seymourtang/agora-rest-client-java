package io.agora.rest.services.convoai.api.res;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateConvoAIRes {

    @JsonProperty("agent_id")
    private String agentId;

    @JsonProperty("create_ts")
    private Integer createTs;

    @JsonProperty("status")
    private String status;
}
