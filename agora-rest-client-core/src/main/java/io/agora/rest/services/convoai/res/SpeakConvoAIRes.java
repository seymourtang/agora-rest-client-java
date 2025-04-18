package io.agora.rest.services.convoai.res;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @brief Response returned by the Conversational AI engine speak API
 * @since v0.4.0
 */
public class SpeakConvoAIRes {
    /**
     * Unique identifier of the agent
     */
    @JsonProperty("agent_id")
    private String agentId;

    /**
     * The start timestamp of the agent
     */
    @JsonProperty("start_ts")
    private Integer startTs;

    /**
     * The channel name
     */
    @JsonProperty("channel")
    private String channel;

    @Override
    public String toString() {
        return "SpeakConvoAIRes{" +
                "agentId='" + agentId + '\'' +
                ", startTs=" + startTs +
                ", channel='" + channel + '\'' +
                '}';
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public Integer getStartTs() {
        return startTs;
    }

    public void setStartTs(Integer startTs) {
        this.startTs = startTs;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

}
