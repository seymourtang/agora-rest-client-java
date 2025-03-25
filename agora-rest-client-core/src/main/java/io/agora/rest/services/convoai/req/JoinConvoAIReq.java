package io.agora.rest.services.convoai.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @brief Request Body parameters for calling the Conversational AI engine Join API
 * @since v0.3.0
 */
public class JoinConvoAIReq {

    /**
     * Unique identifier for the agent, cannot be duplicated
     */
    @JsonProperty("name")
    private String name;

    /**
     * Configuration properties for the agent. See {@link Properties} for details
     */
    @JsonProperty("properties")
    private Properties properties;

    public static Builder builder() {
        return new Builder();
    }

    private JoinConvoAIReq(Builder builder) {
        setName(builder.name);
        setProperties(builder.properties);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    /**
     * @brief Configuration properties for agent to join RTC channel
     * @since v0.3.0
     */
    public static class Properties {

        /**
         * Token used to join the RTC channel, i.e., the dynamic key for authentication (optional).
         * <p>
         * If your project has enabled App Certificate, be sure to pass the dynamic key of your project in this field
         */
        @JsonProperty("token")
        private String token;

        /**
         * RTC channel name the agent joins (required)
         */
        @JsonProperty("channel")
        private String channel;

        /**
         * User ID of the agent in the RTC channel (required)
         * <p>
         * Filling "0" means a random assignment, but the Token needs to be modified accordingly
         * <p>
         */
        @JsonProperty("agent_rtc_uid")
        private String agentRtcUId;

        /**
         * List of user IDs that the agent subscribes to in the RTC channel, only subscribed users can interact with the agent (required)
         * <p>
         * Passing "*" means subscribing to all users in the channel.
         * <p>
         */
        @JsonProperty("remote_rtc_uids")
        private List<String> remoteRtcUIds;

        /**
         * Whether to enable String UID (optional)
         * <p>
         * - true: Enable String UID
         * <p>
         * - false: Disable String UID (default)
         */
        @JsonProperty("enable_string_uid")
        private Boolean enableStringUId;

        /**
         * Maximum idle time of the RTC channel (s) (optional)
         * <p>
         * The time after detecting that all users specified in remote_rtc_uids have left the channel is considered idle time.
         * <p>
         * If it exceeds the set maximum value, the agent in the channel will automatically stop and exit the channel.
         * <p>
         * If set to 0, the agent will not stop until manually exited
         * <p>
         */
        @JsonProperty("idle_timeout")
        private Integer idleTimeout;

        /**
         * Agent user ID in the RTM channel
         * <p>
         * Only valid when advanced_features.enable_rtm is true.
         * <p>
         */
        @JsonProperty("agent_rtm_uid")
        private String agentRtmUId;

        /**
         * Advanced feature configurations (optional), see {@link AdvancedFeatures} for details
         */
        @JsonProperty("advanced_features")
        private AdvancedFeatures advancedFeatures;

        /**
         * Custom language model (LLM) configuration (required), see {@link LLM} for details
         */
        @JsonProperty("llm")
        private LLM llm;

        /**
         * Text-to-Speech (TTS) module configuration (required), see {@link TTS} for details
         */
        @JsonProperty("tts")
        private TTS tts;

        /**
         * Voice Activity Detection (VAD) configuration (optional), see {@link Vad} for details
         */
        @JsonProperty("vad")
        private Vad vad;

        /**
         * Automatic Speech Recognition (ASR) configuration (optional), see {@link Asr} for details
         */
        @JsonProperty("asr")
        private Asr asr;


        public static Builder builder() {
            return new Builder();
        }

        private Properties(Builder builder) {
            setToken(builder.token);
            setChannel(builder.channel);
            setAgentRtcUId(builder.agentRtcUId);
            setRemoteRtcUIds(builder.remoteRtcUIds);
            setEnableStringUId(builder.enableStringUId);
            setIdleTimeout(builder.idleTimeout);
            setAgentRtmUId(builder.agentRtmUId);
            setAdvancedFeatures(builder.advancedFeatures);
            setLlm(builder.llm);
            setTts(builder.tts);
            setVad(builder.vad);
            setAsr(builder.asr);
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getAgentRtcUId() {
            return agentRtcUId;
        }

        public void setAgentRtcUId(String agentRtcUId) {
            this.agentRtcUId = agentRtcUId;
        }

        public List<String> getRemoteRtcUIds() {
            return remoteRtcUIds;
        }

        public void setRemoteRtcUIds(List<String> remoteRtcUIds) {
            this.remoteRtcUIds = remoteRtcUIds;
        }

        public Boolean getEnableStringUId() {
            return enableStringUId;
        }

        public void setEnableStringUId(Boolean enableStringUId) {
            this.enableStringUId = enableStringUId;
        }

        public Integer getIdleTimeout() {
            return idleTimeout;
        }

        public void setIdleTimeout(Integer idleTimeout) {
            this.idleTimeout = idleTimeout;
        }

        public String getAgentRtmUId() {
            return agentRtmUId;
        }

        public void setAgentRtmUId(String agentRtmUId) {
            this.agentRtmUId = agentRtmUId;
        }

        public AdvancedFeatures getAdvancedFeatures() {
            return advancedFeatures;
        }

        public void setAdvancedFeatures(AdvancedFeatures advancedFeatures) {
            this.advancedFeatures = advancedFeatures;
        }

        public LLM getLlm() {
            return llm;
        }

        public void setLlm(LLM llm) {
            this.llm = llm;
        }

        public TTS getTts() {
            return tts;
        }

        public void setTts(TTS tts) {
            this.tts = tts;
        }

        public Vad getVad() {
            return vad;
        }

        public void setVad(Vad vad) {
            this.vad = vad;
        }

        public Asr getAsr() {
            return asr;
        }

        public void setAsr(Asr asr) {
            this.asr = asr;
        }

        public static final class Builder {
            private String token;
            private String channel;
            private String agentRtcUId;
            private List<String> remoteRtcUIds;
            private Boolean enableStringUId;
            private Integer idleTimeout;
            private String agentRtmUId;
            private AdvancedFeatures advancedFeatures;
            private LLM llm;
            private TTS tts;
            private Vad vad;
            private Asr asr;

            private Builder() {
            }

            public Builder token(String val) {
                token = val;
                return this;
            }

            public Builder channel(String val) {
                channel = val;
                return this;
            }

            public Builder agentRtcUId(String val) {
                agentRtcUId = val;
                return this;
            }

            public Builder remoteRtcUIds(List<String> val) {
                remoteRtcUIds = val;
                return this;
            }

            public Builder enableStringUId(Boolean val) {
                enableStringUId = val;
                return this;
            }

            public Builder idleTimeout(Integer val) {
                idleTimeout = val;
                return this;
            }

            public Builder agentRtmUId(String val) {
                agentRtmUId = val;
                return this;
            }

            public Builder advancedFeatures(AdvancedFeatures val) {
                advancedFeatures = val;
                return this;
            }

            public Builder llm(LLM val) {
                llm = val;
                return this;
            }

            public Builder tts(TTS val) {
                tts = val;
                return this;
            }

            public Builder vad(Vad val) {
                vad = val;
                return this;
            }

            public Builder asr(Asr val) {
                asr = val;
                return this;
            }

            public Properties build() {
                return new Properties(this);
            }
        }
    }

    /**
     * @brief Defines advanced feature configurations for the agent to join the RTC channel
     * @since v0.3.0
     */
    public static class AdvancedFeatures {

        /**
         * Whether to enable graceful interruption (AIVAD) (optional)
         * <p>
         * - true: Enable
         * <p>
         * - false: Disable (default)
         * <p>
         * When enabled, users can interrupt the AI at any time and respond quickly, achieving natural transitions and smooth conversations.
         */
        @JsonProperty("enable_aivad")
        private Boolean enableAIVad;

        /**
         * Whether to enable the Real-time Messaging (RTM) module (optional)
         * <p>
         * - true: Enable
         * <p>
         * - false: Disable (default)
         * <p>
         * When enabled, the agent can use the capabilities provided by RTM to implement some advanced features.
         */
        @JsonProperty("enable_rtm")
        private Boolean enableRtm;

        public static Builder builder() {
            return new Builder();
        }

        private AdvancedFeatures(Builder builder) {
            setEnableAIVad(builder.enableAIVad);
            setEnableRtm(builder.enableRtm);
        }

        public Boolean getEnableAIVad() {
            return enableAIVad;
        }

        public void setEnableAIVad(Boolean enableAIVad) {
            this.enableAIVad = enableAIVad;
        }

        public Boolean getEnableRtm() {
            return enableRtm;
        }

        public void setEnableRtm(Boolean enableRtm) {
            this.enableRtm = enableRtm;
        }

        public static final class Builder {
            private Boolean enableAIVad;
            private Boolean enableRtm;

            private Builder() {
            }

            public Builder enableAIVad(Boolean val) {
                enableAIVad = val;
                return this;
            }

            public Builder enableRtm(Boolean val) {
                enableRtm = val;
                return this;
            }

            public AdvancedFeatures build() {
                return new AdvancedFeatures(this);
            }
        }
    }

    /**
     * @brief Defines the custom language model (LLM) configuration for the agent to join the RTC channel
     * @since v0.3.0
     */
    public static class LLM {

        /**
         * LLM callback URL (required)
         * <p>
         * Must be compatible with OpenAI protocol
         */
        @JsonProperty("url")
        private String url;

        /**
         * LLM API key for verification (required)
         * <p>
         * Default is empty, make sure to enable the API key in the production environment
         */
        @JsonProperty("api_key")
        private String apiKey;

        /**
         * A set of predefined information attached at the beginning of each LLM call to control LLM output (optional)
         * <p>
         * Can be role settings, prompts, and answer samples, must be compatible with the OpenAI protocol
         */
        @JsonProperty("system_messages")
        private List<Map<String, Object>> systemMessages;

        /**
         * Additional information transmitted in the LLM message body, such as the model used, maximum token Limit, etc. (optional)
         * <p>
         * Different LLM providers support different configurations, see their respective LLM documentation for details.
         */
        @JsonProperty("params")
        private HashMap<String, Object> params;

        /**
         * Number of short-term memory entries cached in LLM (optional)
         * <p>
         * Default value is 10
         * <p>
         * Passing 0 means no short-term memory is cached. The agent and subscribed users will record entries separately.
         */
        @JsonProperty("max_history")
        private Integer maxHistory;

        /**
         * Agent greeting message (optional)
         * <p>
         * If filled, the agent will automatically send a greeting message to the first subscribed user who joins the channel when there are no users in the remote_rtc_uids list.
         */
        @JsonProperty("greeting_message")
        private String greetingMessage;

        /**
         * Input modalities for the LLM (optional)
         * <p>
         * - ["text"]: Text only (default)
         * <p>
         * - ["text", "image"]: Text and image, requires the selected LLM to support visual modality input
         */
        @JsonProperty("input_modalities")
        private List<String> inputModalities;

        /**
         * Output modalities for the LLM (optional)
         * <p>
         * - ["text"]: Text only (default), the output text will be converted to speech by the TTS module and then published to the RTC channel.
         * <p>
         * - ["audio"]: Audio only. The audio will be directly published to the RTC channel.
         * <p>
         * - ["text", "audio"]: Text and audio. You can write your own logic to handle the LLM output as needed.
         */
        @JsonProperty("output_modalities")
        private List<String> outputModalities;

        /**
         * Failure message of the agent (optional)
         * <p>
         * If filled, it will be returned through the TTS module when the LLM call fails.
         */
        @JsonProperty("failure_message")
        private String failureMessage;

        public static Builder builder() {
            return new Builder();
        }

        private LLM(Builder builder) {
            setUrl(builder.url);
            setApiKey(builder.apiKey);
            setSystemMessages(builder.systemMessages);
            setParams(builder.params);
            setMaxHistory(builder.maxHistory);
            setGreetingMessage(builder.greetingMessage);
            setInputModalities(builder.inputModalities);
            setOutputModalities(builder.outputModalities);
            setFailureMessage(builder.failureMessage);
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public List<Map<String, Object>> getSystemMessages() {
            return systemMessages;
        }

        public void setSystemMessages(List<Map<String, Object>> systemMessages) {
            this.systemMessages = systemMessages;
        }

        public HashMap<String, Object> getParams() {
            return params;
        }

        public void setParams(HashMap<String, Object> params) {
            this.params = params;
        }

        public Integer getMaxHistory() {
            return maxHistory;
        }

        public void setMaxHistory(Integer maxHistory) {
            this.maxHistory = maxHistory;
        }

        public String getGreetingMessage() {
            return greetingMessage;
        }

        public void setGreetingMessage(String greetingMessage) {
            this.greetingMessage = greetingMessage;
        }

        public List<String> getInputModalities() {
            return inputModalities;
        }

        public void setInputModalities(List<String> inputModalities) {
            this.inputModalities = inputModalities;
        }

        public List<String> getOutputModalities() {
            return outputModalities;
        }

        public void setOutputModalities(List<String> outputModalities) {
            this.outputModalities = outputModalities;
        }

        public String getFailureMessage() {
            return failureMessage;
        }

        public void setFailureMessage(String failureMessage) {
            this.failureMessage = failureMessage;
        }

        public static final class Builder {
            private String url;
            private String apiKey;
            private List<Map<String, Object>> systemMessages;
            private HashMap<String, Object> params;
            private Integer maxHistory;
            private String greetingMessage;
            private List<String> inputModalities;
            private List<String> outputModalities;
            private String failureMessage;

            private Builder() {
            }

            public Builder url(String val) {
                url = val;
                return this;
            }

            public Builder apiKey(String val) {
                apiKey = val;
                return this;
            }

            public Builder systemMessages(List<Map<String, Object>> val) {
                systemMessages = val;
                return this;
            }

            public Builder params(HashMap<String, Object> val) {
                params = val;
                return this;
            }

            public Builder maxHistory(Integer val) {
                maxHistory = val;
                return this;
            }

            public Builder greetingMessage(String val) {
                greetingMessage = val;
                return this;
            }

            public Builder inputModalities(List<String> val) {
                inputModalities = val;
                return this;
            }

            public Builder outputModalities(List<String> val) {
                outputModalities = val;
                return this;
            }

            public Builder failureMessage(String val) {
                failureMessage = val;
                return this;
            }

            public LLM build() {
                return new LLM(this);
            }
        }
    }

    public interface TTSVendorParams {
    }

    /**
     * @brief Defines the Text-to-Speech (TTS) module configuration for the agent to join the RTC channel
     * @since v0.3.0
     */
    public static class TTS {

        /**
         * TTS vendor, see {@link TTSVendorEnum}
         */
        @JsonProperty("vendor")
        private TTSVendorEnum vendor;

        /**
         * TTS vendor parameter description, see
         * <p>
         * - {@link MinimaxTTSVendorParams}
         * <p>
         * - {@link TencentTTSVendorParams}
         * <p>
         * - {@link BytedanceTTSVendorParams}
         * <p>
         * - {@link MicrosoftTTSVendorParams}
         * <p>
         * - {@link ElevenLabsTTSVendorParams}
         */
        @JsonProperty("params")
        private TTSVendorParams params;

        public static Builder builder() {
            return new Builder();
        }

        private TTS(Builder builder) {
            setVendor(builder.vendor);
            setParams(builder.params);
        }

        public TTSVendorParams getParams() {
            return params;
        }

        public void setParams(TTSVendorParams params) {
            this.params = params;
        }

        public TTSVendorEnum getVendor() {
            return vendor;
        }

        public void setVendor(TTSVendorEnum vendor) {
            this.vendor = vendor;
        }

        public static final class Builder {
            private TTSVendorEnum vendor;
            private TTSVendorParams params;

            private Builder() {
            }

            public Builder vendor(TTSVendorEnum val) {
                vendor = val;
                return this;
            }

            public Builder params(TTSVendorParams val) {
                params = val;
                return this;
            }

            public TTS build() {
                return new TTS(this);
            }
        }
    }

    /**
     * @brief Defines Text-to-Speech (TTS) module vendor enumeration for agent to join RTC channel
     * @since v0.3.0
     */
    public enum TTSVendorEnum {

        // Minimax TTS vendor
        MINIMAX("minimax"),

        // Tencent TTS vendor
        TENCENT("tencent"),

        // Bytedance TTS vendor
        BYTEDANCE("bytedance"),

        // Microsoft TTS vendor
        MICROSOFT("microsoft"),

        // ElevenLabs TTS vendor
        ELEVENLABS("elevenLabs");

        private final String vendor;

        TTSVendorEnum(String vendor) {
            this.vendor = vendor;
        }

        public static TTSVendorEnum getEnum(String vendor) {
            for (TTSVendorEnum e : TTSVendorEnum.values()) {
                if (e.vendor.equals(vendor)) {
                    return e;
                }
            }
            return null;
        }

        @JsonValue
        public String toJson() {
            return vendor;
        }

        @Override
        public String toString() {
            return this.vendor;
        }

    }

    /**
     * @brief Defines the Minimax vendor parameters for the Text-to-Speech (TTS) module when the agent joins the RTC channel, see
     * <a href="https://platform.minimaxi.com/document/T2A%20V2">Minimax</a>
     * @since v0.3.0
     */
    public static class MinimaxTTSVendorParams implements TTSVendorParams {

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

        public static Builder builder() {
            return new Builder();
        }

        private MinimaxTTSVendorParams(Builder builder) {
            setGroupId(builder.groupId);
            setKey(builder.key);
            setModel(builder.model);
            setAudioSetting(builder.audioSetting);
            setVoiceSetting(builder.voiceSetting);
        }

        public MinimaxTTSVendorVoiceSettingParam getVoiceSetting() {
            return voiceSetting;
        }

        public void setVoiceSetting(MinimaxTTSVendorVoiceSettingParam voiceSetting) {
            this.voiceSetting = voiceSetting;
        }

        public MinimaxTTSVendorAudioSettingParam getAudioSetting() {
            return audioSetting;
        }

        public void setAudioSetting(MinimaxTTSVendorAudioSettingParam audioSetting) {
            this.audioSetting = audioSetting;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public static final class Builder {

            private String groupId;

            private String key;

            private String model;

            private MinimaxTTSVendorAudioSettingParam audioSetting;

            private MinimaxTTSVendorVoiceSettingParam voiceSetting;

            private Builder() {

            }

            public Builder groupId(String groupId) {
                this.groupId = groupId;
                return this;
            }

            public Builder key(String key) {
                this.key = key;
                return this;
            }

            public Builder model(String model) {
                this.model = model;
                return this;
            }

            public Builder audioSetting(MinimaxTTSVendorAudioSettingParam audioSetting) {
                this.audioSetting = audioSetting;
                return this;
            }

            public Builder voiceSetting(MinimaxTTSVendorVoiceSettingParam voiceSetting) {
                this.voiceSetting = voiceSetting;
                return this;
            }

            public MinimaxTTSVendorParams build() {
                return new MinimaxTTSVendorParams(this);
            }
        }
    }

    public static class MinimaxTTSVendorAudioSettingParam {

        @JsonProperty("sample_rate")
        private Integer sampleRate;

        public static Builder builder() {
            return new Builder();
        }

        private MinimaxTTSVendorAudioSettingParam(Builder builder) {
            setSampleRate(builder.sampleRate);
        }

        public Integer getSampleRate() {
            return sampleRate;
        }

        public void setSampleRate(Integer sampleRate) {
            this.sampleRate = sampleRate;
        }

        public static final class Builder {
            private Integer sampleRate;

            private Builder() {
            }

            public Builder sampleRate(Integer val) {
                sampleRate = val;
                return this;
            }

            public MinimaxTTSVendorAudioSettingParam build() {
                return new MinimaxTTSVendorAudioSettingParam(this);
            }
        }
    }

    public static class MinimaxTTSVendorVoiceSettingParam {

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

        public static Builder builder() {
            return new Builder();
        }

        private MinimaxTTSVendorVoiceSettingParam(Builder builder) {
            setVoiceId(builder.voiceId);
            setSpeed(builder.speed);
            setVol(builder.vol);
            setPitch(builder.pitch);
            setEmotion(builder.emotion);
        }

        public String getEmotion() {
            return emotion;
        }

        public void setEmotion(String emotion) {
            this.emotion = emotion;
        }

        public Integer getPitch() {
            return pitch;
        }

        public void setPitch(Integer pitch) {
            this.pitch = pitch;
        }

        public Float getVol() {
            return vol;
        }

        public void setVol(Float vol) {
            this.vol = vol;
        }

        public Float getSpeed() {
            return speed;
        }

        public void setSpeed(Float speed) {
            this.speed = speed;
        }

        public String getVoiceId() {
            return voiceId;
        }

        public void setVoiceId(String voiceId) {
            this.voiceId = voiceId;
        }

        public static final class Builder {
            private String voiceId;
            private Float speed;
            private Float vol;
            private Integer pitch;
            private String emotion;

            private Builder() {
            }

            public Builder voiceId(String val) {
                voiceId = val;
                return this;
            }

            public Builder speed(Float val) {
                speed = val;
                return this;
            }

            public Builder vol(Float val) {
                vol = val;
                return this;
            }

            public Builder pitch(Integer val) {
                pitch = val;
                return this;
            }

            public Builder emotion(String val) {
                emotion = val;
                return this;
            }

            public MinimaxTTSVendorVoiceSettingParam build() {
                return new MinimaxTTSVendorVoiceSettingParam(this);
            }
        }
    }

    /**
     * @brief @brief Defines the Tencent vendor parameters for the Text-to-Speech (TTS) module when the agent joins the RTC channel, see
     * <a href="https://cloud.tencent.com/document/product/1073/94308">Tencent</a>
     * @since v0.3.0
     */
    public static class TencentTTSVendorParams implements TTSVendorParams {
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

        public static Builder builder() {
            return new Builder();
        }

        private TencentTTSVendorParams(Builder builder) {
            setAppId(builder.appId);
            setSecretId(builder.secretId);
            setSecretKey(builder.secretKey);
            setVoiceType(builder.voiceType);
            setVolume(builder.volume);
            setSpeed(builder.speed);
            setEmotionCategory(builder.emotionCategory);
            setEmotionIntensity(builder.emotionIntensity);
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getSecretId() {
            return secretId;
        }

        public void setSecretId(String secretId) {
            this.secretId = secretId;
        }

        public String getSecretKey() {
            return secretKey;
        }

        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }

        public Integer getVoiceType() {
            return voiceType;
        }

        public void setVoiceType(Integer voiceType) {
            this.voiceType = voiceType;
        }

        public Integer getVolume() {
            return volume;
        }

        public void setVolume(Integer volume) {
            this.volume = volume;
        }

        public Integer getSpeed() {
            return speed;
        }

        public void setSpeed(Integer speed) {
            this.speed = speed;
        }

        public String getEmotionCategory() {
            return emotionCategory;
        }

        public void setEmotionCategory(String emotionCategory) {
            this.emotionCategory = emotionCategory;
        }

        public Integer getEmotionIntensity() {
            return emotionIntensity;
        }

        public void setEmotionIntensity(Integer emotionIntensity) {
            this.emotionIntensity = emotionIntensity;
        }

        public static final class Builder {

            private String appId;

            private String secretId;

            private String secretKey;

            private Integer voiceType;

            private Integer volume;

            private Integer speed;

            private String emotionCategory;

            private Integer emotionIntensity;

            private Builder() {
            }

            public Builder appId(String appId) {
                this.appId = appId;
                return this;
            }

            public Builder secretId(String secretId) {
                this.secretId = secretId;
                return this;
            }

            public Builder secretKey(String secretKey) {
                this.secretKey = secretKey;
                return this;
            }

            public Builder voiceType(Integer voiceType) {
                this.voiceType = voiceType;
                return this;
            }

            public Builder volume(Integer volume) {
                this.volume = volume;
                return this;
            }

            public Builder speed(Integer speed) {
                this.speed = speed;
                return this;
            }

            public Builder emotionCategory(String emotionCategory) {
                this.emotionCategory = emotionCategory;
                return this;
            }

            public Builder emotionIntensity(Integer emotionIntensity) {
                this.emotionIntensity = emotionIntensity;
                return this;
            }

            public TencentTTSVendorParams build() {
                return new TencentTTSVendorParams(this);
            }
        }
    }

    /**
     * @brief Defines the Bytedance vendor parameters for the Text-to-Speech (TTS) module when the agent joins the RTC channel, see
     * <a href="https://www.volcengine.com/docs/6561/79823">Bytedance</a>
     * @since v0.3.0
     */
    public static class BytedanceTTSVendorParams implements TTSVendorParams {

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

        public static Builder builder() {
            return new Builder();
        }

        private BytedanceTTSVendorParams(Builder builder) {
            setToken(builder.token);
            setAppId(builder.appId);
            setCluster(builder.cluster);
            setVoiceType(builder.voiceType);
            setSpeedRatio(builder.speedRatio);
            setVolumeRatio(builder.volumeRatio);
            setPitchRatio(builder.pitchRatio);
            setEmotion(builder.emotion);
        }

        public Float getPitchRatio() {
            return pitchRatio;
        }

        public void setPitchRatio(Float pitchRatio) {
            this.pitchRatio = pitchRatio;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getCluster() {
            return cluster;
        }

        public void setCluster(String cluster) {
            this.cluster = cluster;
        }

        public String getVoiceType() {
            return voiceType;
        }

        public void setVoiceType(String voiceType) {
            this.voiceType = voiceType;
        }

        public Float getSpeedRatio() {
            return speedRatio;
        }

        public void setSpeedRatio(Float speedRatio) {
            this.speedRatio = speedRatio;
        }

        public Float getVolumeRatio() {
            return volumeRatio;
        }

        public void setVolumeRatio(Float volumeRatio) {
            this.volumeRatio = volumeRatio;
        }

        public String getEmotion() {
            return emotion;
        }

        public void setEmotion(String emotion) {
            this.emotion = emotion;
        }

        public static final class Builder {
            private String token;
            private String appId;
            private String cluster;
            private String voiceType;
            private Float speedRatio;
            private Float volumeRatio;
            private Float pitchRatio;
            private String emotion;

            private Builder() {
            }

            public Builder token(String val) {
                token = val;
                return this;
            }

            public Builder appId(String val) {
                appId = val;
                return this;
            }

            public Builder cluster(String val) {
                cluster = val;
                return this;
            }

            public Builder voiceType(String val) {
                voiceType = val;
                return this;
            }

            public Builder speedRatio(Float val) {
                speedRatio = val;
                return this;
            }

            public Builder volumeRatio(Float val) {
                volumeRatio = val;
                return this;
            }

            public Builder pitchRatio(Float val) {
                pitchRatio = val;
                return this;
            }

            public Builder emotion(String val) {
                emotion = val;
                return this;
            }

            public BytedanceTTSVendorParams build() {
                return new BytedanceTTSVendorParams(this);
            }
        }
    }

    /**
     * @brief Defines the Microsoft vendor parameters for the Text-to-Speech (TTS) module when the agent joins the RTC channel, see
     * @since v0.3.0
     */
    public static class MicrosoftTTSVendorParams implements TTSVendorParams {

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

        public static Builder builder() {
            return new Builder();
        }

        private MicrosoftTTSVendorParams(Builder builder) {
            setKey(builder.key);
            setRegion(builder.region);
            setVoiceName(builder.voiceName);
            setRate(builder.rate);
            setVolume(builder.volume);
        }

        public Float getVolume() {
            return volume;
        }

        public void setVolume(Float volume) {
            this.volume = volume;
        }

        public Float getRate() {
            return rate;
        }

        public void setRate(Float rate) {
            this.rate = rate;
        }

        public String getVoiceName() {
            return voiceName;
        }

        public void setVoiceName(String voiceName) {
            this.voiceName = voiceName;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public static final class Builder {
            private String key;
            private String region;
            private String voiceName;
            private Float rate;
            private Float volume;

            private Builder() {
            }

            public Builder key(String val) {
                key = val;
                return this;
            }

            public Builder region(String val) {
                region = val;
                return this;
            }

            public Builder voiceName(String val) {
                voiceName = val;
                return this;
            }

            public Builder rate(Float val) {
                rate = val;
                return this;
            }

            public Builder volume(Float val) {
                volume = val;
                return this;
            }

            public MicrosoftTTSVendorParams build() {
                return new MicrosoftTTSVendorParams(this);
            }
        }
    }

    /**
     * @brief Defines the ElevenLabs vendor parameters for the Text-to-Speech (TTS) module when the agent joins the RTC channel, see
     * @since v0.3.0
     */
    public static class ElevenLabsTTSVendorParams implements TTSVendorParams {

        @JsonProperty("api_key")
        private String apiKey;

        @JsonProperty("model_id")
        private String modelId;

        @JsonProperty("voice_id")
        private String voiceId;

        public static Builder builder() {
            return new Builder();
        }

        private ElevenLabsTTSVendorParams(Builder builder) {
            setApiKey(builder.apiKey);
            setModelId(builder.modelId);
            setVoiceId(builder.voiceId);
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public String getModelId() {
            return modelId;
        }

        public void setModelId(String modelId) {
            this.modelId = modelId;
        }

        public String getVoiceId() {
            return voiceId;
        }

        public void setVoiceId(String voiceId) {
            this.voiceId = voiceId;
        }

        public static final class Builder {
            private String apiKey;
            private String modelId;
            private String voiceId;

            private Builder() {
            }

            public Builder apiKey(String val) {
                apiKey = val;
                return this;
            }

            public Builder modelId(String val) {
                modelId = val;
                return this;
            }

            public Builder voiceId(String val) {
                voiceId = val;
                return this;
            }

            public ElevenLabsTTSVendorParams build() {
                return new ElevenLabsTTSVendorParams(this);
            }
        }
    }

    /**
     * @brief Defines the Voice Activity Detection (VAD) configuration for the agent to join the RTC channel.
     * @since v0.3.0
     */
    public static class Vad {

        /**
         * Human voice duration threshold (ms), range [120, 1200] (optional)
         * <p>
         * Minimum duration of continuous human voice signal to avoid false interruptions.
         */
        @JsonProperty("interrupt_duration_ms")
        private Integer interruptDurationMs;

        /**
         * Prefix padding threshold (ms), range [0, 5000] (optional)
         * <p>
         * Minimum duration of continuous voice required to start a new voice segment, avoiding very short sounds triggering voice activity detection
         */
        @JsonProperty("prefix_padding_ms")
        private Integer prefixPaddingMs;

        /**
         * Silence duration threshold (ms), range [0, 2000] (optional)
         * <p>
         * Minimum duration of silence at the end of speech to ensure short pauses do not prematurely end the speech segment.
         */
        @JsonProperty("silence_duration_ms")
        private Integer silenceDurationMs;

        /**
         * Voice recognition sensitivity, range (0.0,1.0) (optional)
         * <p>
         * Determines the level of sound in the audio signal considered as "voice activity".
         * <p>
         * Lower values make it easier for the agent to detect voice, while higher values may ignore faint sounds.
         */
        @JsonProperty("threshold")
        private Float threshold;

        public static Builder builder() {
            return new Builder();
        }

        private Vad(Builder builder) {
            setInterruptDurationMs(builder.interruptDurationMs);
            setPrefixPaddingMs(builder.prefixPaddingMs);
            setSilenceDurationMs(builder.silenceDurationMs);
            setThreshold(builder.threshold);
        }

        public Integer getInterruptDurationMs() {
            return interruptDurationMs;
        }

        public void setInterruptDurationMs(Integer interruptDurationMs) {
            this.interruptDurationMs = interruptDurationMs;
        }

        public Integer getPrefixPaddingMs() {
            return prefixPaddingMs;
        }

        public void setPrefixPaddingMs(Integer prefixPaddingMs) {
            this.prefixPaddingMs = prefixPaddingMs;
        }

        public Integer getSilenceDurationMs() {
            return silenceDurationMs;
        }

        public void setSilenceDurationMs(Integer silenceDurationMs) {
            this.silenceDurationMs = silenceDurationMs;
        }

        public Float getThreshold() {
            return threshold;
        }

        public void setThreshold(Float threshold) {
            this.threshold = threshold;
        }

        public static final class Builder {
            private Integer interruptDurationMs;
            private Integer prefixPaddingMs;
            private Integer silenceDurationMs;
            private Float threshold;

            private Builder() {
            }

            public Builder interruptDurationMs(Integer val) {
                interruptDurationMs = val;
                return this;
            }

            public Builder prefixPaddingMs(Integer val) {
                prefixPaddingMs = val;
                return this;
            }

            public Builder silenceDurationMs(Integer val) {
                silenceDurationMs = val;
                return this;
            }

            public Builder threshold(Float val) {
                threshold = val;
                return this;
            }

            public Vad build() {
                return new Vad(this);
            }
        }
    }

    /**
     * @brief Defines the Automatic Speech Recognition (ASR) configuration for the agent to join the RTC channel.
     * @since v0.3.0
     */
    public static class Asr {

        /**
         * Language used for interaction between user and agent (optional)
         * <p>
         * - zh-CN: Chinese (supports mixed Chinese and English) (default)
         * <p>
         * - en-US: English
         */
        @JsonProperty("language")
        private String language;

        public static Builder builder() {
            return new Builder();
        }

        private Asr(Builder builder) {
            setLanguage(builder.language);
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public static final class Builder {
            private String language;

            private Builder() {
            }

            public Builder language(String val) {
                language = val;
                return this;
            }

            public Asr build() {
                return new Asr(this);
            }
        }
    }

    public static final class Builder {
        private String name;
        private Properties properties;

        private Builder() {
        }


        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder properties(Properties val) {
            properties = val;
            return this;
        }

        public JoinConvoAIReq build() {
            return new JoinConvoAIReq(this);
        }
    }
}
