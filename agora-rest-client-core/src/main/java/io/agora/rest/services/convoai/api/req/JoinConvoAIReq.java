package io.agora.rest.services.convoai.api.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

/**
 * @brief 智能体加入 RTC 频道的请求参数配置
 * @since 0.3.0
 */
public class JoinConvoAIReq {

    /**
     * 智能体唯一标识，相同标识不可重复创建
     */
    @JsonProperty("name")
    private String name;

    /**
     * 智能体属性配置
     */
    @JsonProperty("properties")
    private Properties properties;

    /**
     * @brief 智能体加入 RTC 频道的属性配置
     * @since 0.3.0
     */
    public static class Properties {

        /**
         * 加入 RTC 频道使用的 Token，即用于鉴权的动态密钥（Token）（可选）。如果你的项目已启用 App 证书，则务必在该字段中传入你项目的动态密钥
         */
        @JsonProperty("token")
        private String token;

        /**
         * 智能体加入的 RTC 频道名（必须）
         */
        @JsonProperty("channel")
        private String channel;

        /**
         * 智能体在 RTC 频道内的用户 ID（必须）
         *
         * @note 填 "0" 时表示随机分配，但 Token 需要相应修改
         */
        @JsonProperty("agent_rtc_uid")
        private String agentRtcUId;

        /**
         * 智能体在 RTC 频道中订阅的用户 ID 列表，只有订阅的用户才能与智能体互动（必须）
         *
         * @note 传入 "*" 表示订阅频道内所有用户
         */
        @JsonProperty("remote_rtc_uids")
        private List<String> remoteRtcUIds;

        /**
         * 是否启用 String UID（可选）
         * <p>
         * - true：启用 String UID
         * <p>
         * - false：不启用 String UID（默认）
         */
        @JsonProperty("enable_string_uid")
        private Boolean enableStringUId;

        /**
         * RTC 频道的最大空闲时间 (s)（可选）
         *
         * @note 检测到 remote_rtc_uids 中指定的用户全部离开频道后的时间视为频道空闲时间，
         * 超过设定的最大值时，频道的智能体将自动停止并退出频道。
         * 如果填写为 0，则直到手动退出，智能体才会停止
         */
        @JsonProperty("idle_timeout")
        private Integer idleTimeout;

        /**
         * 高级功能配置（可选），详见 {@link AdvancedFeatures} 说明
         */
        @JsonProperty("advanced_features")
        private AdvancedFeatures advancedFeatures;

        /**
         * 大语言模型 (LLM) 配置（必须），详见 {@link LLM} 说明
         */
        @JsonProperty("llm")
        private LLM llm;

        /**
         * 文本转语音 (TTS) 配置（可选），详见 {@link TTS} 说明
         */
        @JsonProperty("tts")
        private TTS tts;

        /**
         * 语音活动检测 (VAD) 配置（可选），详见 {@link Vad} 说明
         */
        @JsonProperty("vad")
        private Vad vad;


        /**
         * 自动语音识别 (ASR) 配置（可选），详见 {@link Asr} 说明
         */
        @JsonProperty("asr")
        private Asr asr;
    }

    /**
     * @brief 定义智能体加入 RTC 频道的高级功能配置
     * @since 0.3.0
     */
    public static class AdvancedFeatures {

        /**
         * 是否启用优雅打断功能 (AIVAD)（可选）
         * <p>
         * - true：启用
         * - false：不启用（默认）
         *
         * @note 开启后，用户可以随时打断 AI 并快速响应，实现自然过渡和流畅对话
         */
        @JsonProperty("enable_aivad")
        private Boolean enableAIVad;
    }


    /**
     * @brief 定义智能体加入 RTC 频道的大语言模型 (LLM) 配置
     * @since 0.3.0
     */
    public static class LLM {

        /**
         * LLM 回调地址（必须）
         *
         * @note 要求与 OpenAI 协议兼容
         */
        @JsonProperty("url")
        private String url;

        /**
         * LLM 校验 api key（必须）
         *
         * @note 默认为空，生产环境中务必启用 api key
         */
        @JsonProperty("api_key")
        private String apiKey;

        /**
         * 一组每次调用 LLM 时被附加在最前的预定义信息，用于控制 LLM 输出(可选)
         *
         * @note 可以是角色设定、提示词和回答样例等，要求与 OpenAI 协议兼容
         */
        @JsonProperty("system_messages")
        private String systemMessages;

        /**
         * 在消息体内传输的 LLM 附加信息，例如使用的模型、最大 Token 数限制等（可选）
         * <p>
         * 不同的 LLM 供应商支持的配置不同，详见各自 LLM 的文档
         */
        @JsonProperty("params")
        private HashMap<String, Object> params;

