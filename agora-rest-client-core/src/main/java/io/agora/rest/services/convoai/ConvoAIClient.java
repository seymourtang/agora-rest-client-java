package io.agora.rest.services.convoai;

import io.agora.rest.core.AgoraConfig;
import io.agora.rest.core.Context;
import io.agora.rest.core.DefaultContext;
import io.agora.rest.services.convoai.api.*;
import io.agora.rest.services.convoai.api.req.JoinConvoAIReq;
import io.agora.rest.services.convoai.api.req.ListConvoAIReq;
import io.agora.rest.services.convoai.api.req.UpdateConvoAIReq;
import io.agora.rest.services.convoai.api.res.*;
import reactor.core.publisher.Mono;

public class ConvoAIClient {

    private final JoinConvoAIAPI joinConvoAIAPI;

    private final LeaveConvoAIAPI leaveConvoAIAPI;

    private final ListConvoAIAPI listConvoAIAPI;

    private final QueryConvoAIAPI queryConvoAIAPI;

    private final UpdateConvoAIAPI updateConvoAIAPI;

    /**
     * @brief 创建 ConvoAIClient 实例
     *
     * @since 0.3.0
     *
     * @param agoraConfig {@link AgoraConfig} 实例
     *
     * @return 返回 ConvoAIClient 实例
     */
    public static ConvoAIClient create(AgoraConfig agoraConfig) {
        return new ConvoAIClient(new DefaultContext(agoraConfig));
    }

    protected ConvoAIClient(Context context) {
        joinConvoAIAPI = new JoinConvoAIAPI(context);
        leaveConvoAIAPI = new LeaveConvoAIAPI(context);
        listConvoAIAPI = new ListConvoAIAPI(context);
        queryConvoAIAPI = new QueryConvoAIAPI(context);
        updateConvoAIAPI = new UpdateConvoAIAPI(context);
    }

    /**
     * @brief 向对话式 AI 引擎 API 发送加入请求
     *
     * @since 0.3.0
     *
     * @details 此方法向对话式AI引擎API发送请求，用于使智能体加入指定的 RTC 频道
     *
     * @example 当需要在RTC频道中创建一个智能体实例时使用
     *
     * @post 成功执行后，智能体将被创建并加入到指定的频道中，可通过返回的智能体 ID 进行后续操作
     *
     * @param request 加入向对话式 AI 引擎请求参数，详见 {@link JoinConvoAIReq}
     *
     * @return 返回加入响应结果，详见 {@link JoinConvoAIRes}
     */
    public Mono<JoinConvoAIRes> join(JoinConvoAIReq request) {
        return joinConvoAIAPI.handle(request);
    }

    /**
     * @brief 请求停止指定的对话式智能体实例，并让智能体退出 RTC 频道
     *
     * @since 0.3.0
     *
     * @details 此方法向对话式AI引擎API发送请求，用于使智能体停止并退出 RTC 频道
     *
     * @example 当需要停止一个智能体实例时使用
     *
     * @post 成功执行后，智能体将被停止并退出 RTC 频道
     *
     * @param agentId 智能体 ID
     *
     * @return 返回离开响应结果，详见 {@link LeaveConvoAIRes}
     */
    public Mono<LeaveConvoAIRes> leave(String agentId) {
        return leaveConvoAIAPI.handle(agentId);
    }

    /**
     * @brief 以列表形式获取满足条件的智能体信息
     *
     * @since 0.3.0
     *
     * @details 此方法向对话式AI引擎API发送请求，以列表形式获取满足条件的智能体信息
     *
     * @example 当需要以列表形式获取满足条件的智能体信息
     *
     * @post 成功执行后，将会以列表形式获取满足条件的智能体信息
     *
     * @param req 列出对话式智能体请求参数，详见 {@link ListConvoAIReq}
     *
     * @return 返回查询列表结果，详见 {@link ListConvoAIRes}
     */
    public Mono<ListConvoAIRes> list(ListConvoAIReq req) {
        return listConvoAIAPI.handle(req);
    }

    /**
     * @brief 获取指定智能体实例的当前运行状态信息
     *
     * @since 0.3.0
     *
     * @details 此方法向对话式AI引擎API发送请求，获取指定智能体实例的当前运行状态信息
     *
     * @example 当需要获取指定智能体实例的当前运行状态信息
     *
     * @post 成功执行后，将会获取到指定智能体实例的当前运行状态信息
     *
     * @note 调用此API前需确保已通过调用 Join 接口获取到智能体的 ID
     *
     * @param agentId 智能体 ID
     *
     * @return 返回查询响应结果，详见 {@link QueryConvoAIRes}
     */
    public Mono<QueryConvoAIRes> query(String agentId) {
        return queryConvoAIAPI.handle(agentId);
    }

    /**
     * @brief 允许运行时对智能体的参数进行调整
     *
     * @since 0.3.0
     *
     * @details 此方法向对话式AI引擎API发送请求，对运行时智能体的参数进行调整
     *
     * @example 当需要对运行时智能体的参数进行调整
     *
     * @post 成功执行后，将会对运行时智能体的参数进行调整
     *
     * @note 调用此API前需确保已通过调用 Join 接口获取到智能体的 ID
     *
     * @param agentId 智能体 ID
     *
     * @param request 更新对话式智能体请求参数，详见 {@link UpdateConvoAIReq}
     *
     * @return 返回更新响应结果，详见 {@link UpdateConvoAIRes}
     */
    public Mono<UpdateConvoAIRes> update(String agentId, UpdateConvoAIReq request) {
        return updateConvoAIAPI.handle(agentId, request);
    }
}
