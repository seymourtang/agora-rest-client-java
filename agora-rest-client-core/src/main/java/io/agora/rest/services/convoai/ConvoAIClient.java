package io.agora.rest.services.convoai;

import io.agora.rest.core.AgoraConfig;
import io.agora.rest.core.Context;
import io.agora.rest.core.DefaultContext;
import io.agora.rest.services.convoai.api.*;
import io.agora.rest.services.convoai.api.req.JoinConvoAIReq;
import io.agora.rest.services.convoai.api.req.UpdateConvoAIReq;
import io.agora.rest.services.convoai.api.res.*;
import reactor.core.publisher.Mono;

public class ConvoAIClient {

    private final JoinConvoAIAPI joinConvoAIAPI;

    private final LeaveConvoAIAPI leaveConvoAIAPI;

    private final ListConvoAIAPI listConvoAIAPI;

    private final QueryConvoAIAPI queryConvoAIAPI;

    private final UpdateConvoAIAPI updateConvoAIAPI;

    public static ConvoAIClient create(AgoraConfig agoraConfig) {
        return new ConvoAIClient(new DefaultContext(agoraConfig));
    }

    protected ConvoAIClient(Context context) {
        joinConvoAIAPI = new JoinConvoAIAPI(context);
        leaveConvoAIAPI = new LeaveConvoAIAPI(context);
        listConvoAIAPI = new ListConvoAIAPI(context);
        queryConvoAIAPI = new QueryConvoAIAPI(context);
        updateConvoAIAPI = new UpdateConvoAIAPI(context);
    }

    public Mono<JoinConvoAIRes> join(JoinConvoAIReq request) {
        return joinConvoAIAPI.handle(request);
    }

    public Mono<LeaveConvoAIRes> leave(String agentId) {
        return leaveConvoAIAPI.handle(agentId);
    }

    public Mono<ListConvoAIRes> list(Integer limit, Integer state, Long fromTime, Long toTime) {
        return listConvoAIAPI.handle(limit, state, fromTime, toTime);
    }

    public Mono<QueryConvoAIRes> query(String agentId) {
        return queryConvoAIAPI.handle(agentId);
    }

    public Mono<UpdateConvoAIRes> update(String agentId, UpdateConvoAIReq request){
        return updateConvoAIAPI.handle(agentId,request);
    }

}
