package io.agora.rest.services.convoai.res;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @brief Response returned by the Conversational AI engine Join API
 * @since v0.3.0
 */
public class JoinConvoAIRes {
    /**
     * Unique identifier of the agent
     */
    @JsonProperty("agent_id")
    private String agentId;

    /**
     * Timestamp when the agent was created
     */
    @JsonProperty("create_ts")
    private Integer createTs;

    /**
     * Status
     * <p>
     * The following statuses are available:
     * <p>
     * - IDLE (0): The agent is idle.
     * <p>
     * - STARTING (1): The agent is starting.
     * <p>
     * - RUNNING (2): The agent is running.
     * <p>
     * - STOPPING (3): The agent is stopping.
     * <p>
     * - STOPPED (4): The agent has stopped.
     * <p>
     * - RECOVERING (5): The agent is recovering.
     * <p>
     * - FAILED (6): The agent has failed.
     */
    @JsonProperty("status")
    private String status;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public Integer getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Integer createTs) {
        this.createTs = createTs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JoinConvoAIRes{" +
                "agentId='" + agentId + '\'' +
                ", createTs=" + createTs +
                ", status='" + status + '\'' +
                '}';
    }
}
