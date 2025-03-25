package io.agora.rest.services.convoai.res;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @brief Response parameters for joining AI agent
 * @since v0.3.0
 */
public class JoinConvoAIRes {
    /**
     * Unique identifier for the AI agent
     */
    @JsonProperty("agent_id")
    private String agentId;

    /**
     * Creation timestamp
     */
    @JsonProperty("create_ts")
    private Integer createTs;

    /**
     * Status
     *
     * @note The following statuses are available:
     * <p>
     * - IDLE (0): AI agent in idle state
     * <p>
     * - STARTING (1): AI agent that is starting
     * <p>
     * - RUNNING (2): AI agent that is running
     * <p>
     * - STOPPING (3): AI agent that is stopping
     * <p>
     * - STOPPED (4): AI agent that has completed exit
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
