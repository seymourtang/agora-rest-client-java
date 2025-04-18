package io.agora.rest.services.convoai.api;

import io.agora.rest.core.Context;
import io.agora.rest.services.convoai.res.InterruptConvoAIRes;
import io.netty.handler.codec.http.HttpMethod;
import reactor.core.publisher.Mono;

public class InterruptConvoAIAPI {
    private final Context context;

    private final String pathPrefix;

    public InterruptConvoAIAPI(Context context, String pathPrefix) {
        this.context = context;
        this.pathPrefix = pathPrefix;
    }

    public Mono<InterruptConvoAIRes> handle(String agentId) {
        String path = String.format("%s/agents/%s/interrupt", pathPrefix, agentId);
        return this.context.sendRequest(path, HttpMethod.POST, null, InterruptConvoAIRes.class);
    }
}
