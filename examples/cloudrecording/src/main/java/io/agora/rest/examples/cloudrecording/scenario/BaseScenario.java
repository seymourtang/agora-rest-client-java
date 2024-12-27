package io.agora.rest.examples.cloudrecording.scenario;

import io.agora.rest.core.AgoraConfig;
import io.agora.rest.core.Credential;
import io.agora.rest.core.DomainArea;
import io.agora.rest.services.cloudrecording.CloudRecordingClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseScenario {

    private static final Logger logger = LoggerFactory.getLogger(BaseScenario.class);

    protected final DomainArea domainArea;

    protected final String appId;

    protected final String cname;

    protected final String uid;

    protected final Credential credential;

    protected final CloudRecordingClient cloudRecordingClient;

    public BaseScenario(DomainArea domainArea, String appId, String cname, String uid, Credential credential) {
        this.domainArea = domainArea;
        this.appId = appId;
        this.cname = cname;
        this.uid = uid;
        this.credential = credential;

        AgoraConfig agoraConfig = AgoraConfig.builder()
                .appId(appId)
                .credential(credential)
                .domainArea(domainArea)
                .build();

        logger.info("AgoraConfig: {}", agoraConfig);

        this.cloudRecordingClient = CloudRecordingClient.create(agoraConfig);
    }
}
