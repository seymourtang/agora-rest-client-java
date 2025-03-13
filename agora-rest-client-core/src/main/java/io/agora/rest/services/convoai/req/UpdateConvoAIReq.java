package io.agora.rest.services.convoai.req;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @brief Request parameters for updating AI agent
 * @since 0.3.0
 */
public class UpdateConvoAIReq {

    /**
     * Dynamic key (Token) used for authentication. If your project has enabled the App Certificate, you must pass the dynamic key in this field.
     */
    @JsonProperty("token")
    private String token;
}
