package io.agora.rest.services.convoai;

import io.agora.rest.core.Context;
import io.agora.rest.exception.AgoraInvalidArgumentException;
import io.agora.rest.services.convoai.api.*;
import io.agora.rest.services.convoai.req.JoinConvoAIReq;
import io.agora.rest.services.convoai.req.ListConvoAIReq;
import io.agora.rest.services.convoai.req.UpdateConvoAIReq;
import io.agora.rest.services.convoai.res.JoinConvoAIRes;
import io.agora.rest.services.convoai.res.ListConvoAIRes;
import io.agora.rest.services.convoai.res.QueryConvoAIRes;
import io.agora.rest.services.convoai.res.UpdateConvoAIRes;
import reactor.core.publisher.Mono;

public class ConvoAIClientImpl extends ConvoAIClient {


    private final JoinConvoAIAPI joinConvoAIAPI;

    private final LeaveConvoAIAPI leaveConvoAIAPI;

    private final ListConvoAIAPI listConvoAIAPI;

    private final QueryConvoAIAPI queryConvoAIAPI;

    private final UpdateConvoAIAPI updateConvoAIAPI;

    private final static String chineseMainlandPrefixTpl = "/cn/api/conversational-ai-agent/v2/projects/%s";

    private final static String globalPrefixTpl = "/api/conversational-ai-agent/v2/projects/%s";

    protected ConvoAIClientImpl(Context context, ConvoAIServiceRegionEnum serviceRegionEnum) {
        String pathPrefix = getPathPrefix(context, serviceRegionEnum);
        joinConvoAIAPI = new JoinConvoAIAPI(context, pathPrefix);
        leaveConvoAIAPI = new LeaveConvoAIAPI(context, pathPrefix);
        listConvoAIAPI = new ListConvoAIAPI(context, pathPrefix);
        queryConvoAIAPI = new QueryConvoAIAPI(context, pathPrefix);
        updateConvoAIAPI = new UpdateConvoAIAPI(context, pathPrefix);
    }

    private String getPathPrefix(Context context, ConvoAIServiceRegionEnum serviceRegionEnum) {
        if (serviceRegionEnum == null) {
            throw new AgoraInvalidArgumentException("service region is null");
        }

        String pathPrefixTpl = null;

        switch (serviceRegionEnum) {
            case CHINESE_MAINLAND:
                pathPrefixTpl = chineseMainlandPrefixTpl;
                break;
            case GLOBAL:
                pathPrefixTpl = globalPrefixTpl;
                break;
        }

        return String.format(pathPrefixTpl, context.getAgoraConfig().getAppId());
    }

    public Mono<JoinConvoAIRes> join(JoinConvoAIReq request) {
        return joinConvoAIAPI.handle(request);
    }

    public Mono<Void> leave(String agentId) {
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
