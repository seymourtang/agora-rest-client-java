package io.agora.rest.services.convoai.api;

import io.agora.rest.core.Context;
import io.agora.rest.services.convoai.api.req.JoinConvoAIReq;
import io.agora.rest.services.convoai.api.res.JoinConvoAIRes;
import io.netty.handler.codec.http.HttpMethod;
import reactor.core.publisher.Mono;

import java.util.HashMap;

public class JoinConvoAIAPI {

    private final Context context;

    public JoinConvoAIAPI(Context context) {
        this.context = context;
    }

    public Mono<JoinConvoAIRes> handle(JoinConvoAIReq request) {
        String path = String.format("/api/conversational-ai-agent/v2/projects/%s/join",
                this.context.getAgoraConfig().getAppId());

        return this.context.sendRequest(path, HttpMethod.POST,request,JoinConvoAIRes.class);
    }
}
