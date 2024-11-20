package io.agora.rest.examples.cloudrecording.scenario;

import io.agora.rest.AgoraService;
import io.agora.rest.core.AgoraProperty;
import io.agora.rest.core.Credential;
import io.agora.rest.core.RegionArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseScenario {

    private static final Logger logger = LoggerFactory.getLogger(BaseScenario.class);

    protected final RegionArea region;

    protected final String appId;

    protected final String cname;

    protected final String uid;

    protected final Credential credential;

    protected final AgoraService agoraService;

    public BaseScenario(RegionArea region, String appId, String cname, String uid, Credential credential) {
        this.region = region;
        this.appId = appId;
        this.cname = cname;
        this.uid = uid;
        this.credential = credential;

        AgoraProperty agoraProperty = AgoraProperty.builder()
                .appId(appId)
                .credential(credential)
                .regionArea(region)
                .build();

        logger.info("AgoraProperty: {}", agoraProperty);

        this.agoraService = new AgoraService(agoraProperty);
    }
}
