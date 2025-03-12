package io.agora.rest.services.convoai.api;

import io.agora.rest.core.Context;
import io.agora.rest.services.convoai.api.req.ListConvoAIReq;
import io.agora.rest.services.convoai.api.res.ListConvoAIRes;
import io.netty.handler.codec.http.HttpMethod;
import reactor.core.publisher.Mono;

public class ListConvoAIAPI {

    private final Context context;

    public ListConvoAIAPI(Context context) {
        this.context = context;
    }

    public Mono<ListConvoAIRes> handle(ListConvoAIReq req) {
        StringBuilder path = new StringBuilder(String.format("/api/conversational-ai-agent/v2/projects/%s/agents",
                this.context.getAgoraConfig().getAppId()));

        if (req != null && req.toQueryString() != null) {
            path.append(String.format("?%s", req.toQueryString()));
        }

        return this.context.sendRequest(path.toString(), HttpMethod.GET, null, ListConvoAIRes.class);
    }
}
