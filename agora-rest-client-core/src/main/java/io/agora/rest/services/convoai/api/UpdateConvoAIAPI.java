package io.agora.rest.services.convoai.api;

import io.agora.rest.core.Context;
import io.agora.rest.services.convoai.api.req.UpdateConvoAIReq;
import io.agora.rest.services.convoai.api.res.UpdateConvoAIRes;
import io.netty.handler.codec.http.HttpMethod;
import reactor.core.publisher.Mono;


public class UpdateConvoAIAPI {
    private final Context context;

    public UpdateConvoAIAPI(Context context) {
        this.context = context;
    }

    public Mono<UpdateConvoAIRes> handle(String agentId, UpdateConvoAIReq request) {
        String path = String.format("/api/conversational-ai-agent/v2/projects/%s/agents/%s/update",
                this.context.getAgoraConfig().getAppId(),agentId);
        return this.context.sendRequest(path, HttpMethod.GET,request, UpdateConvoAIRes.class);
    }
}
