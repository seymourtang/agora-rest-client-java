package io.agora.rest.examples.convoai.service;

import io.agora.rest.core.Credential;
import io.agora.rest.core.DomainArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service extends BaseService {
    private static final Logger logger = LoggerFactory.getLogger(Service.class);


    public Service(DomainArea domainArea, String appId, String cname, String uid, Credential credential) {
        super(domainArea, appId, cname, uid, credential);
    }

    public void runWithCustomTTS(){

    }

    public void runWithBytedanceTTS(){

    }

    public void runWithTencentTTS(){

    }

    public void runWithMinimaxTTS(){

    }

    public void runWithMicrosoftTTS(){

    }

    public void runWithElevenlabsTTS(){

    }
}
