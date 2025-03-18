package io.agora.rest.services.convoai;

import io.agora.rest.core.Context;
import io.agora.rest.services.convoai.api.*;
import io.agora.rest.services.convoai.req.JoinConvoAIReq;
import io.agora.rest.services.convoai.req.ListConvoAIReq;
import io.agora.rest.services.convoai.req.UpdateConvoAIReq;
import io.agora.rest.services.convoai.res.*;
import reactor.core.publisher.Mono;

public class ConvoAIClientImpl extends ConvoAIClient {

    private final JoinConvoAIAPI joinConvoAIAPI;

    private final LeaveConvoAIAPI leaveConvoAIAPI;

    private final ListConvoAIAPI listConvoAIAPI;

    private final QueryConvoAIAPI queryConvoAIAPI;

    private final UpdateConvoAIAPI updateConvoAIAPI;

    protected ConvoAIClientImpl(Context context) {
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

    public Mono<ListConvoAIRes> list(ListConvoAIReq request) {
        return listConvoAIAPI.handle(request);
    }

    public Mono<QueryConvoAIRes> query(String agentId) {
        return queryConvoAIAPI.handle(agentId);
    }

    public Mono<UpdateConvoAIRes> update(String agentId, UpdateConvoAIReq request) {
        return updateConvoAIAPI.handle(agentId, request);
    }
}
