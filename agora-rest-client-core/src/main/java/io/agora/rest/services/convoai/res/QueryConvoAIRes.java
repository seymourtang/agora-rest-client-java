package io.agora.rest.services.convoai.res;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @brief Response returned by the Conversational AI engine query API
 * @since v0.3.0
 */
public class QueryConvoAIRes {

    /**
     * Request message
     */
    @JsonProperty("message")
    private String message;

    /**
     * Intelligent agent creation timestamp
     */
    @JsonProperty("start_ts")
    private Integer startTs;

    /**
     * The agent stop timestamp
     */
    @JsonProperty("stop_ts")
    private Integer stopTs;

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

    /**
     * Unique identifier of the agent
     */
    @JsonProperty("agent_id")
    private String agentId;

    @Override
    public String toString() {
        return "QueryConvoAIRes{" +
                "message='" + message + '\'' +
                ", startTs=" + startTs +
                ", stopTs=" + stopTs +
                ", status='" + status + '\'' +
                ", agentId='" + agentId + '\'' +
                '}';
    }
}
