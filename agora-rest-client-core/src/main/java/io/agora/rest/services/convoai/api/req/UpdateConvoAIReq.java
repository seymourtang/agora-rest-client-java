package io.agora.rest.services.convoai.api.req;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @brief 更新智能体请求参数
 * @since 0.3.0
 */
public class UpdateConvoAIReq {

    /**
     * 用于鉴权的动态密钥（Token）。如果你的项目已启用 App 证书，则务必在该字段中传入你项目的动态密钥
     */
    @JsonProperty("token")
    private String token;
}
