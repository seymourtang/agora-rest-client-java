package io.agora.rest.services.convoai.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

/**
 * @brief Request parameters for AI agent to join RTC channel
 * @since 0.3.0
 */
public class JoinConvoAIReq {

    /**
     * Unique identifier for the AI agent, cannot be duplicated
     */
    @JsonProperty("name")
    private String name;

    /**
     * Configuration properties for the AI agent
     */
    @JsonProperty("properties")
    private Properties properties;

    /**
     * @brief Configuration properties for AI agent to join RTC channel
     * @since 0.3.0
     */
    public static class Properties {

        /**
         * Token used to join the RTC channel, i.e., the dynamic key for authentication (optional). If your project has enabled the App Certificate, you must pass the dynamic key in this field.
         */
        @JsonProperty("token")
        private String token;

        /**
         * Name of the RTC channel the AI agent joins (required)
         */
        @JsonProperty("channel")
        private String channel;

        /**
         * User ID of the AI agent in the RTC channel (required)
         *
         * @note When set to "0", it means a random ID is assigned, but the Token needs to be modified accordingly.
         */
        @JsonProperty("agent_rtc_uid")
        private String agentRtcUId;

        /**
         * List of user IDs that the AI agent subscribes to in the RTC channel, only subscribed users can interact with the AI agent (required)
         *
         * @note Passing "*" means subscribing to all users in the channel.
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
         *
         * @note The time after all users specified in remote\_rtc\_uids leave the channel is considered idle time. If it exceeds the set maximum value, the AI agent will automatically stop and exit the channel. If set to 0, the AI agent will only stop when manually exited.
         */
        @JsonProperty("idle_timeout")
        private Integer idleTimeout;

        /**
         * Advanced feature configuration (optional), see {@link AdvancedFeatures} for details
         */
        @JsonProperty("advanced_features")
        private AdvancedFeatures advancedFeatures;

        /**
         * Large Language Model (LLM) configuration (required), see {@link LLM} for details
         */
        @JsonProperty("llm")
        private LLM llm;

        /**
         * Text-to-Speech (TTS) configuration (optional), see {@link TTS} for details
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
    }

    /**
     * @brief Defines advanced feature configuration for AI agent to join RTC channel
     * @since 0.3.0
     */
    public static class AdvancedFeatures {

        /**
         * Whether to enable graceful interruption feature (AIVAD) (optional)
         * <p>
         * - true: Enable
         * <p>
         * - false: Do not enable (default)
         *
         * @note When enabled, users can interrupt the AI at any time and respond quickly, achieving natural transitions and smooth conversations.
         */
        @JsonProperty("enable_aivad")
        private Boolean enableAIVad;
    }

    /**
     * @brief Defines Large Language Model (LLM) configuration for AI agent to join RTC channel
     * @since 0.3.0
     */
    public static class LLM {

        /**
         * LLM callback URL (required)
         *
         * @note Must be compatible with OpenAI protocol
         */
        @JsonProperty("url")
        private String url;

        /**
         * LLM verification API key (required)
         *
         * @note Default is empty, API key must be enabled in production environment
         */
        @JsonProperty("api_key")
        private String apiKey;

        /**
         * A set of predefined information attached at the beginning of each LLM call, used to control LLM output (optional)
         *
         * @note Can be role settings, prompts, and answer examples, must be compatible with OpenAI protocol
         */
        @JsonProperty("system_messages")
        private String systemMessages;

        /**
         * Additional information transmitted in the LLM message body, such as the model used, maximum token limit, etc. (optional)
         * <p>
         * Different LLM providers support different configurations, see their respective LLM documentation for details.
         */
        @JsonProperty("params")
        private HashMap<String, Object> params;

        /**
         * Number of short-term memory entries cached in LLM (optional)
         * <p>
         * Default value is 10
         *
         * @note Passing 0 means no short-term memory is cached. AI agent and subscribed users will record entries separately.
         */
        @JsonProperty("max_history")
        private Integer maxHistory;

        /**
         * Greeting message of the AI agent (optional)
         *
         * @note If filled, the AI agent will automatically send a greeting message to the first subscribed user who joins the channel when there are no users in the remote\_rtc\_uids list.
         */
        @JsonProperty("greeting_message")
        private String greetingMessage;

        /**
         * Input modalities of the LLM (optional)
         * <p>
         * - ["text"]: Text only (default)
         * <p>
         * - ["text", "image"]: Text and image, requires the selected LLM to support visual modality input
         */
        @JsonProperty("input_modalities")
        private List<String> inputModalities;

