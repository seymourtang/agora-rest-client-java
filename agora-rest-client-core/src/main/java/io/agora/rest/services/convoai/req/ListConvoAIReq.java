package io.agora.rest.services.convoai.req;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListConvoAIReq {
    private final String channel;
    private final Integer limit;
    private final String cursor;
    private final Long fromTime;
    private final Long toTime;
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
