package io.agora.rest.services.convoai.api.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @brief 查询智能体列表响应
 * @since 0.3.0
 */
public class ListConvoAIRes {

    /**
     * 数据
     */
    @JsonProperty("data")
    private Data data;

    /**
     * 元数据
     */
    @JsonProperty("meta")
    private Meta meta;

    /**
     * 请求状态
     */
    @JsonProperty("status")
    private String status;

    /**
     * 响应数据
     */
    public static class Data {

        /**
         * 本次返回的智能体数量
         */
        @JsonProperty("count")
        private Integer count;

        /**
         * 智能体列表，详细信息请参考 {@link Agent}
         */
        @JsonProperty("list")
        private List<Agent> list;
    }

    /**
     * 智能体信息
     */
    public static class Agent{

        /**
         * 智能体唯一标识
         */
        @JsonProperty("agent_id")
        private String agentId;

        /**
         * @brief 创建时间戳
         */
        @JsonProperty("start_ts")
        private Integer startTs;

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

    /**
     * 元数据
     */
    public static class Meta{

        /**
         * 满足本次查询条件的智能体总数量
         */
        @JsonProperty("total")
        private Integer total;

        /**
         * 分页游标
         */
        @JsonProperty("cursor")
        private String cursor;
    }
}