        /**
         * LLM 中缓存的短期记忆条目数（可选）
         * <p>
         * 默认值为 10
         *
         * @note 传入 0 表示不缓存任何短期记忆。智能体和订阅用户会单独记录条目
         */
        @JsonProperty("max_history")
        private Integer maxHistory;

        /**
         * 智能体问候语（可选）
         *
         * @note 如果填写，则在频道内没有订阅用户列表 (remote_rtc_uids) 中的用户时，
         * 智能体会自动向首位加入频道的订阅用户发送问候语。
         */
        @JsonProperty("greeting_message")
        private String greetingMessage;

        /**
         * LLM 的输入模态（可选）
         * <p>
         * - ["text"]: 仅文字（默认）
         * <p>
         * - ["text", "image"]: 文字加图片，要求所选 LLM 支持视觉模态输入
         */
        @JsonProperty("input_modalities")
        private List<String> inputModalities;

        /**
         * LLM 的输出模态（可选）
         * <p>
         * - ["text"]: 仅文字（默认），输出的文字会经过 TTS 模块转换成语音后发布至 RTC 频道。
         * <p>
         * - ["audio"]: 仅语音。语音会直接发布至 RTC 频道。
         * <p>
         * - ["text", "audio"]: 文字加语音。你可以自行编写逻辑，按需处理 LLM 的输出
         */
        @JsonProperty("output_modalities")
        private List<String> outputModalities;

        /**
         * 智能体处理失败提示语(可选)
         *
         * @note 如果填写，则在 LLM 调用错误时会通过 TTS 模块返回。
         */
        @JsonProperty("failure_message")
        private String failureMessage;

        @JsonProperty("style")
        private String style;
    }

    public interface TTSVendorParams {
    }

    /**
     * 定义智能体加入 RTC 频道的文本转语音 (TTS) 配置
     *
     * @since 0.3.0
     */
    public static class TTS {

        /**
         * TTS 供应商，支持传入以下值：
         * 见 {@link TTSVendorEnum}
         */
        @JsonProperty("vendor")
        private String vendor;

        /**
         * TTS 供应商参数说明，详见
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
     * 定义智能体加入 RTC 频道的文本转语音 (TTS) 供应商枚举
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
     * 定义智能体加入 RTC 频道的文本转语音 (TTS) 模块 Minimax 供应商参数，详细见
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
     * 定义智能体加入 RTC 频道的文本转语音 (TTS) 模块 Tencent 供应商参数，详细见
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
     * 定义智能体加入 RTC 频道的文本转语音 (TTS) 模块 Bytedance 供应商参数，详细见
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
     * 定义智能体加入 RTC 频道的文本转语音 (TTS) 模块 Microsoft 供应商参数
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
     * 定义智能体加入 RTC 频道的文本转语音 (TTS) 模块 Elevenlabs 供应商参数
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
     * 定义智能体加入 RTC 频道的语音活动检测 (VAD) 配置
     *
     * @since v0.7.0
     */
    public static class Vad {

        /**
         * 人声持续阈值 (ms)，取值范围为 [120, 1200](可选)
         *
         * @note 持续检测到人声信号的最小时间长度，避免误打断
         */
        @JsonProperty("interrupt_duration_ms")
        private Integer interruptDurationMs;

        /**
         * 前缀填充阈值 (ms)，取值范围为 [0, 5000](可选)
         *
         * @note 开始新的语音片段所需的最短语音持续时间，避免非常短的声音触发语音活动检测
         */
        @JsonProperty("prefix_padding_ms")
        private Integer prefixPaddingMs;

        /**
         * 静音持续阈值 (ms)，取值范围为 [0, 2000]（可选）
         *
         * @note 语音结束时的最短静音持续时间，确保短暂的停顿不会过早结束语音片段
         */
        @JsonProperty("silence_duration_ms")
        private Integer silenceDurationMs;

        /**
         * 语音识别灵敏度，取值范围为 (0.0,1.0)（可选）
         *
         * @note 决定音频信号中何种程度的声音被视为“语音活动”。
         * 较低的值会使智能体更容易检测到语音，较高的值则可能忽略微弱声音。
         */
        @JsonProperty("threshold")
        private Float threshold;
    }

    /**
     * 定义智能体加入 RTC 频道的自动语音识别 (ASR) 配置
     *
     * @since v0.7.0
     */
    public static class Asr {

        /**
         * 用户与智能体互动时使用的语言(可选)
         * <p>
         * - zh-CN：中文（支持中英文混合）（默认）
         * <p>
         * - en-US：英文
         */
        @JsonProperty("language")
        private String language;
    }

}
