package io.agora.rest.services.convoai.api;

import io.agora.rest.core.Context;
import io.agora.rest.services.convoai.res.HistoryConvoAIRes;
import io.netty.handler.codec.http.HttpMethod;
import reactor.core.publisher.Mono;

public class HistoryConvoAIAPI {
    private final Context context;

    private final String pathPrefix;

    public HistoryConvoAIAPI(Context context, String pathPrefix) {
        this.context = context;
        this.pathPrefix = pathPrefix;
    }

    public Mono<HistoryConvoAIRes> handle(String agentId) {
        String path = String.format("%s/agents/%s/history", pathPrefix, agentId);
        return this.context.sendRequest(path, HttpMethod.GET, null, HistoryConvoAIRes.class);
    }
}
