package io.agora.rest.services.cloudrecording.scenario.web;

import io.agora.rest.services.cloudrecording.api.res.AcquireResourceRes;
import io.agora.rest.services.cloudrecording.api.res.StartResourceRes;
import io.agora.rest.services.cloudrecording.api.res.StopResourceRes;
import io.agora.rest.services.cloudrecording.api.res.UpdateResourceRes;
import io.agora.rest.services.cloudrecording.scenario.web.req.AcquireWebRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.web.req.StartWebRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.web.req.UpdateWebRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.web.res.QueryWebRecordingResourceRes;
import io.agora.rest.services.cloudrecording.scenario.web.res.QueryWebRecordingRtmpPublishResourceRes;
import reactor.core.publisher.Mono;

public abstract class WebScenario {

        /**
         * @brief Get a resource ID for web cloud recording.
         * @since v0.4.0
         * @post After receiving the resource ID, call the start API to start cloud
         *       recording.
         * @param cname         The name of the channel to be recorded.
         * @param uid           The user ID used by the cloud recording service in the
         *                      RTC channel to identify the recording service in the
         *                      channel.
         * @param clientRequest The request body. See
         *                      {@link AcquireWebRecordingResourceClientReq} for
         *                      details.
         * @return Returns the acquire resource result. See {@link AcquireResourceRes}
         *         for details.
         */
        public abstract Mono<AcquireResourceRes> acquire(String cname, String uid,
                        AcquireWebRecordingResourceClientReq clientRequest);

        /**
         * @brief Start web recording.
         * @since v0.4.0
         * @param cname         The name of the channel to be recorded.
         * @param uid           The user ID used by the cloud recording service in the
         *                      RTC channel to identify the recording service in the
         *                      channel.
         * @param resourceId    The resource ID.
         * @param clientRequest The request body. See
         *                      {@link StartWebRecordingResourceClientReq} for details.
         * @return Returns the start resource result. See {@link StartResourceRes}
         *         for details.
         */
        public abstract Mono<StartResourceRes> start(String cname, String uid, String resourceId,
                        StartWebRecordingResourceClientReq clientRequest);

        /**
         * @brief Query the status of web recording.
         * @since v0.4.0
         * @param resourceId The resource ID.
         * @param sid        The recording ID, identifying a recording cycle.
         * @return Returns the query web recording resource result. See
         *         {@link QueryWebRecordingResourceRes} for details.
         */
        public abstract Mono<QueryWebRecordingResourceRes> query(String resourceId, String sid);

        /**
         * @brief Query the status of pushing web page recording to the CDN.
         * @since v0.4.0
         * @param resourceId The resource ID.
         * @param sid        The recording ID, identifying a recording cycle.
         * @return Returns the query web recording rtmp publish resource result. See
         *         {@link QueryWebRecordingRtmpPublishResourceRes} for details.
         */
        public abstract Mono<QueryWebRecordingRtmpPublishResourceRes> queryRtmpPublish(String resourceId, String sid);

        /**
         * @brief Update the web recording configuration.
         * @since v0.4.0
         * @param cname         The name of the channel to be recorded.
         * @param uid           The user ID used by the cloud recording service in the
         *                      RTC channel to identify the recording service in the
         *                      channel.
         * @param resourceId    The resource ID.
         * @param sid           The recording ID, identifying a recording cycle.
         * @param clientRequest The request body. See
         *                      {@link UpdateWebRecordingResourceClientReq} for
         *                      details.
         * @return Returns the update resource result. See
         *         {@link UpdateResourceRes} for details.
         */
        public abstract Mono<UpdateResourceRes> update(String cname, String uid, String resourceId, String sid,
                        UpdateWebRecordingResourceClientReq clientRequest);

        /**
         * @brief Stop web recording.
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
