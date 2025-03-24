package io.agora.rest.services.convoai.res;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @brief Response for querying the AI agent
 * @since 0.3.0
 */
public class QueryConvoAIRes {

    /**
     * Request message
     */
    @JsonProperty("message")
    private String message;

    /**
     * AI agent creation timestamp
     */
    @JsonProperty("start_ts")
    private Integer startTs;

    /**
     * AI agent stop timestamp
     */
    @JsonProperty("stop_ts")
    private Integer stopTs;

    /**
     * Status
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

    /**
     * Unique identifier for the AI agent
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
