package io.agora.rest.services.convoai.res;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @brief Response returned by the Conversational AI engine Update API
 * @since v0.3.0
 */
public class UpdateConvoAIRes {
    /**
     * Unique identifier of the agent
     */
    @JsonProperty("agent_id")
    private String agentId;

    /**
     * Intelligent agent creation timestamp
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
    @JsonProperty("state")
    private String state;

    @Override
    public String toString() {
        return "UpdateConvoAIRes{" +
                "agentId='" + agentId + '\'' +
                ", createTs=" + createTs +
                ", state='" + state + '\'' +
                '}';
    }
}
