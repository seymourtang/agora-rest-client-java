package io.agora.rest.services.convoai.req;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @brief Define the filter condition type used to query the list of intelligent agents
 * @since v0.3.0
 */
public class ListConvoAIReq {

    /**
     * Set the channel name.
     */
    private final String channel;
    /**
     * Set the number of items.
     * <p>
     * Limit The number of items returned per page for pagination,default is 20
     */
    private final Integer limit;
    /**
     * Set the pagination cursor.
     * <p>
     * Pagination Cursor, i.e., the intelligent agent ID of the pagination start position
     */
    private final String cursor;
    /**
     * Set the end timestamp.
     * <p>
     * End timestamp (s), default is the current time
     */
    private final Long fromTime;

    /**
     * Set the start timestamp.
     * <p>
     * Start timestamp (s), default is 1 day ago
     */
    private final Long toTime;
    /**
     * Status of the intelligent agent to query，supports the following statuses:
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
    private final Integer state;

    public static Builder builder() {
        return new Builder();
    }

    private ListConvoAIReq(Builder builder) {
        channel = builder.channel;
        limit = builder.limit;
        cursor = builder.cursor;
        fromTime = builder.fromTime;
        toTime = builder.toTime;
        state = builder.state;
    }

    public String toQueryString() {
        return Stream.of(
                        Optional.ofNullable(channel).map(c -> "channel=" + c),
                        Optional.ofNullable(limit).map(l -> "limit=" + l),
                        Optional.ofNullable(cursor).map(c -> "cursor=" + c),
                        Optional.ofNullable(fromTime).map(ft -> "fromTime=" + ft),
                        Optional.ofNullable(toTime).map(tt -> "toTime=" + tt),
                        Optional.ofNullable(state).map(s -> "state=" + s)
                )
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.joining("&"));
    }

    public static final class Builder {
        private String channel;
        private Integer limit;
        private String cursor;
        private Long fromTime;
        private Long toTime;
        private Integer state;

        private Builder() {
        }

        public Builder channel(String val) {
            channel = val;
            return this;
        }

        public Builder limit(Integer val) {
            limit = val;
            return this;
        }

        public Builder cursor(String val) {
            cursor = val;
            return this;
        }

        public Builder fromTime(Long val) {
            fromTime = val;
            return this;
        }

        public Builder toTime(Long val) {
            toTime = val;
            return this;
        }

        public Builder state(Integer val) {
            state = val;
            return this;
        }

        public ListConvoAIReq build() {
            return new ListConvoAIReq(this);
        }
    }
}
