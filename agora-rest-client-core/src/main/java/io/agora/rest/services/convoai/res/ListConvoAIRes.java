package io.agora.rest.services.convoai.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @brief Response returned by the Conversational AI engine list API
 * @since v0.3.0
 */
public class ListConvoAIRes {

    /**
     * Intelligent agent data information
     */
    @JsonProperty("data")
    private Data data;

    /**
     * Metadata of the returned list
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
     * Intelligent agent data information
     */
    public static class Data {

        /**
         * Number of AI agents returned in this response
         */
        @JsonProperty("count")
        private Integer count;

        /**
         * List of intelligent agents that meet the conditions, for detailed information
         * refer to {@link Agent}
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

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public List<Agent> getList() {
            return list;
        }

        public void setList(List<Agent> list) {
            this.list = list;
        }
    }

    /**
     * Intelligent agent information
     */
    public static class Agent {

        /**
         * Unique identifier of the agent
         */
        @JsonProperty("agent_id")
        private String agentId;

        /**
         * Intelligent agent creation timestamp
         */
        @JsonProperty("start_ts")
        private Integer startTs;

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

        @Override
        public String toString() {
            return "Agent{" +
                    "agentId='" + agentId + '\'' +
                    ", startTs=" + startTs +
                    ", status='" + status + '\'' +
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    /**
     * Metadata of the returned list
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

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
