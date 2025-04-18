package io.agora.rest.services.cloudrecording;

import io.agora.rest.core.AgoraConfig;
import io.agora.rest.core.DefaultContext;
import io.agora.rest.services.cloudrecording.api.req.*;
import io.agora.rest.services.cloudrecording.api.res.*;
import io.agora.rest.services.cloudrecording.enums.CloudRecordingModeEnum;
import io.agora.rest.services.cloudrecording.scenario.individual.IndividualScenario;
import io.agora.rest.services.cloudrecording.scenario.mix.MixScenario;
import io.agora.rest.services.cloudrecording.scenario.web.WebScenario;
import reactor.core.publisher.Mono;

public abstract class CloudRecordingClient  {

    private static CloudRecordingClient mInstance;

    /**
     * @param cloudRecordingConfig Instance of {@link CloudRecordingConfig}.
     * @return Returns the Cloud Recording client instance.
     * @brief Creates a Cloud Recording client with the specified configuration.
     * @since v0.4.0
     */
    public static synchronized CloudRecordingClient create(CloudRecordingConfig cloudRecordingConfig) {
        if (mInstance == null) {
            AgoraConfig agoraConfig = AgoraConfig.builder()
                    .appId(cloudRecordingConfig.getAppId())
                    .credential(cloudRecordingConfig.getCredential())
                    .domainArea(cloudRecordingConfig.getDomainArea())
                    .httpProperty(cloudRecordingConfig.getHttpProperty())
                    .build();
            mInstance=new CloudRecordingClientImpl(new DefaultContext(agoraConfig));
        }

        return mInstance;
    }


    public abstract Mono<AcquireResourceRes> acquire(AcquireResourceReq request);

    public abstract Mono<StartResourceRes> start(String resourceId, CloudRecordingModeEnum mode, StartResourceReq request);

    public abstract Mono<QueryResourceRes> query(String resourceId, String sid, CloudRecordingModeEnum mode);

    public abstract Mono<StopResourceRes> stop(String resourceId, String sid, CloudRecordingModeEnum mode,
                                               StopResourceReq request);

    public abstract Mono<UpdateResourceRes> update(String resourceId, String sid, CloudRecordingModeEnum mode,
                                                   UpdateResourceReq request);

    public abstract Mono<UpdateLayoutResourceRes> updateLayout(String resourceId, String sid, CloudRecordingModeEnum mode,
                                                               UpdateLayoutResourceReq request);

    /**
     * @brief Returns the individual scenario instance.
     * @return Returns the individual scenario instance.
     * @since v0.4.0
     */
    public abstract IndividualScenario individualScenario();

    /**
     * @brief Returns the web scenario instance.
     * @return Returns the web scenario instance.
     * @since v0.4.0
     */
    public abstract WebScenario webScenario();

    /**
     * @brief Returns the mix scenario instance.
     * @return Returns the mix scenario instance.
     * @since v0.4.0
     */
    public abstract MixScenario mixScenario();
}
