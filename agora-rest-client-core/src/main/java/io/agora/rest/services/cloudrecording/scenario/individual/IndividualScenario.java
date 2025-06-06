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
         * @post After receiving the resource ID, call the start API to start cloud
         *       recording.
         * @param cname         The name of the channel to be recorded.
         * @param uid           The user ID used by the cloud recording service in the
         *                      RTC channel to identify the recording service in the
         *                      channel.
         * @param clientRequest The request body. See
         *                      {@link AcquireIndividualResourceClientReq} for
         *                      details.
         * @return Returns the acquire resource result. See
         *         {@link AcquireResourceRes} for details.
         */
        public abstract Mono<AcquireResourceRes> acquire(String cname, String uid,
                        AcquireIndividualResourceClientReq clientRequest);

        /**
         * @brief Start individual cloud recording.
         * @since v0.4.0
         * @param cname         Channel name.
         * @param uid           User ID.
         * @param resourceId    The resource ID.
         * @param clientRequest The request body. See
         *                      {@link StartIndividualRecordingClientReq} for
         *                      details.
         * @return Returns the start resource result. See
         *         {@link StartResourceRes} for details.
         */
        public abstract Mono<StartResourceRes> start(String cname, String uid, String resourceId,
                        StartIndividualRecordingClientReq clientRequest);

        /**
         * @brief Query the status of individual cloud recording when video screenshot
         *        capture is turned off.
         * @since v0.4.0
         * @param resourceId The resource ID.
         * @param sid        The recording ID, identifying a recording cycle.
         * @return Returns the query recording resource result. See
         *         {@link QueryIndividualRecordingResourceRes} for details.
         */
        public abstract Mono<QueryIndividualRecordingResourceRes> query(String resourceId, String sid);

        /**
         * @brief Query the status of individual cloud recording when video screenshot
         *        capture is turned on.
         * @since v0.4.0
         * @param resourceId The resource ID.
         * @param sid        The recording ID, identifying a recording cycle.
         * @return Returns the query recording resource result when video screenshot
         *         capture is turned on. See
         *         {@link QueryIndividualRecordingVideoScreenshotResourceRes} for
         *         details.
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
         *                      {@link UpdateIndividualRecordingResourceClientReq} for
         *                      details.
         * @return Returns the update resource result. See
         *         {@link UpdateResourceRes} for details.
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
         * @return Returns the stop resource result. See {@link StopResourceRes} for
         *         details.
         */
        public abstract Mono<StopResourceRes> stop(String cname, String uid, String resourceId, String sid,
                        boolean asyncStop);
}
