package io.agora.rest.services.convoai.res;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @brief 更新智能体响应
 * @since 0.3.0
 */
public class UpdateConvoAIRes {
    /**
     * 智能体唯一标识
     */
    @JsonProperty("agent_id")
    private String agentId;

    /**
     * @brief 创建时间戳
     */
    @JsonProperty("create_ts")
    private Integer createTs;

    /**
     * 状态
     * @note 有以下状态：
     * <p>
     * - IDLE (0)：空闲状态的智能体
     * <p>
     * - STARTING (1)：正在启动的智能体
     * <p>
     * - RUNNING (2)：正在运行的智能体
     * <p>
     * - STOPPING (3)：正在停止的智能体
     * <p>
     * - STOPPED (4)：已完成退出的智能体
     */
    @JsonProperty("status")
    private String status;
}
