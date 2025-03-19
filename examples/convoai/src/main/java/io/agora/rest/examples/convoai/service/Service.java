package io.agora.rest.examples.convoai.service;

import io.agora.rest.core.Credential;
import io.agora.rest.core.DomainArea;
import io.agora.rest.services.convoai.ConvoAIServiceRegionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service extends BaseService {
    private static final Logger logger = LoggerFactory.getLogger(Service.class);


    public Service(DomainArea domainArea, String appId, String cname, String uid, Credential credential, ConvoAIServiceRegionEnum serviceRegion) {
        super(domainArea, appId, cname, uid, credential, serviceRegion);
    }

    public void runWithCustomTTS(){

    }

    public void runBytedanceTTS(){
        // Run Conversational AI service with Bytedance TTS
    }

    public void runTencentTTS(){
        // Run Conversational AI service with Tencent TTS

    }

    public void runMinimaxTTS(){
        // Run Conversational AI service with Minimax TTS

    }

    public void runMicrosoftTTS(){
        // Run Conversational AI service with Microsoft TTS

    }

    public void runElevenlabsTTS(){
        // Run Conversational AI service with Elevenlabs TTS

    }
}
