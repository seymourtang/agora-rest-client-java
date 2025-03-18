package io.agora.rest.services.convoai.api;

import io.agora.rest.core.Context;
import io.agora.rest.services.convoai.res.QueryConvoAIRes;
import io.netty.handler.codec.http.HttpMethod;
import reactor.core.publisher.Mono;

public class QueryConvoAIAPI {

    private final Context context;

    public QueryConvoAIAPI(Context context) {
        this.context = context;
    }

    public Mono<QueryConvoAIRes> handle(String agentId) {
        String path = String.format("/api/conversational-ai-agent/v2/projects/%s/agents/%s",
                this.context.getAgoraConfig().getAppId(),agentId);
        return this.context.sendRequest(path, HttpMethod.GET,null, QueryConvoAIRes.class);
    }
}
