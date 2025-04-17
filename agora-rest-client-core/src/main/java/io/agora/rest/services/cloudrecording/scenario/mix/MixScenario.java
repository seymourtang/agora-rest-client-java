package io.agora.rest.services.cloudrecording.scenario.mix;

import io.agora.rest.services.cloudrecording.api.res.*;
import io.agora.rest.services.cloudrecording.scenario.mix.req.AcquireMixRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.mix.req.StartMixRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.mix.req.UpdateLayoutMixRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.mix.req.UpdateMixRecordingResourceClientReq;
import io.agora.rest.services.cloudrecording.scenario.mix.res.QueryMixHLSAndMP4RecordingResourceRes;
import io.agora.rest.services.cloudrecording.scenario.mix.res.QueryMixHLSRecordingResourceRes;
import reactor.core.publisher.Mono;

public abstract class MixScenario {

        /**
         * @brief Get a resource ID for mix cloud recording.
         * @since v0.4.0
         * @post After receiving the resource ID, call the start API to start cloud
         *       recording.
         * @param cname         The name of the channel to be recorded.
         * @param uid           The user ID used by the cloud recording service in the
         *                      RTC channel to identify the recording service in the
         *                      channel.
         * @param clientRequest The request body. See
         *                      {@link AcquireMixRecordingResourceClientReq} for
         *                      details.
         * @return Returns the acquire resource result. See
         *         {@link AcquireResourceRes} for details.
         */
        public abstract Mono<AcquireResourceRes> acquire(String cname, String uid,
                        AcquireMixRecordingResourceClientReq clientRequest);

        /**
         * @brief Start mix cloud recording.
         * @since v0.4.0
         * @param cname         The name of the channel to be recorded.
         * @param uid           The user ID used by the cloud recording service in the
         *                      RTC channel to identify the recording service in the
         *                      channel.
         * @param resourceId    The resource ID.
         * @param clientRequest The request body. See
         *                      {@link StartMixRecordingResourceClientReq} for
         *                      details.
         * @return Returns the start resource result. See
         *         {@link StartResourceRes} for details.
         */
        public abstract Mono<StartResourceRes> start(String cname, String uid, String resourceId,
                        StartMixRecordingResourceClientReq clientRequest);

        /**
         * @brief Query the status of mix cloud recording when the video file format is
         *        hls.
         * @since v0.4.0
         * @param resourceId The resource ID.
         * @param sid        The recording ID, identifying a recording cycle.
         * @return Returns the query mix recording resource result when the video file
         *         format is hls. See {@link QueryMixHLSRecordingResourceRes} for
         *         details.
         */
        public abstract Mono<QueryMixHLSRecordingResourceRes> queryHLS(String resourceId, String sid);

        /**
         * @brief Query the status of mix cloud recording when the video file format is
         *        hls and mp4.
         * @since v0.4.0
         * @param resourceId The resource ID.
         * @param sid        The recording ID, identifying a recording cycle.
         * @return Returns the query mix recording resource result when the video file
         *         format is hls and mp4. See
         *         {@link QueryMixHLSAndMP4RecordingResourceRes} for details.
         */
        public abstract Mono<QueryMixHLSAndMP4RecordingResourceRes> queryHLSAndMP4(String resourceId, String sid);

        /**
         * @brief Update the mix cloud recording layout.
         * @since v0.4.0
         * @param cname         The name of the channel to be recorded.
         * @param uid           The user ID used by the cloud recording service in the
         *                      RTC channel to identify the recording service in the
         *                      channel.
         * @param resourceId    The resource ID.
         * @param sid           The recording ID, identifying a recording cycle.
         * @param clientRequest The request body. See
         *                      {@link UpdateLayoutMixRecordingResourceClientReq} for
         *                      details.
         * @return Returns the update layout resource result. See
         *         {@link UpdateLayoutResourceRes} for details.
         */
        public abstract Mono<UpdateLayoutResourceRes> updateLayout(String cname, String uid, String resourceId,
                        String sid,
                        UpdateLayoutMixRecordingResourceClientReq clientRequest);

        /**
         * @brief Update the mix cloud recording configuration.
         * @since v0.4.0
         * @param cname         The name of the channel to be recorded.
         * @param uid           The user ID used by the cloud recording service in the
         *                      RTC channel to identify the recording service in the
         *                      channel.
         * @param resourceId    The resource ID.
         * @param sid           The recording ID, identifying a recording cycle.
         * @param clientRequest The request body. See
         *                      {@link UpdateMixRecordingResourceClientReq} for
         *                      details.
         * @return Returns the update resource result. See
         *         {@link UpdateResourceRes} for details.
         */
        public abstract Mono<UpdateResourceRes> update(String cname, String uid, String resourceId, String sid,
                        UpdateMixRecordingResourceClientReq clientRequest);

        /**
         * @brief Stop mix cloud recording.
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
