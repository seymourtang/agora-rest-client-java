package io.agora.rest.services.convoai.api.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

public class JoinConvoAIReq {

    @JsonProperty("name")
    private String name;

    @JsonProperty("properties")
    private Properties properties;

    public static class Properties {

        @JsonProperty("token")
        private String token;

        @JsonProperty("channel")
        private String channel;

        @JsonProperty("agent_rtc_uid")
        private String agentRtcUId;

        @JsonProperty("remote_rtc_uids")
        private List<String> remoteRtcUIds;

        @JsonProperty("enable_string_uid")
        private Boolean enableStringUId;

        @JsonProperty("idle_timeout")
        private Integer idleTimeout;

        @JsonProperty("advanced_features")
        private AdvancedFeatures advancedFeatures;

        @JsonProperty("llm")
        private LLM llm;

        @JsonProperty("tts")
        private TTS tts;

        @JsonProperty("vad")
        private Vad vad;

        @JsonProperty("asr")
        private Asr asr;

    }

    public static class AdvancedFeatures {

        @JsonProperty("enable_aivad")
        private Boolean enableAIVad;

        @JsonProperty("enable_bhvs")
        private Boolean EnableBHVS;
    }

    public static class LLM {

        @JsonProperty("url")
        private String url;

        @JsonProperty("api_key")
        private String apiKey;

        @JsonProperty("system_messages")
        private String systemMessages;

        @JsonProperty("params")
        private HashMap<String, Object> params;

        @JsonProperty("max_history")
        private Integer maxHistory;

        @JsonProperty("greeting_message")
        private String greetingMessage;

        @JsonProperty("input_modalities")
        private List<String> inputModalities;

        @JsonProperty("output_modalities")
        private List<String> outputModalities;

        @JsonProperty("failure_message")
        private String failureMessage;

        @JsonProperty("style")
        private String style;
    }

    public interface TTSVendorParams {
    }

    public static class TTS{

        @JsonProperty("vendor")
        private String vendor;

        @JsonProperty("params")
        private TTSVendorParams params;
    }

    public static enum TTSVendorEnum{

        MINIMAX("minimax"),

        TENCENT("tencent"),

        BYTEDANCE("bytedance"),

        MICROSOFT("microsoft"),

        ELEVENLABS("elevenlabs");

        private final String vendor;

        TTSVendorEnum(String vendor) {
            this.vendor = vendor;
        }

        @Override
        public String toString() {
            return this.vendor;
        }
    }

    public static class MinimaxTTSVendorParams implements TTSVendorParams{

        @JsonProperty("group_id")
        private String groupId;

        @JsonProperty("key")
        private String key;

        @JsonProperty("model")
        private String model;

        @JsonProperty("audio_setting")
        private MinimaxTTSVendorAudioSettingParam audioSetting;

        @JsonProperty("voice_setting")
        private MinimaxTTSVendorVoiceSettingParam voiceSetting;
    }

    public static class MinimaxTTSVendorAudioSettingParam{

        @JsonProperty("sample_rate")
        private Integer sampleRate;
    }

    public static class MinimaxTTSVendorVoiceSettingParam{

        @JsonProperty("voice_id")
        private String voiceId;

        @JsonProperty("speed")
        private Float speed;

        @JsonProperty("vol")
        private Float vol;

        @JsonProperty("pitch")
        private Integer pitch;

        @JsonProperty("emotion")
        private String emotion;
    }

    public static class TencentTTSVendorParams implements TTSVendorParams{

        @JsonProperty("app_id")
        private String appId;

        @JsonProperty("secret_id")
        private String secretId;

        @JsonProperty("secret_key")
        private String secretKey;

        @JsonProperty("voice_type")
        private Integer voiceType;

        @JsonProperty("volume")
        private Integer volume;

        @JsonProperty("speed")
        private Integer speed;

        @JsonProperty("emotion_category")
        private String emotionCategory;

        @JsonProperty("emotion_intensity")
        private Integer emotionIntensity;
    }

    public static class BytedanceTTSVendorParams implements TTSVendorParams{

        @JsonProperty("token")
        private String token;

        @JsonProperty("app_id")
        private String appId;

        @JsonProperty("cluster")
        private String cluster;

        @JsonProperty("voice_type")
        private String voiceType;

        @JsonProperty("speed_ratio")
        private Float speedRatio;

        @JsonProperty("volume_ratio")
        private Float volumeRatio;

        @JsonProperty("pitch_ratio")
        private Float pitchRatio;

        @JsonProperty("emotion")
        private String emotion;
    }

    public static class MicrosoftTTSVendorParams implements TTSVendorParams{

        @JsonProperty("key")
        private String key;

        @JsonProperty("region")
        private String region;

        @JsonProperty("voice_name")
        private String voiceName;

        @JsonProperty("rate")
        private Float rate;

        @JsonProperty("volume")
        private Float volume;
    }

    public static class ElevenlabsTTSVendorParams implements TTSVendorParams{

        @JsonProperty("api_key")
        private String apiKey;

        @JsonProperty("model_id")
        private String modelId;

        @JsonProperty("voice_id")
        private String voiceId;
    }

    public static class Vad{

        @JsonProperty("interrupt_duration_ms")
        private Integer interruptDurationMs;

        @JsonProperty("prefix_padding_ms")
        private Integer prefixPaddingMs;

        @JsonProperty("silence_duration_ms")
        private Integer silenceDurationMs;

        @JsonProperty("threshold")
        private Float threshold;
    }

    public static class Asr{

        @JsonProperty("language")
        private String language;
    }

}