        /**
         * Output modalities of the LLM (optional)
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
         * Failure message of the AI agent (optional)
         *
         * @note If filled, it will be returned through the TTS module when an LLM call error occurs.
         */
        @JsonProperty("failure_message")
        private String failureMessage;
    }

    public interface TTSVendorParams {
    }

    /**
     * Defines Text-to-Speech (TTS) configuration for AI agent to join RTC channel
     *
     * @since 0.3.0
     */
    public static class TTS {

        /**
         * TTS vendor, supports the following values:
         * See {@link TTSVendorEnum}
         */
        @JsonProperty("vendor")
        private String vendor;

        /**
         * TTS vendor parameter description, see
         * - {@link MinimaxTTSVendorParams}
         * <p>
         * - {@link TencentTTSVendorParams}
         * <p>
         * - {@link BytedanceTTSVendorParams}
         * <p>
         * - {@link MicrosoftTTSVendorParams}
         * <p>
         * - {@link ElevenlabsTTSVendorParams}
         */
        @JsonProperty("params")
        private TTSVendorParams params;
    }

    /**
     * Defines Text-to-Speech (TTS) vendor enumeration for AI agent to join RTC channel
     *
     * @since 0.3.0
     */
    public static enum TTSVendorEnum {

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

    /**
     * Defines Text-to-Speech (TTS) module Minimax vendor parameters for AI agent to join RTC channel, see
     * <a href="https://platform.minimaxi.com/document/T2A%20V2">Minimax</a>
     *
     * @since v0.7.0
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
    }

    public static class MinimaxTTSVendorAudioSettingParam {

        @JsonProperty("sample_rate")
        private Integer sampleRate;
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
    }

    /**
     * Defines Text-to-Speech (TTS) module Tencent vendor parameters for AI agent to join RTC channel, see
     * <a href="https://cloud.tencent.com/document/product/1073/94308">Tencent</a>
     *
     * @since v0.7.0
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
    }

    /**
     * Defines Text-to-Speech (TTS) module Bytedance vendor parameters for AI agent to join RTC channel, see
     * <a href="https://www.volcengine.com/docs/6561/79823">Bytedance</a>
     *
     * @since v0.7.0
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
    }

    /**
     * Defines Text-to-Speech (TTS) module Microsoft vendor parameters for AI agent to join RTC channel
     *
     * @since v0.7.0
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
    }

    /**
     * Defines Text-to-Speech (TTS) module Elevenlabs vendor parameters for AI agent to join RTC channel
     *
     * @since v0.7.0
     */
    public static class ElevenlabsTTSVendorParams implements TTSVendorParams {

        @JsonProperty("api_key")
        private String apiKey;

        @JsonProperty("model_id")
        private String modelId;

        @JsonProperty("voice_id")
        private String voiceId;
    }

    /**
     * Defines Voice Activity Detection (VAD) configuration for AI agent to join RTC channel
     *
     * @since v0.7.0
     */
    public static class Vad {

        /**
         * Human voice duration threshold (ms), range [120, 1200] (optional)
         *
         * @note Minimum duration of continuous human voice signal to avoid false interruptions.
         */
        @JsonProperty("interrupt_duration_ms")
        private Integer interruptDurationMs;

        /**
         * Prefix padding threshold (ms), range [0, 5000] (optional)
         *
         * @note Minimum duration of voice required to start a new speech segment to avoid triggering voice activity detection with very short sounds.
         */
        @JsonProperty("prefix_padding_ms")
        private Integer prefixPaddingMs;

        /**
         * Silence duration threshold (ms), range [0, 2000] (optional)
         *
         * @note Minimum duration of silence at the end of speech to ensure short pauses do not prematurely end the speech segment.
         */
        @JsonProperty("silence_duration_ms")
        private Integer silenceDurationMs;

        /**
         * Voice recognition sensitivity, range (0.0,1.0) (optional)
         *
         * @note Determines the level of sound in the audio signal considered as "voice activity". Lower values make it easier for the AI agent to detect voice, while higher values may ignore faint sounds.
         */
        @JsonProperty("threshold")
        private Float threshold;
    }

    /**
     * Defines Automatic Speech Recognition (ASR) configuration for AI agent to join RTC channel
     *
     * @since v0.7.0
     */
    public static class Asr {

        /**
         * Language used for interaction between user and AI agent (optional)
         * <p>
         * - zh-CN: Chinese (supports mixed Chinese and English) (default)
         * <p>
         * - en-US: English
         */
        @JsonProperty("language")
        private String language;
    }
}
