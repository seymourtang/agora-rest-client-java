package io.agora.rest.services.convoai.api;

import io.agora.rest.core.Context;
import io.agora.rest.services.convoai.req.JoinConvoAIReq;
import io.agora.rest.services.convoai.res.JoinConvoAIRes;
import io.netty.handler.codec.http.HttpMethod;
import reactor.core.publisher.Mono;

public class JoinConvoAIAPI {

    private final Context context;

    private final String pathPrefix;

    public JoinConvoAIAPI(Context context, String pathPrefix) {
        this.context = context;
        this.pathPrefix = pathPrefix;
    }

    public Mono<JoinConvoAIRes> handle(JoinConvoAIReq request) {
        String path = String.format("%s/join",
                pathPrefix);

        return this.context.sendRequest(path, HttpMethod.POST, request, JoinConvoAIRes.class);
    }
}
