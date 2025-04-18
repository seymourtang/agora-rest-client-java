package io.agora.rest.services.convoai.res;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @brief Response returned by the Conversational AI engine getHistory API
 * @since v0.4.0
 */
public class HistoryConvoAIRes {
    /**
     * The agent creation timestamp
     */
    @JsonProperty("start_ts")
    private Long startTs;

    /**
     * Unique identifier of the agent
     */
    @JsonProperty("agent_id")
    private String agentId;

    /**
     * Only returns the running status of the agent
     */
    @JsonProperty("status")
    private String status;

    /**
     * Agent short-term memory content
     */
    @JsonProperty("contents")
    private List<HistoryContent> contents;

    /**
     * @brief Agent short-term memory content
     * @since v0.4.0
     */
    public static class HistoryContent {

        /**
         * The content of the message
         */
        @JsonProperty("content")
        private String content;

        /**
         * The role of sending messages:
         * <p>
         * - user: User.
         * <p>
         * - assistant: Agent.
         */
        @JsonProperty("role")
        private String role;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        @Override
        public String toString() {
            return "HistoryContent{" +
                    "content='" + content + '\'' +
                    ", role='" + role + '\'' +
                    '}';
        }
    }

    public Long getStartTs() {
        return startTs;
    }

    public void setStartTs(Long startTs) {
        this.startTs = startTs;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<HistoryContent> getContents() {
        return contents;
    }

    public void setContents(List<HistoryContent> contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "HistoryConvoAIRes{" +
                "startTs=" + startTs +
                ", agentId='" + agentId + '\'' +
                ", status='" + status + '\'' +
                ", contents=" + contents +
                '}';
    }
}
