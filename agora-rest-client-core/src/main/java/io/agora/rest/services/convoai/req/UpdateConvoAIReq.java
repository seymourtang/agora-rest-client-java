package io.agora.rest.services.convoai.req;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @brief Request body for calling the Conversational AI engine update API
 * @since v0.3.0
 */
public class UpdateConvoAIReq {

    /**
     * Dynamic key (Token) used for authentication. If your project has enabled the
     * App Certificate, you must pass the dynamic key in this field.
     */
    @JsonProperty("token")
    private String token;

    /**
     * LLM parameters
     */
    @JsonProperty("llm")
    private UpdateLLMParams llm;

    public static Builder builder() {
        return new Builder();
    }

    private UpdateConvoAIReq(Builder builder) {
        setToken(builder.token);
        setLlm(builder.llm);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UpdateLLMParams getLlm() {
        return llm;
    }

    public void setLlm(UpdateLLMParams llm) {
        this.llm = llm;
    }

    public static final class Builder {
        private String token;

        private UpdateLLMParams llm;

        private Builder() {
        }

        public Builder token(String val) {
            token = val;
            return this;
        }

        public Builder llm(UpdateLLMParams val) {
            llm = val;
            return this;
        }

        public UpdateConvoAIReq build() {
            return new UpdateConvoAIReq(this);
        }
    }

    /**
     * @brief Define LLM parameters
     * @since v0.6.0
     */
    public static class UpdateLLMParams {
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
        private Map<String, Object> params;

        public static Builder builder() {
            return new Builder();
        }

        private UpdateLLMParams(Builder builder) {
            setSystemMessages(builder.systemMessages);
            setParams(builder.params);
        }

        public List<Map<String, Object>> getSystemMessages() {
            return systemMessages;
        }

        public void setSystemMessages(List<Map<String, Object>> systemMessages) {
            this.systemMessages = systemMessages;
        }

        public Map<String, Object> getParams() {
            return params;
        }

        public void setParams(Map<String, Object> params) {
            this.params = params;
        }

        public static final class Builder {
            private List<Map<String, Object>> systemMessages;
            private Map<String, Object> params;

            private Builder() {
            }

            public Builder systemMessages(List<Map<String, Object>> val) {
                systemMessages = val;
                return this;
            }

            public Builder params(Map<String, Object> val) {
                params = val;
                return this;
            }

            public UpdateLLMParams build() {
                return new UpdateLLMParams(this);
            }
        }
    }
}
