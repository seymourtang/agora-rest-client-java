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
     * @brief Creates an instance of ConvoAIClient
     *
     * @since 0.3.0
     *
     * @param agoraConfig Instance of {@link AgoraConfig}
     *
     * @return Returns an instance of ConvoAIClient
     */
    public static synchronized ConvoAIClient create(AgoraConfig agoraConfig) {
        if (mInstance == null) {
            mInstance = new ConvoAIClientImpl(new DefaultContext(agoraConfig));
        }

        return mInstance;
    }


    /**
     * @brief Sends a join request to the conversational AI engine API
     *
     * @since 0.3.0
     *
     * @details This method sends a request to the conversational AI engine API to make the agent join the specified RTC channel
     *
     * @example Use when you need to create an agent instance in the RTC channel
     *
     * @post After successful execution, the agent will be created and joined to the specified channel, and subsequent operations can be performed using the returned agent ID
     *
     * @param request Parameters for the join request to the conversational AI engine, see {@link JoinConvoAIReq}
     *
     * @return Returns the join response result, see {@link JoinConvoAIRes}
     */
    public abstract Mono<JoinConvoAIRes> join(JoinConvoAIReq request);

    /**
     * @brief Requests to stop the specified conversational agent instance and make the agent leave the RTC channel
     *
     * @since 0.3.0
     *
     * @details This method sends a request to the conversational AI engine API to stop the agent and make it leave the RTC channel
     *
     * @example Use when you need to stop an agent instance
     *
     * @post After successful execution, the agent will be stopped and leave the RTC channel
     *
     * @param agentId Agent ID
     *
     * @return Returns the leave response result, see {@link LeaveConvoAIRes}
     */
    public abstract Mono<LeaveConvoAIRes> leave(String agentId);

    /**
     * @brief Retrieves the information of agents that meet the criteria in a list form
     *
     * @since 0.3.0
     *
     * @details This method sends a request to the conversational AI engine API to retrieve the information of agents that meet the criteria in a list form
     *
     * @example Use when you need to retrieve the information of agents that meet the criteria in a list form
     *
     * @post After successful execution, the information of agents that meet the criteria will be retrieved in a list form
     *
     * @param request Parameters for listing conversational agents, see {@link ListConvoAIReq}
     *
     * @return Returns the list query result, see {@link ListConvoAIRes}
     */
    public abstract Mono<ListConvoAIRes> list(ListConvoAIReq request);

    /**
     * @brief Retrieves the current running status information of the specified agent instance
     *
     * @since 0.3.0
     *
     * @details This method sends a request to the conversational AI engine API to retrieve the current running status information of the specified agent instance
     *
     * @example Use when you need to retrieve the current running status information of the specified agent instance
     *
     * @post After successful execution, the current running status information of the specified agent instance will be retrieved
     *
     * @note Ensure that the agent ID has been obtained by calling the Join interface before calling this API
     *
     * @param agentId Agent ID
     *
     * @return Returns the query response result, see {@link QueryConvoAIRes}
     */
    public abstract Mono<QueryConvoAIRes> query(String agentId);

    /**
     * @brief Allows runtime adjustment of agent parameters
     *
     * @since 0.3.0
     *
     * @details This method sends a request to the conversational AI engine API to adjust the parameters of the runtime agent
     *
     * @example Use when you need to adjust the parameters of the runtime agent
     *
     * @post After successful execution, the parameters of the runtime agent will be adjusted
     *
     * @note Ensure that the agent ID has been obtained by calling the Join interface before calling this API
     *
     * @param agentId Agent ID
     *
     * @param request Parameters for updating the conversational agent, see {@link UpdateConvoAIReq}
     *
     * @return Returns the update response result, see {@link UpdateConvoAIRes}
     */
    public abstract Mono<UpdateConvoAIRes> update(String agentId, UpdateConvoAIReq request);

}
