package io.agora.rest.services.convoai.api;

import io.agora.rest.core.Context;
import io.agora.rest.services.convoai.res.QueryConvoAIRes;
import io.netty.handler.codec.http.HttpMethod;
import reactor.core.publisher.Mono;

public class QueryConvoAIAPI {

    private final Context context;

    private final String pathPrefix;

    public QueryConvoAIAPI(Context context, String pathPrefix) {
        this.context = context;
        this.pathPrefix = pathPrefix;
    }

    public Mono<QueryConvoAIRes> handle(String agentId) {
        String path = String.format("%s/agents/%s", pathPrefix, agentId);
        return this.context.sendRequest(path, HttpMethod.GET, null, QueryConvoAIRes.class);
    }
}
