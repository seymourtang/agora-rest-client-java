package io.agora.rest.services.convoai.res;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @brief Response for updating the AI agent
 * @since 0.3.0
 */
public class UpdateConvoAIRes {
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
}
