package io.agora.rest.services.cloudrecording.scenario.mix;

import io.agora.rest.services.cloudrecording.api.*;
import io.agora.rest.services.cloudrecording.api.req.*;
import io.agora.rest.services.cloudrecording.api.res.*;
import io.agora.rest.services.cloudrecording.enums.CloudRecordingModeEnum;
import io.agora.rest.services.cloudrecording.scenario.mix.req.AcquireMixRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.mix.req.StartMixRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.mix.req.UpdateLayoutMixRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.mix.req.UpdateMixRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.mix.res.QueryMixHLSAndMP4RecordingResourceRes;
import io.agora.rest.services.cloudrecording.scenario.mix.res.QueryMixHLSRecordingResourceRes;
import reactor.core.publisher.Mono;

public class MixScenarioImpl extends MixScenario {

    private final AcquireResourceAPI acquireResourceAPI;

    private final QueryResourceAPI queryResourceAPI;

    private final StartResourceAPI startResourceAPI;

    private final UpdateResourceAPI updateResourceAPI;

    private final StopResourceAPI stopResourceAPI;

    public MixScenarioImpl(AcquireResourceAPI acquireResourceAPI,
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
                                            AcquireMixRecordingResourceClientReq clientRequest) {

        StartResourceReq.StartClientRequest startParameter = null;
        if (clientRequest.getStartParameter() != null) {
            startParameter = StartResourceReq.StartClientRequest.builder()
                    .token(clientRequest.getStartParameter().getToken())
                    .storageConfig(clientRequest.getStartParameter().getStorageConfig())
                    .recordingConfig(clientRequest.getStartParameter().getRecordingConfig())
                    .recordingFileConfig(clientRequest.getStartParameter().getRecordingFileConfig())
                    .build();
        }


        return this.acquireResourceAPI.handle(AcquireResourceReq.builder()
                .cname(cname)
                .uid(uid)
                .clientRequest(AcquireResourceReq.ClientRequest.builder()
                        .scene(0)
                        .resourceExpiredHour(clientRequest.getResourceExpiredHour())
                        .regionAffinity(clientRequest.getRegionAffinity())
                        .excludeResourceIds(clientRequest.getExcludeResourceIds())
                        .startParameter(startParameter)
                        .build())
                .build());
    }

    @Override
    public Mono<StartResourceRes> start(String cname, String uid, String resourceId,
                                        StartMixRecordingResourceClientReq clientRequest) {
        return this.startResourceAPI.handle(resourceId, CloudRecordingModeEnum.MIX, StartResourceReq.builder()
                .cname(cname)
                .uid(uid)
                .clientRequest(StartResourceReq.StartClientRequest.builder()
                        .token(clientRequest.getToken())
                        .storageConfig(clientRequest.getStorageConfig())
                        .recordingConfig(clientRequest.getRecordingConfig())
                        .recordingFileConfig(clientRequest.getRecordingFileConfig())
                        .build())
                .build());
    }

    @Override
    public Mono<QueryMixHLSRecordingResourceRes> queryHLS(String resourceId, String sid) {
        return this.queryResourceAPI.handle(resourceId, sid, CloudRecordingModeEnum.MIX).handle((res, sink) -> {
            sink.next(QueryMixHLSRecordingResourceRes.builder()
                    .cname(res.getCname())
                    .uid(res.getUid())
                    .resourceId(res.getResourceId())
                    .sid(res.getSid())
                    .serverResponse(res.getMixRecordingHLSServerResponse())
                    .build());

            sink.complete();
        });
    }

    @Override
    public Mono<QueryMixHLSAndMP4RecordingResourceRes> queryHLSAndMP4(String resourceId, String sid) {
        return this.queryResourceAPI.handle(resourceId, sid, CloudRecordingModeEnum.MIX).handle((res, sink) -> {
            sink.next(QueryMixHLSAndMP4RecordingResourceRes.builder()
                    .cname(res.getCname())
                    .uid(res.getUid())
                    .resourceId(res.getResourceId())
                    .sid(res.getSid())
                    .serverResponse(res.getMixRecordingHLSAndMP4ServerResponse())
                    .build());

            sink.complete();
        });
    }

    @Override
    public Mono<UpdateLayoutResourceRes> updateLayout(String cname, String uid, String resourceId, String sid,
                                                      UpdateLayoutMixRecordingResourceClientReq clientRequest) {
        return this.updateResourceAPI.handleLayout(resourceId, sid, CloudRecordingModeEnum.MIX,
                UpdateLayoutResourceReq.builder()
                        .cname(cname)
                        .uid(uid)
                        .clientRequest(UpdateLayoutResourceReq.ClientRequest.builder()
                                .maxResolutionUID(clientRequest.getMaxResolutionUID())
                                .mixedVideoLayout(clientRequest.getMixedVideoLayout())
                                .backgroundColor(clientRequest.getBackgroundColor())
                                .defaultUserBackgroundImage(clientRequest
                                        .getDefaultUserBackgroundImage())
                                .layoutConfig(clientRequest.getLayoutConfig())
                                .backgroundImage(clientRequest.getBackgroundImage())
                                .backgroundConfig(clientRequest.getBackgroundConfig())
                                .build())
                        .build());
    }

    @Override
    public Mono<UpdateResourceRes> update(String cname, String uid, String resourceId, String sid,
                                          UpdateMixRecordingResourceClientReq clientRequest) {
        return this.updateResourceAPI.handle(resourceId, sid, CloudRecordingModeEnum.MIX,
                UpdateResourceReq.builder()
                        .cname(cname)
                        .uid(uid)
                        .clientRequest(UpdateResourceReq.ClientRequest.builder()
                                .streamSubscribe(clientRequest.getStreamSubscribe())
                                .build())
                        .build());
    }

    @Override
    public Mono<StopResourceRes> stop(String cname, String uid, String resourceId, String sid, boolean asyncStop) {
        return this.stopResourceAPI.handle(resourceId, sid, CloudRecordingModeEnum.MIX,
                StopResourceReq.builder()
                        .cname(cname)
                        .uid(uid)
                        .clientRequest(StopResourceReq.StopClientRequest.builder()
                                .asyncStop(asyncStop)
                                .build())
                        .build());
    }
}
