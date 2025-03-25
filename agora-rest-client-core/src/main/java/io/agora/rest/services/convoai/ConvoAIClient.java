package io.agora.rest.services.convoai;

import io.agora.rest.core.AgoraConfig;
import io.agora.rest.core.DefaultContext;
import io.agora.rest.services.convoai.req.JoinConvoAIReq;
import io.agora.rest.services.convoai.req.ListConvoAIReq;
import io.agora.rest.services.convoai.req.UpdateConvoAIReq;
import io.agora.rest.services.convoai.res.JoinConvoAIRes;
import io.agora.rest.services.convoai.res.ListConvoAIRes;
import io.agora.rest.services.convoai.res.QueryConvoAIRes;
import io.agora.rest.services.convoai.res.UpdateConvoAIRes;
import reactor.core.publisher.Mono;

public abstract class ConvoAIClient {

    private static ConvoAIClient mInstance;

    /**
     * @param convoAIConfig Instance of {@link ConvoAIConfig}
     * @return Returns an instance of ConvoAIClient.
     * @brief Creates an instance of ConvoAIClient.
     * @since 0.3.0
     */
    public static synchronized ConvoAIClient create(ConvoAIConfig convoAIConfig) {
        if (mInstance == null) {
            AgoraConfig agoraConfig = AgoraConfig.builder()
                    .appId(convoAIConfig.getAppId())
                    .credential(convoAIConfig.getCredential())
                    .domainArea(convoAIConfig.getDomainArea())
                    .httpProperty(convoAIConfig.getHttpProperty())
                    .build();
            mInstance = new ConvoAIClientImpl(new DefaultContext(agoraConfig), convoAIConfig.getServiceRegion());
        }

        return mInstance;
    }

    /**
     * @param request Parameters for the join request to the conversational AI engine, see {@link JoinConvoAIReq}
     * @return Returns the join response result, see {@link JoinConvoAIRes}
     * @brief Creates an agent instance and joins the specified RTC channel.
     * @example Use this to create an agent instance in an RTC channel.
     * @post After successful execution, the agent will join the specified channel. You can perform subsequent operations using the returned agent ID.
     * @since 0.3.0
     */
    public abstract Mono<JoinConvoAIRes> join(JoinConvoAIReq request);

    /**
     * @param agentId Agent ID
     * @brief Stops the specified agent instance and leaves the RTC channel
     * @example Use this to stop an agent instance.
     * @post After successful execution, the agent will be stopped and leave the RTC channel
     * @note Ensure the agent ID has been obtained by calling the Join API before using this method.
     * @since 0.3.0
     */
    public abstract Mono<Void> leave(String agentId);

    /**
     * @param request Parameters for listing conversational agents, see {@link ListConvoAIReq}
     * @return Returns the list response result, see {@link ListConvoAIRes} for details
     * @brief Retrieves a list of agents that meet the specified criteria
     * @example Use this to get a list of agents that meet the specified criteria.
     * @post After successful execution, a list of agents that meet the specified criteria will be retrieved.
     * @since 0.3.0
     */
    public abstract Mono<ListConvoAIRes> list(ListConvoAIReq request);

    /**
     * @param agentId Agent ID
     * @return Returns the query response result, see {@link QueryConvoAIRes}
     * @brief Retrieves the current status of the specified agent instance
     * @example Use this to get the current status of the specified agent instance.
     * @post After successful execution, the current running status information of the specified agent instance will be retrieved
     * @note Ensure the agent ID has been obtained by calling the Join API before using this method.
     * @since 0.3.0
     */
    public abstract Mono<QueryConvoAIRes> query(String agentId);

    /**
     * @param agentId Agent ID
     * @param request Parameters for updating the conversational agent, see {@link UpdateConvoAIReq} for details
     * @return Returns the update response result, see {@link UpdateConvoAIRes}
     * @brief Adjusts the agent's parameters at runtime
     * @example Use this to adjust the agent's parameters at runtime.
     * @post Ensure the agent ID has been obtained by calling the Join API before using this method.
     * @since 0.3.0
     */
    public abstract Mono<UpdateConvoAIRes> update(String agentId, UpdateConvoAIReq request);

}
