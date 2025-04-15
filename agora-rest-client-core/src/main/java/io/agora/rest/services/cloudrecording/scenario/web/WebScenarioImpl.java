package io.agora.rest.services.cloudrecording.scenario.web;

import io.agora.rest.services.cloudrecording.api.*;
import io.agora.rest.services.cloudrecording.api.req.AcquireResourceReq;
import io.agora.rest.services.cloudrecording.api.req.StartResourceReq;
import io.agora.rest.services.cloudrecording.api.req.StopResourceReq;
import io.agora.rest.services.cloudrecording.api.req.UpdateResourceReq;
import io.agora.rest.services.cloudrecording.api.res.AcquireResourceRes;
import io.agora.rest.services.cloudrecording.api.res.StartResourceRes;
import io.agora.rest.services.cloudrecording.api.res.StopResourceRes;
import io.agora.rest.services.cloudrecording.api.res.UpdateResourceRes;
import io.agora.rest.services.cloudrecording.enums.CloudRecordingModeEnum;
import io.agora.rest.services.cloudrecording.scenario.web.req.AcquireWebRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.web.req.StartWebRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.web.req.UpdateWebRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.web.res.QueryWebRecordingResourceRes;
import reactor.core.publisher.Mono;

public class WebScenarioImpl extends WebScenario {
    
    private final AcquireResourceAPI acquireResourceAPI;

    private final QueryResourceAPI queryResourceAPI;

    private final StartResourceAPI startResourceAPI;

    private final UpdateResourceAPI updateResourceAPI;

    private final StopResourceAPI stopResourceAPI;

    public WebScenarioImpl(AcquireResourceAPI acquireResourceAPI,
                           QueryResourceAPI queryResourceAPI,
                           StartResourceAPI startResourceAPI,
                           UpdateResourceAPI updateResourceAPI,
                           StopResourceAPI stopResourceAPI) {
        this.acquireResourceAPI = acquireResourceAPI;
        this.queryResourceAPI = queryResourceAPI;
        this.startResourceAPI = startResourceAPI;
        this.updateResourceAPI = updateResourceAPI;
        this.stopResourceAPI = stopResourceAPI;
    }

    @Override
    public Mono<AcquireResourceRes> acquire(String cname, String uid,
                                            AcquireWebRecordingResourceClientReq clientRequest) {
        StartResourceReq.StartClientRequest startParameter = null;

        if (clientRequest.getStartParameter() != null) {
            startParameter = StartResourceReq.StartClientRequest.builder()
                    .storageConfig(clientRequest.getStartParameter().getStorageConfig())
                    .recordingFileConfig(clientRequest.getStartParameter().getRecordingFileConfig())
                    .extensionServiceConfig(clientRequest.getStartParameter().getExtensionServiceConfig())
                    .build();
        }

        return this.acquireResourceAPI.handle(AcquireResourceReq.builder()
                .cname(cname)
                .uid(uid)
                .clientRequest(AcquireResourceReq.ClientRequest.builder()
                        .scene(1)
                        .resourceExpiredHour(clientRequest.getResourceExpiredHour())
                        .regionAffinity(clientRequest.getRegionAffinity())
                        .excludeResourceIds(clientRequest.getExcludeResourceIds())
                        .startParameter(startParameter)
                        .build())
                .build());
    }

    @Override
    public Mono<StartResourceRes> start(String cname, String uid, String resourceId,
                                        StartWebRecordingResourceClientReq clientRequest) {
        return this.startResourceAPI.handle(resourceId, CloudRecordingModeEnum.WEB, StartResourceReq.builder()
                .cname(cname)
                .uid(uid)
                .clientRequest(StartResourceReq.StartClientRequest.builder()
                        .storageConfig(clientRequest.getStorageConfig())
                        .recordingFileConfig(clientRequest.getRecordingFileConfig())
                        .extensionServiceConfig(clientRequest.getExtensionServiceConfig())
                        .build())
                .build());
    }

    @Override
    public Mono<QueryWebRecordingResourceRes> query(String resourceId, String sid) {
        return this.queryResourceAPI.handle(resourceId, sid, CloudRecordingModeEnum.WEB).handle((res, sink) -> {
            sink.next(QueryWebRecordingResourceRes.builder()
                    .cname(res.getCname())
                    .uid(res.getUid())
                    .resourceId(res.getResourceId())
                    .sid(res.getSid())
                    .serverResponse(res.getWebRecordingServerResponse())
                    .build());

            sink.complete();
        });
    }

    @Override
    public Mono<UpdateResourceRes> update(String cname, String uid, String resourceId, String sid,
                                          UpdateWebRecordingResourceClientReq clientRequest) {
        return this.updateResourceAPI.handle(resourceId, sid, CloudRecordingModeEnum.WEB, UpdateResourceReq.builder()
                .cname(cname)
                .uid(uid)
                .clientRequest(UpdateResourceReq.ClientRequest.builder()
                        .webRecordingConfig(clientRequest.getWebRecordingConfig())
                        .rtmpPublishConfig(clientRequest.getRtmpPublishConfig())
                        .build())
                .build());
    }

    @Override
    public Mono<StopResourceRes> stop(String cname, String uid, String resourceId, String sid, boolean asyncStop) {
        return this.stopResourceAPI.handle(resourceId, sid, CloudRecordingModeEnum.WEB, StopResourceReq.builder()
                .cname(cname)
                .uid(uid)
                .clientRequest(StopResourceReq.StopClientRequest.builder()
                        .asyncStop(asyncStop)
                        .build())
                .build());
    }
}
