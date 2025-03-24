package io.agora.rest.services.convoai.api;

import io.agora.rest.core.Context;
import io.netty.handler.codec.http.HttpMethod;
import reactor.core.publisher.Mono;

public class LeaveConvoAIAPI {

    private final Context context;

    private final String pathPrefix;

    public LeaveConvoAIAPI(Context context, String pathPrefix) {
        this.context = context;
        this.pathPrefix = pathPrefix;
    }

    public Mono<Void> handle(String agentId) {
        String path = String.format("%s/agents/%s/leave", pathPrefix,agentId);
        return this.context.sendRequest(path, HttpMethod.POST,null, Void.class);
    }
}
