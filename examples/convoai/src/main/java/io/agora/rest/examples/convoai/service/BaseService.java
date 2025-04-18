package io.agora.rest.examples.convoai.service;

import io.agora.rest.core.Credential;
import io.agora.rest.core.DomainArea;
import io.agora.rest.services.convoai.ConvoAIClient;
import io.agora.rest.services.convoai.ConvoAIConfig;
import io.agora.rest.services.convoai.ConvoAIServiceRegionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseService {
    private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

    protected final DomainArea domainArea;

    protected final String appId;

    protected final String cname;

    protected final String uid;

    protected final Credential credential;

    protected final ConvoAIServiceRegionEnum serviceRegion;

    protected final ConvoAIClient convoAIClient;

    public BaseService(DomainArea domainArea, String appId, String cname, String uid, Credential credential, ConvoAIServiceRegionEnum serviceRegion) {
        this.domainArea = domainArea;
        this.appId = appId;
        this.cname = cname;
        this.uid = uid;
        this.credential = credential;
        this.serviceRegion = serviceRegion;

        ConvoAIConfig convoAIConfig = ConvoAIConfig.builder()
                .appId(appId)
                .credential(credential)
                .domainArea(domainArea)
                .serverRegion(serviceRegion)
                .build();

        logger.info("ConvoAIConfig: {}", convoAIConfig);

        this.convoAIClient = ConvoAIClient.create(convoAIConfig);
    }
}
