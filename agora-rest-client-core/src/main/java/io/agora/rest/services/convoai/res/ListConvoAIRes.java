package io.agora.rest.services.convoai.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @brief Response for querying the list of AI agents
 * @since 0.3.0
 */
public class ListConvoAIRes {

    /**
     * Data
     */
    @JsonProperty("data")
    private Data data;

    /**
     * Metadata
     */
    @JsonProperty("meta")
    private Meta meta;

    /**
     * Request status
     */
    @JsonProperty("status")
    private String status;

    @Override
    public String toString() {
        return "ListConvoAIRes{" +
                "data=" + data +
                ", meta=" + meta +
                ", status='" + status + '\'' +
                '}';
    }

    /**
     * Response data
     */
    public static class Data {

        /**
         * Number of AI agents returned in this response
         */
        @JsonProperty("count")
        private Integer count;

        /**
         * List of AI agents, for detailed information refer to {@link Agent}
         */
        @JsonProperty("list")
        private List<Agent> list;

        @Override
        public String toString() {
            return "Data{" +
                    "count=" + count +
                    ", list=" + list +
                    '}';
        }
    }

    /**
     * AI agent information
     */
    public static class Agent {

        /**
         * Unique identifier for the AI agent
         */
        @JsonProperty("agent_id")
        private String agentId;

        /**
         * @brief Creation timestamp
         */
        @JsonProperty("start_ts")
        private Integer startTs;

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

        @Override
        public String toString() {
            return "Agent{" +
                    "agentId='" + agentId + '\'' +
                    ", startTs=" + startTs +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    /**
     * Metadata
     */
    public static class Meta {

        /**
         * Total number of AI agents that meet the query criteria
         */
        @JsonProperty("total")
        private Integer total;

        /**
         * Pagination cursor
         */
        @JsonProperty("cursor")
        private String cursor;

        @Override
        public String toString() {
            return "Meta{" +
                    "total=" + total +
                    ", cursor='" + cursor + '\'' +
                    '}';
        }
    }
}
