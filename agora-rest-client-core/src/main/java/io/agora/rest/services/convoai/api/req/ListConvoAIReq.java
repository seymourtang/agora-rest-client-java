package io.agora.rest.services.convoai.api.req;

import java.util.HashMap;
import java.util.Map;

/**
 * @brief 查询智能体列表请求参数
 * @since 0.3.0
 */
public class ListConvoAIReq {
    private final Map<String, Object> params = new HashMap<>();

    public ListConvoAIReq() {
    }

    /**
     * @param channel 频道
     * @return 返回 {@link ListConvoAIReq} 实例
     * @brief 设置查询channel参数，查询指定频道名下的智能体列表
     */
    public ListConvoAIReq channel(String channel) {
        params.put("channel", channel);
        return this;
    }

    /**
     * @param limit 数量
     * @return 返回 {@link ListConvoAIReq} 实例
     * @brief 设置查询limit参数，查询指定数量的智能体列表，分页获取单次返回的最大条数，默认为 20
     */
    public ListConvoAIReq limit(Integer limit) {
        params.put("limit", limit);
        return this;
    }

    /**
     * @param state 状态
     * @return 返回 {@link ListConvoAIReq} 实例
     * @brief 设置查询state参数，查询指定状态的智能体列表，单次查询不支持指定多种状态
     * @note 支持以下状态：
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
    public ListConvoAIReq state(Integer state) {
        params.put("state", state);
        return this;
    }

    /**
     * @param cursor 游标
     * @return 返回 {@link ListConvoAIReq} 实例
     * @brief 设置查询cursor参数，查询指定游标位置的智能体列表，即分页起始位置的智能体 ID
     */
    public ListConvoAIReq cursor(String cursor) {
        params.put("cursor", cursor);
        return this;
    }

    /**
     * @param fromTime 开始时间
     * @return 返回 {@link ListConvoAIReq} 实例
     * @brief 设置查询fromTime参数，查询列表开始时间戳 (s)，默认为 1 天前
     */
    public ListConvoAIReq fromTime(Long fromTime) {
        params.put("fromTime", fromTime);
        return this;
    }

    /**
     * @param toTime 结束时间
     * @return 返回 {@link ListConvoAIReq} 实例
     * @brief 设置查询toTime参数，查询列表结束时间戳 (s)，默认为当前时刻
     */
    public ListConvoAIReq toTime(Long toTime) {
        params.put("toTime", toTime);
        return this;
    }

    /**
     * @return 返回查询字符串
     * @brief 将请求参数转换为查询字符串
     */
    public String toQueryString() {
        if (params.isEmpty()) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
