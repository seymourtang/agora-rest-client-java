package io.agora.rest.services.convoai.api;

import io.agora.rest.core.Context;
import io.agora.rest.services.convoai.res.LeaveConvoAIRes;
import io.netty.handler.codec.http.HttpMethod;
import reactor.core.publisher.Mono;

public class LeaveConvoAIAPI {

    private final Context context;

    public LeaveConvoAIAPI(Context context) {
        this.context = context;
    }

    public Mono<LeaveConvoAIRes> handle(String agentId) {
        String path = String.format("/api/conversational-ai-agent/v2/projects/%s/agents/%s/leave",
                this.context.getAgoraConfig().getAppId(),agentId);
        return this.context.sendRequest(path, HttpMethod.POST,null, LeaveConvoAIRes.class);
    }
}
