package io.agora.rest.services.convoai.req;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @brief Request body for calling the Conversational AI engine update API
 * @since v0.3.0
 */
public class UpdateConvoAIReq {

    /**
     * Dynamic key (Token) used for authentication. If your project has enabled the App Certificate, you must pass the dynamic key in this field.
     */
    @JsonProperty("token")
    private String token;

    public static Builder builder() {
        return new Builder();
    }

    private UpdateConvoAIReq(Builder builder) {
        setToken(builder.token);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static final class Builder {
        private String token;

        private Builder() {
        }

        public Builder token(String val) {
            token = val;
            return this;
        }

        public UpdateConvoAIReq build() {
            return new UpdateConvoAIReq(this);
        }
    }
}
