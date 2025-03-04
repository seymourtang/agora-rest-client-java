package io.agora.rest.services.convoai.api;

import io.agora.rest.core.Context;
import io.agora.rest.services.convoai.api.res.ListConvoAIRes;
import io.netty.handler.codec.http.HttpMethod;
import reactor.core.publisher.Mono;

public class ListConvoAIAPI {

    private final Context context;

    public ListConvoAIAPI(Context context) {
        this.context = context;
    }

    public Mono<ListConvoAIRes> handle(Integer limit,Integer state,Long fromTime,Long toTime) {
        String path = String.format("/api/conversational-ai-agent/v2/projects/%s/agents?limit=%s&state=%s&fromTime=%s&toTime=%s",
                this.context.getAgoraConfig().getAppId(),limit,state,fromTime,toTime);
        return this.context.sendRequest(path, HttpMethod.GET,null, ListConvoAIRes.class);
    }
}
