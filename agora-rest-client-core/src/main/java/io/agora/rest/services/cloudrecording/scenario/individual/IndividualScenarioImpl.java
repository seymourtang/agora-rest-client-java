package io.agora.rest.services.cloudrecording.scenario.individual;

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
import io.agora.rest.services.cloudrecording.scenario.individual.req.AcquireIndividualResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.individual.req.StartIndividualRecordingClientReq;
import io.agora.rest.services.cloudrecording.scenario.individual.req.UpdateIndividualRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.individual.res.QueryIndividualRecordingResourceRes;
import io.agora.rest.services.cloudrecording.scenario.individual.res.QueryIndividualRecordingVideoScreenshotResourceRes;
import reactor.core.publisher.Mono;

public class IndividualScenarioImpl extends IndividualScenario {

    private final AcquireResourceAPI acquireResourceAPI;

    private final QueryResourceAPI queryResourceAPI;

    private final StartResourceAPI startResourceAPI;

    private final UpdateResourceAPI updateResourceAPI;

    private final StopResourceAPI stopResourceAPI;

    public IndividualScenarioImpl(AcquireResourceAPI acquireResourceAPI,
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
    public Mono<AcquireResourceRes> acquire(String cname, String uid, boolean enablePostpone,
                                            AcquireIndividualResourceClientReq clientRequest) {
        int scene = 0;

        if (enablePostpone) {
            scene = 2;
        }

        StartResourceReq.StartClientRequest startParameter = null;
        if (clientRequest.getStartParameter() != null) {
            startParameter = StartResourceReq.StartClientRequest.builder()
                    .token(clientRequest.getStartParameter().getToken())
                    .storageConfig(clientRequest.getStartParameter()
                            .getStorageConfig())
                    .recordingConfig(clientRequest.getStartParameter()
                            .getRecordingConfig())
                    .recordingFileConfig(clientRequest.getStartParameter()
                            .getRecordingFileConfig())
                    .snapshotConfig(clientRequest.getStartParameter()
                            .getSnapshotConfig())
                    .appsCollection(clientRequest.getStartParameter()
                            .getAppsCollection())
                    .transcodeOptions(clientRequest.getStartParameter()
                            .getTranscodeOptions())
                    .build();
        }

        AcquireResourceReq req = AcquireResourceReq.builder()
                .cname(cname)
                .uid(uid)
                .clientRequest(AcquireResourceReq.ClientRequest.builder()
                        .scene(scene)
                        .resourceExpiredHour(clientRequest.getResourceExpiredHour())
                        .regionAffinity(clientRequest.getRegionAffinity())
                        .excludeResourceIds(clientRequest.getExcludeResourceIds())
                        .startParameter(startParameter)
                        .build())
                .build();

        return this.acquireResourceAPI.handle(req);
    }

    @Override
    public Mono<StartResourceRes> start(String cname, String uid, String resourceId,
                                        StartIndividualRecordingClientReq clientRequest) {
        return this.startResourceAPI.handle(resourceId, CloudRecordingModeEnum.INDIVIDUAL, StartResourceReq
                .builder()
                .cname(cname)
                .uid(uid)
                .clientRequest(StartResourceReq.StartClientRequest.builder()
                        .token(clientRequest.getToken())
                        .storageConfig(clientRequest.getStorageConfig())
                        .recordingConfig(clientRequest.getRecordingConfig())
                        .recordingFileConfig(clientRequest.getRecordingFileConfig())
                        .snapshotConfig(clientRequest.getSnapshotConfig())
                        .appsCollection(clientRequest.getAppsCollection())
                        .transcodeOptions(clientRequest.getTranscodeOptions())
                        .build())
                .build());
    }

    @Override
    public Mono<QueryIndividualRecordingResourceRes> query(String resourceId, String sid) {
        return this.queryResourceAPI.handle(resourceId, sid, CloudRecordingModeEnum.INDIVIDUAL)
                .handle((res, sink) -> {
                    sink.next(QueryIndividualRecordingResourceRes.builder()
                            .cname(res.getCname())
                            .uid(res.getUid())
                            .resourceId(res.getResourceId())
                            .sid(res.getSid())
                            .serverResponse(res.getQueryIndividualRecordingServerResponse())
                            .build());

                    sink.complete();
                });
    }

    @Override
    public Mono<QueryIndividualRecordingVideoScreenshotResourceRes> queryVideoScreenshot(String resourceId,
                                                                                         String sid) {
        return this.queryResourceAPI.handle(resourceId, sid, CloudRecordingModeEnum.INDIVIDUAL)
                .handle((res, sink) -> {
                    sink.next(QueryIndividualRecordingVideoScreenshotResourceRes.builder()
                            .cname(res.getCname())
                            .uid(res.getUid())
                            .resourceId(res.getResourceId())
                            .sid(res.getSid())
                            .serverResponse(res
                                    .getQueryIndividualVideoScreenshotServerResponse())
                            .build());

                    sink.complete();
                });
    }

    @Override
    public Mono<UpdateResourceRes> update(String cname, String uid, String resourceId, String sid,
                                          UpdateIndividualRecordingResourceClientReq clientRequest) {
        return this.updateResourceAPI.handle(resourceId, sid, CloudRecordingModeEnum.INDIVIDUAL,
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
        return this.stopResourceAPI.handle(resourceId, sid, CloudRecordingModeEnum.INDIVIDUAL,
                StopResourceReq.builder()
                        .cname(cname)
                        .uid(uid)
                        .clientRequest(StopResourceReq.StopClientRequest.builder()
                                .asyncStop(asyncStop)
                                .build())
                        .build());
    }
}
