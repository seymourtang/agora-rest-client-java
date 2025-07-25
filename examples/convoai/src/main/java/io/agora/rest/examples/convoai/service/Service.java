package io.agora.rest.examples.convoai.service;

import io.agora.rest.AgoraException;
import io.agora.rest.core.Credential;
import io.agora.rest.core.DomainArea;
import io.agora.rest.services.convoai.ConvoAIServiceRegionEnum;
import io.agora.rest.services.convoai.req.JoinConvoAIReq;
import io.agora.rest.services.convoai.req.ListConvoAIReq;
import io.agora.rest.services.convoai.req.SpeakConvoAIReq;
import io.agora.rest.services.convoai.req.UpdateConvoAIReq;
import io.agora.rest.services.convoai.res.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Service extends BaseService {
    private static final Logger logger = LoggerFactory.getLogger(Service.class);

    public Service(DomainArea domainArea, String appId, String cname, String uid, Credential credential,
            ConvoAIServiceRegionEnum serviceRegion) {
        super(domainArea, appId, cname, uid, credential, serviceRegion);
    }

    public void runCustomTTS(JoinConvoAIReq.TTSVendorParams ttsVendorParams) {
        // Run Conversational AI service with custom TTS

        String token = System.getenv("CONVOAI_TOKEN");
        String updateToken = System.getenv("CONVOAI_UPDATE_TOKEN");
        if (updateToken == null) {
            updateToken = "";
        }
        String channel = System.getenv("CONVOAI_CHANNEL");
        if (channel == null || channel.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_CHANNEL is required");
        }

        String agentRtcUId = System.getenv("CONVOAI_AGENT_RTC_UID");
        if (agentRtcUId == null || agentRtcUId.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_AGENT_RTC_UID is required");
        }

        String remoteRtcUIds = System.getenv("CONVOAI_REMOTE_RTC_UIDS");
        if (remoteRtcUIds == null || remoteRtcUIds.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_REMOTE_RTC_UIDS is required");
        }

        String llmURL = System.getenv("CONVOAI_LLM_URL");
        if (llmURL == null || llmURL.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_LLM_URL is required");
        }

        String llmAPIKey = System.getenv("CONVOAI_LLM_API_KEY");
        if (llmAPIKey == null || llmAPIKey.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_LLM_API_KEY is required");
        }

        String llmModel = System.getenv("CONVOAI_LLM_MODEL");
        if (llmModel == null || llmModel.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_LLM_MODEL is required");
        }

        String name = appId + ":" + channel;

        JoinConvoAIRes joinConvoAIRes;
        try {
            joinConvoAIRes = this.convoAIClient.join(JoinConvoAIReq.builder()
                    .name(name)
                    .properties(JoinConvoAIReq.Properties.builder()
                            .token(token)
                            .channel(channel)
                            .agentRtcUId(agentRtcUId)
                            .remoteRtcUIds(new ArrayList<String>() {
                                {
                                    add("*");
                                }
                            })
                            .enableStringUId(false)
                            .idleTimeout(120)
                            .advancedFeatures(JoinConvoAIReq.AdvancedFeatures.builder()
                                    .enableAIVad(true)
                                    .build())
                            .llmPayload(JoinConvoAIReq.LLMPayload.builder()
                                    .url(llmURL)
                                    .apiKey(llmAPIKey)
                                    .params(new HashMap<String, Object>() {
                                        {
                                            put("model", llmModel);
                                            put("max_tokens", 1024);
                                            put("username", "Jack");
                                        }
                                    })
                                    .systemMessages(new ArrayList<Map<String, Object>>() {
                                        {
                                            add(new HashMap<String, Object>() {
                                                {
                                                    put("content", "You are a helpful chatbot。");
                                                    put("role", "system");
                                                }
                                            });
                                        }
                                    })
                                    .maxHistory(30)
                                    .greetingMessage("Hello,how can I help you?")
                                    .build())
                            .ttsPayload(JoinConvoAIReq.TTSPayload.builder()
                                    .vendor(ttsVendorParams.getVendor())
                                    .params(ttsVendorParams)
                                    .build())
                            .asrPayload(JoinConvoAIReq.ASRPayload.builder()
                                    .language("zh-CN")
                                    .build())
                            .parameters(JoinConvoAIReq.Parameters.builder()
                                    .fixedParams(JoinConvoAIReq.FixedParams.builder()
                                            .silenceConfig(JoinConvoAIReq.SilenceConfig.builder()
                                                    .timeoutMs(1000)
                                                    .action("speak")
                                                    .content("Hello,how can I help you?")
                                                    .build())
                                            .build())
                                    .build())
                            .build())
                    .build()).block();
        } catch (AgoraException e) {
            logger.error("Failed to start the agent,err:{}", e.getMessage());
            return;
        } catch (Exception e) {
            logger.error("Unknown exception,err:{}", e.getMessage());
            return;
        }

        if (joinConvoAIRes == null) {
            logger.error("Failed to start the agent");
            return;
        }

        logger.info("Start the agent successfully, joinConvoAIRes:{}", joinConvoAIRes);

        String agentId = joinConvoAIRes.getAgentId();

        for (int i = 0; i < 3; i++) {
            QueryConvoAIRes queryConvoAIRes;
            try {
                queryConvoAIRes = this.convoAIClient.query(agentId).block();
            } catch (AgoraException e) {
                logger.error("Failed to query the agent,err:{}", e.getMessage());
                return;
            } catch (Exception e) {
                logger.error("Unknown exception,err:{}", e.getMessage());
                return;
            }

            if (queryConvoAIRes == null) {
                logger.error("Failed to query the agent");
                return;
            }

            logger.info("Query the agent successfully, queryConvoAIRes:{}", queryConvoAIRes);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        InterruptConvoAIRes interruptConvoAIRes;

        try {
            interruptConvoAIRes = this.convoAIClient.interrupt(agentId).block();
        } catch (AgoraException e) {
            logger.error("Failed to interrupt the agent,err:{}", e.getMessage());
            return;
        } catch (Exception e) {
            logger.error("Unknown exception,err:{}", e.getMessage());
            return;
        }

        if (interruptConvoAIRes == null) {
            logger.error("Failed to interrupt the agent");
            return;
        }

        logger.info("Interrupt the agent successfully, interruptConvoAIRes:{}", interruptConvoAIRes);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        HistoryConvoAIRes historyConvoAIRes;

        try {
            historyConvoAIRes = this.convoAIClient.getHistory(agentId).block();
        } catch (AgoraException e) {
            logger.error("Failed to get the history of the agent,err:{}", e.getMessage());
            return;
        } catch (Exception e) {
            logger.error("Unknown exception,err:{}", e.getMessage());
            return;
        }

        if (historyConvoAIRes == null) {
            logger.error("Failed to get the history of the agent");
            return;
        }

        logger.info("Get the history of the agent successfully, historyConvoAIRes:{}", historyConvoAIRes);

        SpeakConvoAIRes speakConvoAIRes;

        try {
            speakConvoAIRes = this.convoAIClient.speak(agentId, SpeakConvoAIReq.builder()
                    .text("Hello,how can I help you?")
                    .interrupt(true)
                    .priority("INTERRUPT")
                    .build()).block();
        } catch (AgoraException e) {
            logger.error("Failed to speak the agent,err:{}", e.getMessage());
            return;
        } catch (Exception e) {
            logger.error("Unknown exception,err:{}", e.getMessage());
            return;
        }

        if (speakConvoAIRes == null) {
            logger.error("Failed to speak the agent");
            return;
        }

        logger.info("Speak the agent successfully, speakConvoAIRes:{}", speakConvoAIRes);

        ListConvoAIRes listConvoAIRes;
        try {
            listConvoAIRes = this.convoAIClient.list(ListConvoAIReq.builder()
                    .channel(channel)
                    .state(2)
                    .build()).block();
        } catch (AgoraException e) {
            logger.error("Failed to list the agent,err:{}", e.getMessage());
            return;
        } catch (Exception e) {
            logger.error("Unknown exception,err:{}", e.getMessage());
            return;
        }

        if (listConvoAIRes == null) {
            logger.error("Failed to list the agent");
            return;
        }

        logger.info("List the agent successfully, listConvoAIRes:{}", listConvoAIRes);
        UpdateConvoAIRes updateConvoAIRes;

        try {
            updateConvoAIRes = this.convoAIClient.update(agentId, UpdateConvoAIReq.builder()
                    .llm(UpdateConvoAIReq.UpdateLLMParams.builder()
                            .params(new HashMap<String, Object>() {
                                {
                                    put("model", llmModel);
                                    put("max_tokens", 2048);
                                    put("username", "Tom");
                                }
                            })
                            .systemMessages(new ArrayList<Map<String, Object>>() {
                                {
                                    add(new HashMap<String, Object>() {
                                        {
                                            put("content", "You are a helpful chatbot, and you are a new assistant.");
                                            put("role", "system");
                                        }
                                    });
                                }
                            })
                            .build())
                    .token(updateToken)
                    .build()).block();
        } catch (AgoraException e) {
            logger.error("Failed to update the agent,err:{}", e.getMessage());
            return;
        } catch (Exception e) {
            logger.error("Unknown exception,err:{}", e.getMessage());
            return;
        }

        logger.info("Update the agent successfully, updateConvoAIRes:{}", updateConvoAIRes);

        try {
            this.convoAIClient.leave(agentId).block();
            logger.info("Leave the agent successfully, agentId:{}", agentId);
        } catch (AgoraException e) {
            logger.error("Failed to leave the agent,err:{}", e.getMessage());
        } catch (Exception e) {
            logger.error("Unknown exception,err:{}", e.getMessage());
        }
    }

    public void runBytedanceTTS() {
        // Run Conversational AI service with Bytedance TTS
        String ttsToken = System.getenv("CONVOAI_TTS_BYTEDANCE_TOKEN");
        if (ttsToken == null || ttsToken.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_TOKEN is required");
        }

        String ttsAppId = System.getenv("CONVOAI_TTS_BYTEDANCE_APP_ID");
        if (ttsAppId == null || ttsAppId.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_APP_ID is required");
        }

        String ttsCluster = System.getenv("CONVOAI_TTS_BYTEDANCE_CLUSTER");
        if (ttsCluster == null || ttsCluster.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_CLUSTER is required");
        }

        String ttsVoiceType = System.getenv("CONVOAI_TTS_BYTEDANCE_VOICE_TYPE");
        if (ttsVoiceType == null || ttsVoiceType.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_BYTEDANCE_VOICE_TYPE is required");
        }

        JoinConvoAIReq.BytedanceTTSVendorParams ttsVendorParams = JoinConvoAIReq.BytedanceTTSVendorParams.builder()
                .token(ttsToken)
                .cluster(ttsCluster)
                .voiceType(ttsVoiceType)
                .appId(ttsAppId)
                .speedRatio(1.0F)
                .volumeRatio(1.0F)
                .pitchRatio(1.0F)
                .emotion("happy")
                .build();

        runCustomTTS(ttsVendorParams);
    }

    public void runTencentTTS() {
        // Run Conversational AI service with Tencent TTS
        String ttsAppId = System.getenv("CONVOAI_TTS_TENCENT_APP_ID");
        if (ttsAppId == null || ttsAppId.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_TENCENT_APP_ID is required");
        }

        String ttsSecretId = System.getenv("CONVOAI_TTS_TENCENT_SECRET_ID");
        if (ttsSecretId == null || ttsSecretId.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_TENCENT_SECRET_ID is required");
        }

        String ttsSecretKey = System.getenv("CONVOAI_TTS_TENCENT_SECRET_KEY");
        if (ttsSecretKey == null || ttsSecretKey.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_TENCENT_SECRET_KEY is required");
        }

        JoinConvoAIReq.TencentTTSVendorParams ttsVendorParams = JoinConvoAIReq.TencentTTSVendorParams.builder()
                .appId(ttsAppId)
                .secretId(ttsSecretId)
                .secretKey(ttsSecretKey)
                .voiceType(601005)
                .volume(0)
                .speed(0)
                .emotionCategory("happy")
                .emotionIntensity(100)
                .build();

        runCustomTTS(ttsVendorParams);

    }

    public void runMinimaxTTS() {
        // Run Conversational AI service with Minimax TTS
        String ttsGroupId = System.getenv("CONVOAI_TTS_MINIMAX_GROUP_ID");
        if (ttsGroupId == null || ttsGroupId.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_MINIMAX_GROUP_ID is required");
        }

        String ttsGroupKey = System.getenv("CONVOAI_TTS_MINIMAX_GROUP_KEY");
        if (ttsGroupKey == null || ttsGroupKey.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_MINIMAX_GROUP_KEY is required");
        }

        String ttsGroupModel = System.getenv("CONVOAI_TTS_MINIMAX_GROUP_MODEL");
        if (ttsGroupModel == null || ttsGroupModel.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_MINIMAX_GROUP_MODEL is required");
        }

        JoinConvoAIReq.MinimaxTTSVendorParams ttsVendorParams = JoinConvoAIReq.MinimaxTTSVendorParams.builder()
                .groupId(ttsGroupId)
                .key(ttsGroupKey)
                .model(ttsGroupModel)
                .voiceSetting(JoinConvoAIReq.MinimaxTTSVendorVoiceSettingParam.builder()
                        .voiceId("female-shaonv")
                        .speed(1F)
                        .vol(1F)
                        .pitch(0)
                        .emotion("happy")
                        .latexRead(true)
                        .englishNormalization(true)
                        .build())
                .audioSetting(JoinConvoAIReq.MinimaxTTSVendorAudioSettingParam.builder()
                        .sampleRate(24000)
                        .build())
                .languageBoost("auto")
                .build();

        runCustomTTS(ttsVendorParams);
    }

    public void runMicrosoftTTS() {
        // Run Conversational AI service with Microsoft TTS
        String ttsKey = System.getenv("CONVOAI_TTS_MICROSOFT_KEY");
        if (ttsKey == null || ttsKey.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_MICROSOFT_KEY is required");
        }

        String ttsRegion = System.getenv("CONVOAI_TTS_MICROSOFT_REGION");
        if (ttsRegion == null || ttsRegion.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_MICROSOFT_REGION is required");
        }

        String ttsVoiceName = System.getenv("CONVOAI_TTS_MICROSOFT_VOICE_NAME");
        if (ttsVoiceName == null || ttsVoiceName.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_MICROSOFT_VOICE_NAME is required");
        }

        JoinConvoAIReq.MicrosoftTTSVendorParams ttsVendorParams = JoinConvoAIReq.MicrosoftTTSVendorParams.builder()
                .key(ttsKey)
                .region(ttsRegion)
                .voiceName(ttsVoiceName)
                .speed(1.8F)
                .sampleRate(24000)
                .volume(70F)
                .build();

        runCustomTTS(ttsVendorParams);
    }

    public void runElevenlabsTTS() {
        // Run Conversational AI service with Elevenlabs TTS
        String ttsApiKey = System.getenv("CONVOAI_TTS_ELEVENLABS_API_KEY");
        if (ttsApiKey == null || ttsApiKey.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_ELEVENLABS_API_KEY is required");
        }

        String ttsModelId = System.getenv("CONVOAI_TTS_ELEVENLABS_MODEL_ID");
        if (ttsModelId == null || ttsModelId.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_ELEVENLABS_MODEL_ID is required");
        }

        String ttsVoiceId = System.getenv("CONVOAI_TTS_ELEVENLABS_VOICE_ID");
        if (ttsVoiceId == null || ttsVoiceId.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_ELEVENLABS_VOICE_ID is required");
        }

        JoinConvoAIReq.ElevenLabsTTSVendorParams ttsVendorParams = JoinConvoAIReq.ElevenLabsTTSVendorParams.builder()
                .key(ttsApiKey)
                .modelId(ttsModelId)
                .voiceId(ttsVoiceId)
                .sampleRate(24000)
                .build();

        runCustomTTS(ttsVendorParams);
    }

    public void runCartesiaTTS() {
        // Run Conversational AI service with Cartesia TTS
        String ttsApiKey = System.getenv("CONVOAI_TTS_CARTESIA_API_KEY");
        if (ttsApiKey == null || ttsApiKey.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_CARTESIA_API_KEY is required");
        }

        String ttsModelId = System.getenv("CONVOAI_TTS_CARTESIA_MODEL_ID");
        if (ttsModelId == null || ttsModelId.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_CARTESIA_MODEL_ID is required");
        }

        String ttsVoiceMode = System.getenv("CONVOAI_TTS_CARTESIA_VOICE_MODE");
        if (ttsVoiceMode == null || ttsVoiceMode.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_CARTESIA_VOICE_MODE is required");
        }

        String ttsVoiceId = System.getenv("CONVOAI_TTS_CARTESIA_VOICE_ID");
        if (ttsVoiceId == null || ttsVoiceId.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_CARTESIA_VOICE_ID is required");
        }

        JoinConvoAIReq.CartesiaTTSVendorParams ttsVendorParams = JoinConvoAIReq.CartesiaTTSVendorParams.builder()
                .apiKey(ttsApiKey)
                .modelId(ttsModelId)
                .voice(JoinConvoAIReq.TTSCartesiaVendorVoice.builder()
                        .mode(ttsVoiceMode)
                        .id(ttsVoiceId)
                        .build())
                .build();

        runCustomTTS(ttsVendorParams);
    }

    public void runOpenAITTS() {
        // Run Conversational AI service with OpenAI TTS
        String ttsApiKey = System.getenv("CONVOAI_TTS_OPENAI_API_KEY");
        if (ttsApiKey == null || ttsApiKey.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_OPENAI_API_KEY is required");
        }

        String ttsModel = System.getenv("CONVOAI_TTS_OPENAI_MODEL");
        if (ttsModel == null || ttsModel.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_OPENAI_MODEL is required");
        }

        String ttsVoice = System.getenv("CONVOAI_TTS_OPENAI_VOICE");
        if (ttsVoice == null || ttsVoice.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_OPENAI_VOICE is required");
        }

        String ttsInstructions = System.getenv("CONVOAI_TTS_OPENAI_INSTRUCTIONS");
        if (ttsInstructions == null || ttsInstructions.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_OPENAI_INSTRUCTIONS is required");
        }

        String ttsSpeed = System.getenv("CONVOAI_TTS_OPENAI_SPEED");
        if (ttsSpeed == null || ttsSpeed.isEmpty()) {
            throw new IllegalArgumentException("CONVOAI_TTS_OPENAI_SPEED is required");
        }

        Float speed = null;
        try {
            speed = Float.parseFloat(ttsSpeed);
        } catch (Exception e) {
            throw new IllegalArgumentException("CONVOAI_TTS_OPENAI_SPEED is not a valid float");
        }

        JoinConvoAIReq.TTSOpenAIVendorParams ttsVendorParams = JoinConvoAIReq.TTSOpenAIVendorParams.builder()
                .apiKey(ttsApiKey)
                .model(ttsModel)
                .voice(ttsVoice)
                .instructions(ttsInstructions)
                .speed(speed)
                .build();

        runCustomTTS(ttsVendorParams);
    }
}
