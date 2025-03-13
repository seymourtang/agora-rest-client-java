package io.agora.rest.services.convoai.req;

import java.util.HashMap;
import java.util.Map;

/**
 * @brief Request parameters for querying the list of AI agents
 * @since 0.3.0
 */
public class ListConvoAIReq {
    private final Map<String, Object> params = new HashMap<>();

    public ListConvoAIReq() {
    }

    /**
     * @param channel Channel
     * @return Returns an instance of {@link ListConvoAIReq}
     * @brief Sets the query channel parameter to query the list of AI agents under the specified channel name
     */
    public ListConvoAIReq channel(String channel) {
        params.put("channel", channel);
        return this;
    }

    /**
     * @param limit Number
     * @return Returns an instance of {@link ListConvoAIReq}
     * @brief Sets the query limit parameter to query the specified number of AI agents. The maximum number of items returned per page is 20 by default.
     */
    public ListConvoAIReq limit(Integer limit) {
        params.put("limit", limit);
        return this;
    }

    /**
     * @param state State
     * @return Returns an instance of {@link ListConvoAIReq}
     * @brief Sets the query state parameter to query the list of AI agents with the specified state. Multiple states cannot be specified in a single query.
     * @note Supports the following states:
     * <p>
     * - IDLE (0): AI agents in idle state
     * <p>
     * - STARTING (1): AI agents that are starting
     * <p>
     * - RUNNING (2): AI agents that are running
     * <p>
     * - STOPPING (3): AI agents that are stopping
     * <p>
     * - STOPPED (4): AI agents that have completed exit
     */
    public ListConvoAIReq state(Integer state) {
        params.put("state", state);
        return this;
    }

    /**
     * @param cursor Cursor
     * @return Returns an instance of {@link ListConvoAIReq}
     * @brief Sets the query cursor parameter to query the list of AI agents at the specified cursor position, i.e., the starting position of the page.
     */
    public ListConvoAIReq cursor(String cursor) {
        params.put("cursor", cursor);
        return this;
    }

    /**
     * @param fromTime Start time
     * @return Returns an instance of {@link ListConvoAIReq}
     * @brief Sets the query fromTime parameter to query the list starting from the specified timestamp (s). The default is 1 day ago.
     */
    public ListConvoAIReq fromTime(Long fromTime) {
        params.put("fromTime", fromTime);
        return this;
    }

    /**
     * @param toTime End time
     * @return Returns an instance of {@link ListConvoAIReq}
     * @brief Sets the query toTime parameter to query the list ending at the specified timestamp (s). The default is the current time.
     */
    public ListConvoAIReq toTime(Long toTime) {
        params.put("toTime", toTime);
        return this;
    }

    /**
     * @return Returns the query string
     * @brief Converts the request parameters to a query string
     */
    public String toQueryString() {
        if (params.isEmpty()) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
