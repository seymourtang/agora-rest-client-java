package io.agora.rest.services.cloudrecording.scenario.individual;

import io.agora.rest.services.cloudrecording.api.res.AcquireResourceRes;
import io.agora.rest.services.cloudrecording.api.res.StartResourceRes;
import io.agora.rest.services.cloudrecording.api.res.StopResourceRes;
import io.agora.rest.services.cloudrecording.api.res.UpdateResourceRes;
import io.agora.rest.services.cloudrecording.scenario.individual.req.AcquireIndividualResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.individual.req.StartIndividualRecordingClientReq;
import io.agora.rest.services.cloudrecording.scenario.individual.req.UpdateIndividualRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.individual.res.QueryIndividualRecordingResourceRes;
import io.agora.rest.services.cloudrecording.scenario.individual.res.QueryIndividualRecordingVideoScreenshotResourceRes;
import reactor.core.publisher.Mono;

public abstract class IndividualScenario {

        /**
         * @brief Get a resource ID for individual cloud recording.
         * @since v0.4.0
         * @post After receiving the resource ID, call the Start API to start cloud
         *       recording.
         * @param cname          The name of the channel to be recorded.
         * @param uid            The user ID used by the cloud recording service in the
         *                       RTC channel to identify the recording service in the
         *                       channel.
         * @param enablePostpone Whether to postpone the recording.
         *                       - true: Postpone the recording.
         *                       - false: Start the recording immediately.
         * @param clientRequest  The request body. See
         *                       AcquireIndividualResourceClientReq for details.
         * @return Returns the response AcquireResourceRes. See AcquireResourceRes for
         *         details.
         */
        public abstract Mono<AcquireResourceRes> acquire(String cname, String uid, boolean enablePostpone,
                        AcquireIndividualResourceClientReq clientRequest);

        /**
         * @brief Start individual cloud recording.
         * @since v0.4.0
         * @param cname         Channel name.
         * @param uid           User ID.
         * @param resourceId    The resource ID.
         * @param clientRequest The request body. See StartIndividualRecordingClientReq
         *                      for details.
         * @return Returns the response StartResourceRes. See StartResourceRes for
         *         details.
         */
        public abstract Mono<StartResourceRes> start(String cname, String uid, String resourceId,
                        StartIndividualRecordingClientReq clientRequest);

        /**
         * @brief Query the status of individual cloud recording when video screenshot
         *        capture is turned off.
         * @since v0.4.0
         * @param resourceId The resource ID.
         * @param sid        The recording ID, identifying a recording cycle.
         * @return Returns the response QueryIndividualRecordingResourceRes. See
         *         QueryIndividualRecordingResourceRes for details.
         */
        public abstract Mono<QueryIndividualRecordingResourceRes> query(String resourceId, String sid);

        /**
         * @brief Query the status of individual cloud recording when video screenshot
         *        capture is turned on.
         * @since v0.4.0
         * @param resourceId The resource ID.
         * @param sid        The recording ID, identifying a recording cycle.
         * @return Returns the response
         *         QueryIndividualRecordingVideoScreenshotResourceRes. See
         *         QueryIndividualRecordingVideoScreenshotResourceRes for details.
         */
        public abstract Mono<QueryIndividualRecordingVideoScreenshotResourceRes> queryVideoScreenshot(String resourceId,
                        String sid);

        /**
         * @brief Update the individual cloud recording configuration.
         * @since v0.4.0
         * @param cname         The name of the channel to be recorded.
         * @param uid           The user ID used by the cloud recording service in the
         *                      RTC channel to identify the recording service in the
         *                      channel.
         * @param resourceId    The resource ID.
         * @param sid           The recording ID, identifying a recording cycle.
         * @param clientRequest The request body. See
         *                      UpdateIndividualRecordingResourceClientReq for details.
         * @return Returns the response UpdateResourceRes. See UpdateResourceRes for
         *         details.
         */
        public abstract Mono<UpdateResourceRes> update(String cname, String uid, String resourceId, String sid,
                        UpdateIndividualRecordingResourceClientReq clientRequest);

        /**
         * @brief Stop individual cloud recording.
         * @since v0.4.0
         * @param cname      The name of the channel to be recorded.
         * @param uid        The user ID used by the cloud recording service in the RTC
         *                   channel to identify the recording service in the channel.
         * @param resourceId The resource ID.
         * @param sid        The recording ID, identifying a recording cycle.
         * @param asyncStop  Whether to stop the recording asynchronously.
         *                   <p>
         *                   - true: Stop the recording asynchronously.
         *                   <p>
         *                   - false: Stop the recording synchronously.
         * @return Returns the response StopResourceRes. See StopResourceRes for
         *         details.
         */
        public abstract Mono<StopResourceRes> stop(String cname, String uid, String resourceId, String sid,
                        boolean asyncStop);
}
