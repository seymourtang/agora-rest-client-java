package io.agora.rest.services.convoai.api;

import io.agora.rest.core.Context;
import io.agora.rest.services.convoai.req.UpdateConvoAIReq;
import io.agora.rest.services.convoai.res.UpdateConvoAIRes;
import io.netty.handler.codec.http.HttpMethod;
import reactor.core.publisher.Mono;


public class UpdateConvoAIAPI {

    private final Context context;

    private final String pathPrefix;

    public UpdateConvoAIAPI(Context context, String pathPrefix) {
        this.context = context;
        this.pathPrefix = pathPrefix;
    }

    public Mono<UpdateConvoAIRes> handle(String agentId, UpdateConvoAIReq request) {
        String path = String.format("%s/agents/%s/update", pathPrefix, agentId);
        return this.context.sendRequest(path, HttpMethod.POST, request, UpdateConvoAIRes.class);
    }
}
