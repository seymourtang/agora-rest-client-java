package io.agora.rest.services.convoai.req;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @brief Request Body parameters for calling the Conversational AI engine join
 *        API
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
         * Token used to join the RTC channel, i.e., the dynamic key for authentication
         * (optional).
         * <p>
         * If your project has enabled the App Certificate, you must pass the dynamic
         * key in this field.
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
         * Filling "0" means a random assignment, but the Token needs to be modified
         * accordingly
         * <p>
         */
        @JsonProperty("agent_rtc_uid")
        private String agentRtcUId;

        /**
         * List of user IDs that the agent subscribes to in the RTC channel, only
         * subscribed users can interact with the agent (required)
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
         * - false: Do not enable String UID (default)
         */
        @JsonProperty("enable_string_uid")
        private Boolean enableStringUId;

        /**
         * Maximum idle time of the RTC channel (s) (optional)
         * <p>
         * The time after all users specified in remote_rtc_uids leave the channel is
         * considered idle time.
         * <p>
         * If it exceeds the set maximum value, the agent will automatically stop and
         * exit the channel.
         * <p>
         * If set to 0, the agent will only stop when manually exited.
         * <p>
         */
        @JsonProperty("idle_timeout")
        private Integer idleTimeout;

        /**
         * Agent user ID in the RTM channel
         * <p>
         * Only valid when advanced_features.enable_rtm is true.
         * <p>
         * 
         * @deprecated This field is deprecated since v0.6.0, use agent_rtc_uid instead.
         */
        @Deprecated
        @JsonProperty("agent_rtm_uid")
        private String agentRtmUId;

        /**
         * Advanced feature configurations (optional), see {@link AdvancedFeatures} for
         * details
         */
        @JsonProperty("advanced_features")
        private AdvancedFeatures advancedFeatures;

        /**
         * Custom language model (LLM) configuration (required), see {@link LLMPayload}
         * for details
         */
        @JsonProperty("llm")
        private LLMPayload llmPayload;

        /**
         * Text-to-Speech (TTS) module configuration (optional), see {@link TTSPayload}
         * for details
         */
        @JsonProperty("tts")
        private TTSPayload ttsPayload;

        /**
         * Voice Activity Detection (VAD) configuration (optional), see
         * {@link VADPayload} for details
         */
        @JsonProperty("vad")
        private VADPayload vadPayload;

        /**
         * Automatic Speech Recognition (ASR) configuration (optional), see
         * {@link ASRPayload} for details
         */
        @JsonProperty("asr")
        private ASRPayload asrPayload;

        /**
         * Turn detection configuration (optional), see {@link TurnDetectionPayload} for
         * details
         */
        @JsonProperty("turn_detection")
        private TurnDetectionPayload turnDetectionPayload;

        @JsonProperty("parameters")
        private Parameters parameters;

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
            setLlm(builder.llmPayload);
            setTts(builder.ttsPayload);
            setVad(builder.vadPayload);
            setAsr(builder.asrPayload);
            setTurnDetectionPayload(builder.turnDetectionPayload);
            setParameters(builder.parameters);
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

        public LLMPayload getLlm() {
            return llmPayload;
        }

        public void setLlm(LLMPayload llmPayload) {
            this.llmPayload = llmPayload;
        }

        public TTSPayload getTts() {
            return ttsPayload;
        }

        public void setTts(TTSPayload ttsPayload) {
            this.ttsPayload = ttsPayload;
        }

        public VADPayload getVad() {
            return vadPayload;
        }

        public void setVad(VADPayload VADPayload) {
            this.vadPayload = VADPayload;
        }

        public ASRPayload getAsr() {
            return asrPayload;
        }

        public void setAsr(ASRPayload ASRPayload) {
            this.asrPayload = ASRPayload;
        }

        public Parameters getParameters() {
            return parameters;
        }

        public void setParameters(Parameters parameters) {
            this.parameters = parameters;
        }

        public TurnDetectionPayload getTurnDetectionPayload() {
            return turnDetectionPayload;
        }

        public void setTurnDetectionPayload(TurnDetectionPayload turnDetectionPayload) {
            this.turnDetectionPayload = turnDetectionPayload;
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
            private LLMPayload llmPayload;
            private TTSPayload ttsPayload;
            private VADPayload vadPayload;
            private ASRPayload asrPayload;
            private Parameters parameters;
            private TurnDetectionPayload turnDetectionPayload;

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

            @Deprecated
            public Builder agentRtmUId(String val) {
                agentRtmUId = val;
                return this;
            }

            public Builder advancedFeatures(AdvancedFeatures val) {
                advancedFeatures = val;
                return this;
            }

            public Builder llmPayload(LLMPayload val) {
                llmPayload = val;
                return this;
            }

            public Builder ttsPayload(TTSPayload val) {
                ttsPayload = val;
                return this;
            }

            public Builder vadPayload(VADPayload val) {
                vadPayload = val;
                return this;
            }

            public Builder asrPayload(ASRPayload val) {
                asrPayload = val;
                return this;
            }

            public Builder turnDetectionPayload(TurnDetectionPayload val) {
                turnDetectionPayload = val;
                return this;
            }

            public Builder parameters(Parameters val) {
                parameters = val;
                return this;
            }

            public Properties build() {
                return new Properties(this);
            }
        }
    }

    /**
     * @brief Defines advanced feature configuration for the agent to join RTC
     *        channel
     * @since v0.3.0
     */
    public static class AdvancedFeatures {

        /**
         * Whether to enable graceful interruption feature (AIVAD) (optional)
         * <p>
         * - true: Enable
         * <p>
         * - false: Do not enable (default)
         * <p>
         * When enabled, users can interrupt the AI at any time and respond quickly,
         * achieving natural transitions and smooth conversations.
         */
        @JsonProperty("enable_aivad")
        private Boolean enableAIVad;

        /**
         * Whether to enable the Real-time Messaging (RTM) module (optional)
         * <p>
         * - true: Enable
         * <p>
         * - false: Do not enable (default)
         * <p>
         * When enabled, the agent can use the capabilities provided by RTM to implement
         * some advanced features.
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
     * @brief Defines the custom language model (LLM) configuration for the agent to
     *        join the RTC channel
     * @since v0.3.0
     */
    public static class LLMPayload {

        /**
         * LLM callback URL (required)
         * <p>
         * Must be compatible with OpenAI protocol
         */
        @JsonProperty("url")
        private String url;

        /**
         * LLM verification API key (required)
         * <p>
         * Default is empty, API key must be enabled in production environment
         */
        @JsonProperty("api_key")
        private String apiKey;

        /**
         * A set of predefined information attached at the beginning of each LLM call,
         * used to control LLM output (optional)
         * <p>
         * Can be role settings, prompts, and answer examples, must be compatible with
         * OpenAI protocol
         */
        @JsonProperty("system_messages")
        private List<Map<String, Object>> systemMessages;

        /**
         * Additional information transmitted in the LLM message body, such as the model
         * used, maximum token limit, etc. (optional)
         * <p>
         * Different LLM providers support different configurations, see their
         * respective LLM documentation for details.
         */
        @JsonProperty("params")
        private HashMap<String, Object> params;

        /**
         * Number of short-term memory entries cached in LLM (optional)
         * <p>
         * Default value is 10
         * <p>
         * Passing 0 means no short-term memory is cached. agent and subscribed users
         * will record entries separately.
         */
        @JsonProperty("max_history")
        private Integer maxHistory;

        /**
         * Agent greeting message (optional)
         * <p>
         * If filled, the agent will automatically send a greeting message to the first
         * subscribed user who joins the channel when there are no users in the
         * remote_rtc_uids list.
         */
        @JsonProperty("greeting_message")
        private String greetingMessage;

        /**
         * Input modalities of the LLM (optional)
         * <p>
         * - ["text"]: Text only (default)
         * <p>
         * - ["text", "image"]: Text and image, requires the selected LLM to support
         * visual modality input
         */
        @JsonProperty("input_modalities")
        private List<String> inputModalities;

        /**
         * Output modalities of the LLM (optional)
         * <p>
         * - ["text"]: Text only (default), the output text will be converted to speech
         * by the TTS module and then published to the RTC channel.
         * <p>
         * - ["audio"]: Audio only. The audio will be directly published to the RTC
         * channel.
         * <p>
         * - ["text", "audio"]: Text and audio. You can write your own logic to handle
         * the LLM output as needed.
         */
        @JsonProperty("output_modalities")
        private List<String> outputModalities;

        /**
         * Failure message of the agent (optional)
         * <p>
         * If filled, it will be returned through the TTS module when the LLM call
         * fails.
         */
        @JsonProperty("failure_message")
        private String failureMessage;

        /**
         * LLM provider(Optional), supports the following settings:
         * <p>
         * - "custom": Custom LLM provider.
         * <p>
         * When you set this option, the agent includes the following fields, in
         * addition
         * to role and content when making requests to the custom LLM.
         * <p>
         * - turn_id: A unique identifier for each conversation turn. It starts from 0
         * and increments with each turn. One user-agent interaction corresponds to
         * one turn_id.
         * <p>
         * - timestamp: The request timestamp, in milliseconds.
         * <p>
         * - "aliyun": Aliyun LLM provider.(Only available in China Mainland service
         * region)
         * <p>
         * - "bytedance": Bytedance LLM provider.(Only available in China Mainland
         * service region)
         * <p>
         * - "deepseek": DeepSeek LLM provider.(Only available in China Mainland service
         * region)
         * <p>
         * - "tencent": Tencent LLM provider.(Only available in China Mainland service
         * region)
         * 
         * @since v0.6.0
         */
        @JsonProperty("vendor")
        private String vendor;

        /**
         * The request style for chat completion.(Optional)(Only available in global
         * service region)
         * <p>
         * - "openai": OpenAI style.(Default)
         * <p>
         * - "gemini": Gemini style.
         * <p>
         * - "anthropic": Anthropic style.
         *
         * @since v0.6.0
         */
        @JsonProperty("style")
        private String style;

        public static Builder builder() {
            return new Builder();
        }

        private LLMPayload(Builder builder) {
            setUrl(builder.url);
            setApiKey(builder.apiKey);
            setSystemMessages(builder.systemMessages);
            setParams(builder.params);
            setMaxHistory(builder.maxHistory);
            setGreetingMessage(builder.greetingMessage);
            setInputModalities(builder.inputModalities);
            setOutputModalities(builder.outputModalities);
            setFailureMessage(builder.failureMessage);
            setVendor(builder.vendor);
            setStyle(builder.style);
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

        public String getVendor() {
            return this.vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public String getStyle() {
            return this.style;
        }

        public void setStyle(String style) {
            this.style = style;
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
            private String vendor;
            private String style;

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

            public Builder vendor(String val) {
                vendor = val;
                return this;
            }

            public Builder style(String val) {
                style = val;
                return this;
            }

            public LLMPayload build() {
                return new LLMPayload(this);
            }
        }
    }

    public interface TTSVendorParams {
    }

    /**
     * @brief Defines the Text-to-Speech (TTS) module configuration for the agent to
     *        join the RTC channel
     * @since v0.3.0
     */
    public static class TTSPayload {

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

        /**
         * Controls whether the TTS module skips bracketed content when reading LLM
         * response text.
         * <p>
         * This prevents the agent from vocalizing structural prompt information like
         * tone indicators,
         * action descriptions, and system prompts, creating a more natural and
         * immersive listening experience.
         * <p>
         * Enable this feature by specifying one or more values:
         * <p>
         * 1: Skip content in Chinese parentheses （ ）
         * <p>
         * 2: Skip content in Chinese square brackets 【】
         * <p>
         * 3: Skip content in parentheses ()
         * <p>
         * 4: Skip content in square brackets [ ]
         * <p>
         * 5: Skip content in curly braces { }
         */
        @JsonProperty("skipPatterns")
        private List<Integer> skipPatterns;

        public static Builder builder() {
            return new Builder();
        }

        private TTSPayload(Builder builder) {
            setVendor(builder.vendor);
            setParams(builder.params);
            setSkipPatterns(builder.skipPatterns);
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

        public List<Integer> getSkipPatterns() {
            return skipPatterns;
        }

        public void setSkipPatterns(List<Integer> skipPatterns) {
            this.skipPatterns = skipPatterns;
        }

        public static final class Builder {
            private TTSVendorEnum vendor;
            private TTSVendorParams params;
            private List<Integer> skipPatterns;

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

            public Builder skipPatterns(List<Integer> val) {
                skipPatterns = val;
                return this;
            }

            public TTSPayload build() {
                return new TTSPayload(this);
            }
        }
    }

    /**
     * @brief Defines TTS module vendor enumeration for agent to join RTC channel
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

        // Elevenlabs TTS vendor
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
     * @brief Define Minimax TTS module parameters, see
     *        <a href="https://platform.minimaxi.com/document/T2A%20V2">Minimax</a>
     * @since v0.3.0
     */
    public static class MinimaxTTSVendorParams implements TTSVendorParams {

        /**
         * Group ID
         */
        @JsonProperty("group_id")
        private String groupId;

        /**
         * API key
         */
        @JsonProperty("key")
        private String key;

        /**
         * Model
         */
        @JsonProperty("model")
        private String model;

        /**
         * Audio setting
         */
        @JsonProperty("audio_setting")
        private MinimaxTTSVendorAudioSettingParam audioSetting;

        /**
         * Voice setting
         */
        @JsonProperty("voice_setting")
        private MinimaxTTSVendorVoiceSettingParam voiceSetting;

        /**
         * Pronunciation dictionary
         * 
         * @since v0.6.0
         */
        @JsonProperty("pronunciation_dict")
        private PronunciationDictParam pronunciationDict;

        /**
         * Timber weight
         * 
         * @since v0.6.0
         */
        @JsonProperty("timber_weights")
        private List<MinimaxTTSVendorTimberWeightParam> timberWeights;

        /**
         * Language boost
         * 
         * @since v0.6.0
         */
        @JsonProperty("language_boost")
        private String languageBoost;

        public static Builder builder() {
            return new Builder();
        }

        private MinimaxTTSVendorParams(Builder builder) {
            setGroupId(builder.groupId);
            setKey(builder.key);
            setModel(builder.model);
            setAudioSetting(builder.audioSetting);
            setVoiceSetting(builder.voiceSetting);
            setPronunciationDict(builder.pronunciationDict);
            setTimberWeights(builder.timberWeights);
            setLanguageBoost(builder.languageBoost);
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

        public List<MinimaxTTSVendorTimberWeightParam> getTimberWeights() {
            return timberWeights;
        }

        public void setTimberWeights(List<MinimaxTTSVendorTimberWeightParam> timberWeights) {
            this.timberWeights = timberWeights;
        }

        public String getLanguageBoost() {
            return languageBoost;
        }

        public void setLanguageBoost(String languageBoost) {
            this.languageBoost = languageBoost;
        }

        public PronunciationDictParam getPronunciationDict() {
            return pronunciationDict;
        }

        public void setPronunciationDict(PronunciationDictParam pronunciationDict) {
            this.pronunciationDict = pronunciationDict;
        }

        public static final class Builder {

            private String groupId;

            private String key;

            private String model;

            private MinimaxTTSVendorAudioSettingParam audioSetting;

            private MinimaxTTSVendorVoiceSettingParam voiceSetting;

            private List<MinimaxTTSVendorTimberWeightParam> timberWeights;

            private PronunciationDictParam pronunciationDict;

            private String languageBoost;

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

            public Builder timberWeights(List<MinimaxTTSVendorTimberWeightParam> timberWeights) {
                this.timberWeights = timberWeights;
                return this;
            }

            public Builder pronunciationDict(PronunciationDictParam pronunciationDict) {
                this.pronunciationDict = pronunciationDict;
                return this;
            }

            public Builder languageBoost(String languageBoost) {
                this.languageBoost = languageBoost;
                return this;
            }

            public MinimaxTTSVendorParams build() {
                return new MinimaxTTSVendorParams(this);
            }
        }
    }

    /**
     * @brief Defines Minimax vendor audio setting parameters
     * @since v0.3.0
     */
    public static class MinimaxTTSVendorAudioSettingParam {

        /**
         * Sample rate
         */
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

    /**
     * @brief Defines Minimax vendor voice setting parameters
     * @since v0.3.0
     */
    public static class MinimaxTTSVendorVoiceSettingParam {

        /**
         * Voice ID
         */
        @JsonProperty("voice_id")
        private String voiceId;

        /**
         * Speed of speech
         */
        @JsonProperty("speed")
        private Float speed;

        /**
         * Volume
         */
        @JsonProperty("vol")
        private Float vol;

        /**
         * Pitch
         */
        @JsonProperty("pitch")
        private Integer pitch;

        /**
         * Emotion
         */
        @JsonProperty("emotion")
        private String emotion;

        /**
         * Whether to read the latex content
         * 
         * @since v0.6.0
         */
        @JsonProperty("latex_read")
        private Boolean latexRead;

        /**
         * Whether to normalize the english content
         * 
         * @since v0.6.0
         */
        @JsonProperty("english_normalization")
        private Boolean englishNormalization;

        public static Builder builder() {
            return new Builder();
        }

        private MinimaxTTSVendorVoiceSettingParam(Builder builder) {
            setVoiceId(builder.voiceId);
            setSpeed(builder.speed);
            setVol(builder.vol);
            setPitch(builder.pitch);
            setEmotion(builder.emotion);
            setLatexRead(builder.latexRead);
            setEnglishNormalization(builder.englishNormalization);
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

        public Boolean getLatexRead() {
            return latexRead;
        }

        public void setLatexRead(Boolean latexRead) {
            this.latexRead = latexRead;
        }

        public Boolean getEnglishNormalization() {
            return englishNormalization;
        }

        public void setEnglishNormalization(Boolean englishNormalization) {
            this.englishNormalization = englishNormalization;
        }

        public static final class Builder {
            private String voiceId;
            private Float speed;
            private Float vol;
            private Integer pitch;
            private String emotion;
            private Boolean latexRead;
            private Boolean englishNormalization;

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

            public Builder latexRead(Boolean val) {
                latexRead = val;
                return this;
            }

            public Builder englishNormalization(Boolean val) {
                englishNormalization = val;
                return this;
            }

            public MinimaxTTSVendorVoiceSettingParam build() {
                return new MinimaxTTSVendorVoiceSettingParam(this);
            }
        }
    }

    /**
     * @brief Define Minimax TTS vendor pronunciation dictionary parameter
     * @since v0.6.0
     */
    public static class PronunciationDictParam {

        @JsonProperty("tones")
        private List<String> tones;

        public static Builder builder() {
            return new Builder();
        }

        private PronunciationDictParam(Builder builder) {
            setTones(builder.tones);
        }

        public List<String> getTones() {
            return tones;
        }

        public void setTones(List<String> tones) {
            this.tones = tones;
        }

        public static final class Builder {
            private List<String> tones;

            private Builder() {
            }

            public Builder tones(List<String> tones) {
                this.tones = tones;
                return this;
            }

            public PronunciationDictParam build() {
                return new PronunciationDictParam(this);
            }
        }
    }

    /**
     * @brief Define Minimax TTS vendor timber weight parameter
     * @since v0.6.0
     */
    public static class MinimaxTTSVendorTimberWeightParam {

        @JsonProperty("voice_id")
        private String voiceId;

        @JsonProperty("weight")
        private Float weight;

        public static Builder builder() {
            return new Builder();
        }

        private MinimaxTTSVendorTimberWeightParam(Builder builder) {
            setVoiceId(builder.voiceId);
            setWeight(builder.weight);
        }

        public String getVoiceId() {
            return voiceId;
        }

        public void setVoiceId(String voiceId) {
            this.voiceId = voiceId;
        }

        public Float getWeight() {
            return weight;
        }

        public void setWeight(Float weight) {
            this.weight = weight;
        }

        public static final class Builder {
            private String voiceId;
            private Float weight;

            private Builder() {
            }

            public Builder voiceId(String val) {
                voiceId = val;
                return this;
            }

            public Builder weight(Float val) {
                weight = val;
                return this;
            }

            public MinimaxTTSVendorTimberWeightParam build() {
                return new MinimaxTTSVendorTimberWeightParam(this);
            }
        }
    }

    /**
     * @brief Define Tencent TTS module parameters, see
     *        <a href=
     *        "https://cloud.tencent.com/document/product/1073/94308">Tencent</a>
     * @since v0.3.0
     */
    public static class TencentTTSVendorParams implements TTSVendorParams {

        /**
         * Tencent Cloud TTS App ID
         */
        @JsonProperty("app_id")
        private String appId;

        /**
         * Tencent Cloud TTS Secret ID
         */
        @JsonProperty("secret_id")
        private String secretId;

        /**
         * Tencent Cloud TTS Secret Key
         */
        @JsonProperty("secret_key")
        private String secretKey;

        /**
         * Voice type
         */
        @JsonProperty("voice_type")
        private Integer voiceType;

        /**
         * Volume
         */
        @JsonProperty("volume")
        private Integer volume;

        /**
         * Speed of speech
         */
        @JsonProperty("speed")
        private Integer speed;

        /**
         * Emotion category
         */
        @JsonProperty("emotion_category")
        private String emotionCategory;

        /**
         * Emotion intensity
         */
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
     * @brief Define Bytedance TTS module parameters, see
     *        <a href="https://www.volcengine.com/docs/6561/79823">Bytedance</a>
     * @since v0.3.0
     */
    public static class BytedanceTTSVendorParams implements TTSVendorParams {

        /**
         * Bytedance TTS token
         */
        @JsonProperty("token")
        private String token;

        /**
         * Bytedance TTS App ID
         */
        @JsonProperty("app_id")
        private String appId;

        /**
         * Bytedance TTS cluster
         */
        @JsonProperty("cluster")
        private String cluster;

        /**
         * Voice type
         */
        @JsonProperty("voice_type")
        private String voiceType;

        /**
         * Speed of speech
         */
        @JsonProperty("speed_ratio")
        private Float speedRatio;

        /**
         * Volume
         */
        @JsonProperty("volume_ratio")
        private Float volumeRatio;

        /**
         * Pitch
         */
        @JsonProperty("pitch_ratio")
        private Float pitchRatio;

        /**
         * Emotion
         */
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
     * @brief Define Microsoft TTS vendor parameters, see
     * @since v0.6.0
     */
    public static class MicrosoftTTSVendorParams implements TTSVendorParams {

        @JsonProperty("key")
        private String key;

        @JsonProperty("region")
        private String region;

        @JsonProperty("voice_name")
        private String voiceName;

        @JsonProperty("speed")
        private Float speed;

        @JsonProperty("volume")
        private Float volume;

        @JsonProperty("sample_rate")
        private Integer sampleRate;

        public static Builder builder() {
            return new Builder();
        }

        private MicrosoftTTSVendorParams(Builder builder) {
            setKey(builder.key);
            setRegion(builder.region);
            setVoiceName(builder.voiceName);
            setSpeed(builder.speed);
            setVolume(builder.volume);
            setSampleRate(builder.sampleRate);
        }

        public Float getVolume() {
            return volume;
        }

        public void setVolume(Float volume) {
            this.volume = volume;
        }

        public Float getSpeed() {
            return speed;
        }

        public void setSpeed(Float speed) {
            this.speed = speed;
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

        public Integer getSampleRate() {
            return sampleRate;
        }

        public void setSampleRate(Integer sampleRate) {
            this.sampleRate = sampleRate;
        }

        public static final class Builder {
            private String key;
            private String region;
            private String voiceName;
            private Float speed;
            private Float volume;
            private Integer sampleRate;

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

            public Builder speed(Float val) {
                speed = val;
                return this;
            }

            public Builder volume(Float val) {
                volume = val;
                return this;
            }

            public Builder sampleRate(Integer val) {
                sampleRate = val;
                return this;
            }

            public MicrosoftTTSVendorParams build() {
                return new MicrosoftTTSVendorParams(this);
            }
        }
    }

    /**
     * @brief Define ElevenLabs TTS vendor parameters, see
     * @since v0.6.0
     */
    public static class ElevenLabsTTSVendorParams implements TTSVendorParams {

        @JsonProperty("key")
        private String key;

        @JsonProperty("model_id")
        private String modelId;

        @JsonProperty("voice_id")
        private String voiceId;

        @JsonProperty("sample_rate")
        private Integer sampleRate;

        @JsonProperty("stability")
        private Float stability;

        @JsonProperty("similarity_boost")
        private Float similarityBoost;

        @JsonProperty("style")
        private Float style;

        @JsonProperty("use_speaker_boost")
        private Boolean useSpeakerBoost;

        public static Builder builder() {
            return new Builder();
        }

        private ElevenLabsTTSVendorParams(Builder builder) {
            setKey(builder.key);
            setModelId(builder.modelId);
            setVoiceId(builder.voiceId);
            setSampleRate(builder.sampleRate);
            setStability(builder.stability);
            setSimilarityBoost(builder.similarityBoost);
            setStyle(builder.style);
            setUseSpeakerBoost(builder.useSpeakerBoost);
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
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

        public Integer getSampleRate() {
            return sampleRate;
        }

        public void setSampleRate(Integer sampleRate) {
            this.sampleRate = sampleRate;
        }

        public Float getStability() {
            return stability;
        }

        public void setStability(Float stability) {
            this.stability = stability;
        }

        public Float getSimilarityBoost() {
            return similarityBoost;
        }

        public void setSimilarityBoost(Float similarityBoost) {
            this.similarityBoost = similarityBoost;
        }

        public Float getStyle() {
            return style;
        }

        public void setStyle(Float style) {
            this.style = style;
        }

        public Boolean getUseSpeakerBoost() {
            return useSpeakerBoost;
        }

        public void setUseSpeakerBoost(Boolean useSpeakerBoost) {
            this.useSpeakerBoost = useSpeakerBoost;
        }

        public static final class Builder {
            private String key;
            private String modelId;
            private String voiceId;
            private Integer sampleRate;
            private Float stability;
            private Float similarityBoost;
            private Float style;
            private Boolean useSpeakerBoost;

            private Builder() {
            }

            public Builder key(String val) {
                key = val;
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

            public Builder sampleRate(Integer val) {
                sampleRate = val;
                return this;
            }

            public Builder stability(Float val) {
                stability = val;
                return this;
            }

            public Builder similarityBoost(Float val) {
                similarityBoost = val;
                return this;
            }

            public Builder style(Float val) {
                style = val;
                return this;
            }

            public Builder useSpeakerBoost(Boolean val) {
                useSpeakerBoost = val;
                return this;
            }

            public ElevenLabsTTSVendorParams build() {
                return new ElevenLabsTTSVendorParams(this);
            }
        }
    }

    /**
     * @brief Defines the Voice Activity Detection (VAD) configuration for the agent
     *        to join the RTC channel
     * @since v0.3.0
     */
    public static class VADPayload {

        /**
         * Human voice duration threshold (ms), range [120, 1200] (optional)
         * <p>
         * Minimum duration of continuous human voice signal to avoid false
         * interruptions.
         */
        @JsonProperty("interrupt_duration_ms")
        private Integer interruptDurationMs;

        /**
         * Prefix padding threshold (ms), range [0, 5000] (optional)
         * <p>
         * Minimum duration of voice required to start a new speech segment to avoid
         * triggering voice activity detection with very short sounds.
         */
        @JsonProperty("prefix_padding_ms")
        private Integer prefixPaddingMs;

        /**
         * Silence duration threshold (ms), range [0, 2000] (optional)
         * <p>
         * Minimum duration of silence at the end of speech to ensure short pauses do
         * not prematurely end the speech segment.
         */
        @JsonProperty("silence_duration_ms")
        private Integer silenceDurationMs;

        /**
         * Voice recognition sensitivity, range (0.0,1.0) (optional)
         * <p>
         * Determines the level of sound in the audio signal considered as "voice
         * activity".
         * <p>
         * Lower values make it easier for the agent to detect voice, while higher
         * values may ignore faint sounds.
         */
        @JsonProperty("threshold")
        private Float threshold;

        public static Builder builder() {
            return new Builder();
        }

        private VADPayload(Builder builder) {
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

            public VADPayload build() {
                return new VADPayload(this);
            }
        }
    }

    /**
     * @brief Defines the Automatic Speech Recognition (ASR) configuration for agent
     *        to join RTC channel
     * @since v0.3.0
     */
    public static class ASRPayload {

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

        private ASRPayload(Builder builder) {
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

            public ASRPayload build() {
                return new ASRPayload(this);
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

    /**
     * @brief Defines the turn detection configuration for agent
     * @since v0.6.0
     */
    public static class TurnDetectionPayload {

        public String getInterruptMode() {
            return interruptMode;
        }

        public void setInterruptMode(String interruptMode) {
            this.interruptMode = interruptMode;
        }

        /**
         * When the agent is interacting (speaking or thinking), the mode of human voice
         * interrupting the agent's behavior, support the following values:
         * <p>
         * - "interrupt"(Default): Interrupt mode, human voice immediately interrupts
         * the agent's interaction.
         * <p>
         * The agent will terminate the current interaction and directly process the
         * human voice input.
         * <p>
         * - "append": Append mode, human voice does not interrupt the agent. (Default)
         * <p>
         * The agent will process the human voice request after the current interaction
         * ends.
         * <p>
         * - "ignore": Ignore mode, the agent ignores the human voice request.
         * <p>
         * If the agent is speaking or thinking and receives human voice during the
         * process,
         * the agent will directly ignore and discard the human voice request, not
         * storing it in the context.
         * 
         * @since v0.6.0
         */
        @JsonProperty("interrupt_mode")
        private String interruptMode;

        public static TurnDetectionPayload.Builder builder() {
            return new TurnDetectionPayload.Builder();
        }

        private TurnDetectionPayload(Builder builder) {
            setInterruptMode(builder.interruptMode);
        }

        public static final class Builder {
            private String interruptMode;

            private Builder() {
            }

            public Builder interruptMode(String val) {
                interruptMode = val;
                return this;
            }

            public TurnDetectionPayload build() {
                return new TurnDetectionPayload(this);
            }
        }

    }

    /**
     * @brief Defines the parameters for the agent,the same key in the fixedParams
     *        and extraParams will be merged
     * @since v0.6.0
     */
    public static class Parameters {

        /**
         * Fixed parameters for the agent
         */
        @JsonIgnore
        private FixedParams fixedParams;

        /**
         * Extra parameters for the agent
         */
        @JsonIgnore
        private Map<String, Object> extraParams = new HashMap<>();

        public FixedParams getFixedParams() {
            return fixedParams;
        }

        public Map<String, Object> getExtraParams() {
            return extraParams;
        }

        @JsonAnyGetter
        public Map<String, Object> getParameters() throws IllegalArgumentException {
            Map<String, Object> merged = new HashMap<>();

            if (fixedParams != null) {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    Map<String, Object> fixedParamsMap = objectMapper.convertValue(fixedParams, Map.class);
                    merged.putAll(fixedParamsMap);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Failed to convert fixed params to map", e);
                }
            }

            if (extraParams != null) {
                merged.putAll(extraParams);
            }
            return merged;
        }

        private void setFixedParams(FixedParams fixedParams) {
            this.fixedParams = fixedParams;
        }

        private void setExtraParams(Map<String, Object> extraParams) {
            this.extraParams = extraParams;
        }

        public static Builder builder() {
            return new Builder();
        }

        private Parameters(Builder builder) {
            setFixedParams(builder.fixedParams);
            setExtraParams(builder.extraParams);
        }

        public static final class Builder {
            private FixedParams fixedParams;
            private Map<String, Object> extraParams;

            private Builder() {
            }

            public Builder fixedParams(FixedParams val) {
                fixedParams = val;
                return this;
            }

            public Builder extraParams(Map<String, Object> val) {
                extraParams = val;
                return this;
            }

            public Parameters build() {
                return new Parameters(this);
            }
        }
    }

    /**
     * @brief Defines the fixed parameters for the agent
     * @since v0.6.0
     */
    public static class FixedParams {

        @JsonProperty("silence_config")
        private SilenceConfig silenceConfig;

        public SilenceConfig getSilenceConfig() {
            return silenceConfig;
        }

        public void setSilenceConfig(SilenceConfig silenceConfig) {
            this.silenceConfig = silenceConfig;
        }

        public static Builder builder() {
            return new Builder();
        }

        private FixedParams(Builder builder) {
            setSilenceConfig(builder.silenceConfig);
        }

        public static final class Builder {
            private SilenceConfig silenceConfig;

            private Builder() {
            }

            public Builder silenceConfig(SilenceConfig val) {
                silenceConfig = val;
                return this;
            }

            public FixedParams build() {
                return new FixedParams(this);
            }
        }
    }

    /**
     * @brief Defines the silence config for the agent
     * @since v0.6.0
     */
    public static class SilenceConfig {

        /**
         * Agent maximum silence time (ms).(Optional)
         * <p>
         * After the agent is created and a user joins the channel,
         * the duration of the agent's non-listening, thinking, or speaking state is
         * called the agent's silence time.
         * <p>
         * When the silence time reaches the set value, the agent will report the
         * silence prompt message.
         * <p>
         * This feature can be used to let the agent remind users when users are
         * inactive.
         * <p>
         * Set 0: Do not enable this feature.
         * <p>
         * Set to (0,60000]: Must also set content to enable normal reporting of
         * silence prompts, otherwise the setting is invalid.
         */
        @JsonProperty("timeout_ms")
        private Integer timeoutMs;

        /**
         * When the silence time reaches the set value, the agent will take the
         * following actions(Optional):
         * <p>
         * - "speak": Use TTS module to report the silence message(Default)
         * <p>
         * - "think": Append the silence message to the end of the context and
         * pass it to LLM
         */
        @JsonProperty("action")
        private String action;

        /**
         * Content of the silence message (Optional)
         * <p>
         * The content will be used in different ways according to the settings in
         * the action.
         */
        @JsonProperty("content")
        private String content;

        public Integer getTimeoutMs() {
            return timeoutMs;
        }

        public String getAction() {
            return action;
        }

        public String getContent() {
            return content;
        }

        public void setTimeoutMs(Integer timeoutMs) {
            this.timeoutMs = timeoutMs;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public static Builder builder() {
            return new Builder();
        }

        private SilenceConfig(Builder builder) {
            setAction(builder.action);
            setContent(builder.content);
            setTimeoutMs(builder.timeoutMs);
        }

        public static final class Builder {
            private Integer timeoutMs;
            private String action;
            private String content;

            private Builder() {
            }

            public Builder timeoutMs(Integer val) {
                timeoutMs = val;
                return this;
            }

            public Builder action(String val) {
                action = val;
                return this;
            }

            public Builder content(String val) {
                content = val;
                return this;
            }

            public SilenceConfig build() {
                return new SilenceConfig(this);
            }
        }
    }
}
