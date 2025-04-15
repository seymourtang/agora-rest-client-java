package io.agora.rest.services.cloudrecording.scenario.web;

import io.agora.rest.services.cloudrecording.api.res.AcquireResourceRes;
import io.agora.rest.services.cloudrecording.api.res.StartResourceRes;
import io.agora.rest.services.cloudrecording.api.res.StopResourceRes;
import io.agora.rest.services.cloudrecording.api.res.UpdateResourceRes;
import io.agora.rest.services.cloudrecording.scenario.web.req.AcquireWebRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.web.req.StartWebRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.web.req.UpdateWebRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.web.res.QueryWebRecordingResourceRes;
import reactor.core.publisher.Mono;

public abstract class WebScenario {

        /**
         * @brief Get a resource ID for web cloud recording.
         * @since v0.4.0
         * @post After receiving the resource ID, call the Start API to start cloud
         *       recording.
         * @param cname         The name of the channel to be recorded.
         * @param uid           The user ID used by the cloud recording service in the
         *                      RTC channel to identify the recording service in the
         *                      channel.
         * @param clientRequest The request body.
         * @return Returns the response AcquireResourceRes. See AcquireResourceRes for
         *         details.
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
         * @param clientRequest The request body. See StartWebRecordingResourceClientReq
         *                      for details.
         * @return Returns the response StartResourceRes. See StartResourceRes for
         *         details.
         */
        public abstract Mono<StartResourceRes> start(String cname, String uid, String resourceId,
                        StartWebRecordingResourceClientReq clientRequest);

        /**
         * @brief Query the status of web recording.
         * @since v0.4.0
         * @param resourceId The resource ID.
         * @param sid        The recording ID, identifying a recording cycle.
         * @return Returns the response QueryWebRecordingResourceRes. See
         *         QueryWebRecordingResourceRes for details.
         */
        public abstract Mono<QueryWebRecordingResourceRes> query(String resourceId, String sid);

        // /**
        // * @brief Query the status of pushing web page recording to the CDN.
        // * @since v0.4.0
        // * @param resourceId The resource ID.
        // * @param sid The recording ID, identifying a recording cycle.
        // * @return Returns the response QueryRtmpPublishResourceRes. See
        // QueryRtmpPublishResourceRes for details.
        // */
        // public abstract Mono<QueryRtmpPublishResourceRes> queryRtmpPublish(String
        // resourceId, String sid);

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
         *                      UpdateWebRecordingResourceClientReq for details.
         * @return Returns the response UpdateResourceRes. See UpdateResourceRes for
         *         details.
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
         * @return Returns the response StopResourceRes. See StopResourceRes for
         *         details.
         */
        public abstract Mono<StopResourceRes> stop(String cname, String uid, String resourceId, String sid,
                        boolean asyncStop);
}
