package io.agora.rest.services.convoai;

import io.agora.rest.core.AgoraConfig;
import io.agora.rest.core.DefaultContext;
import io.agora.rest.services.convoai.req.JoinConvoAIReq;
import io.agora.rest.services.convoai.req.ListConvoAIReq;
import io.agora.rest.services.convoai.req.UpdateConvoAIReq;
import io.agora.rest.services.convoai.res.*;
import reactor.core.publisher.Mono;

public abstract class ConvoAIClient {

    private static ConvoAIClient mInstance;

    /**
     * @param agoraConfig {@link AgoraConfig} 实例
     * @return 返回 ConvoAIClient 实例
     * @brief 创建 ConvoAIClient 实例
     * @since 0.3.0
     */
    public static synchronized ConvoAIClient create(AgoraConfig agoraConfig) {
        if (mInstance == null) {
            mInstance = new ConvoAIClientImpl(new DefaultContext(agoraConfig));
        }

        return mInstance;
    }

    /**
     * @param request 加入向对话式 AI 引擎请求参数，详见 {@link JoinConvoAIReq}
     * @return 返回加入响应结果，详见 {@link JoinConvoAIRes}
     * @brief 向对话式 AI 引擎 API 发送加入请求
     * @details 此方法向对话式AI引擎API发送请求，用于使智能体加入指定的 RTC 频道
     * @example 当需要在RTC频道中创建一个智能体实例时使用
     * @post 成功执行后，智能体将被创建并加入到指定的频道中，可通过返回的智能体 ID 进行后续操作
     * @since 0.3.0
     */
    public abstract Mono<JoinConvoAIRes> join(JoinConvoAIReq request);

    /**
     * @param agentId 智能体 ID
     * @return 返回离开响应结果，详见 {@link LeaveConvoAIRes}
     * @brief 请求停止指定的对话式智能体实例，并让智能体退出 RTC 频道
     * @details 此方法向对话式AI引擎API发送请求，用于使智能体停止并退出 RTC 频道
     * @example 当需要停止一个智能体实例时使用
     * @post 成功执行后，智能体将被停止并退出 RTC 频道
     * @since 0.3.0
     */
    public abstract Mono<LeaveConvoAIRes> leave(String agentId);

    /**
     * @param request 列出对话式智能体请求参数，详见 {@link ListConvoAIReq}
     * @return 返回查询列表结果，详见 {@link ListConvoAIRes}
     * @brief 以列表形式获取满足条件的智能体信息
     * @details 此方法向对话式AI引擎API发送请求，以列表形式获取满足条件的智能体信息
     * @example 当需要以列表形式获取满足条件的智能体信息
     * @post 成功执行后，将会以列表形式获取满足条件的智能体信息
     * @since 0.3.0
     */
    public abstract Mono<ListConvoAIRes> list(ListConvoAIReq request);

    /**
     * @param agentId 智能体 ID
     * @return 返回查询响应结果，详见 {@link QueryConvoAIRes}
     * @brief 获取指定智能体实例的当前运行状态信息
     * @details 此方法向对话式AI引擎API发送请求，获取指定智能体实例的当前运行状态信息
     * @example 当需要获取指定智能体实例的当前运行状态信息
     * @post 成功执行后，将会获取到指定智能体实例的当前运行状态信息
     * @note 调用此API前需确保已通过调用 Join 接口获取到智能体的 ID
     * @since 0.3.0
     */
    public abstract Mono<QueryConvoAIRes> query(String agentId);

    /**
     * @param agentId 智能体 ID
     * @param request 更新对话式智能体请求参数，详见 {@link UpdateConvoAIReq}
     * @return 返回更新响应结果，详见 {@link UpdateConvoAIRes}
     * @brief 允许运行时对智能体的参数进行调整
     * @details 此方法向对话式AI引擎API发送请求，对运行时智能体的参数进行调整
     * @example 当需要对运行时智能体的参数进行调整
     * @post 成功执行后，将会对运行时智能体的参数进行调整
     * @note 调用此API前需确保已通过调用 Join 接口获取到智能体的 ID
     * @since 0.3.0
     */
    public abstract Mono<UpdateConvoAIRes> update(String agentId, UpdateConvoAIReq request);
}
