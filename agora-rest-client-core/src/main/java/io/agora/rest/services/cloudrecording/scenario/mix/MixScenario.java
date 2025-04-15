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
            AcquireMixRecordingResourceClientReq clientRequest);

    /**
     * @brief Start mix cloud recording.
     * @since v0.4.0
     * @param cname         The name of the channel to be recorded.
     * @param uid           The user ID used by the cloud recording service in the
     *                      RTC channel to identify the recording service in the
     *                      channel.
     * @param resourceId    The resource ID.
     * @param clientRequest The request body. See StartMixRecordingResourceClientReq
     *                      for details.
     * @return Returns the response StartResourceRes. See StartResourceRes for
     *         details.
     */
    public abstract Mono<StartResourceRes> start(String cname, String uid, String resourceId,
            StartMixRecordingResourceClientReq clientRequest);

    /**
     * @brief Query the status of mix cloud recording when the video file format is
     *        hls.
     * @since v0.4.0
     * @param resourceId The resource ID.
     * @param sid        The recording ID, identifying a recording cycle.
     * @return Returns the response QueryMixHLSRecordingResourceRes. See
     *         QueryMixHLSRecordingResourceRes for details.
     */
    public abstract Mono<QueryMixHLSRecordingResourceRes> queryHLS(String resourceId, String sid);

    /**
     * @brief Query the status of mix cloud recording when the video file format is
     *        hls and mp4.
     * @since v0.4.0
     * @param resourceId The resource ID.
     * @param sid        The recording ID, identifying a recording cycle.
     * @return Returns the response QueryMixHLSAndMP4RecordingResourceRes. See
     *         QueryMixHLSAndMP4RecordingResourceRes for details.
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
     *                      UpdateLayoutMixRecordingResourceClientReq for details.
     * @return Returns the response UpdateLayoutResourceRes. See
     *         UpdateLayoutResourceRes for details.
     */
    public abstract Mono<UpdateLayoutResourceRes> updateLayout(String cname, String uid, String resourceId, String sid,
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
     *                      UpdateMixRecordingResourceClientReq for details.
     * @return Returns the response UpdateResourceRes. See UpdateResourceRes for
     *         details.
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
     * @return Returns the response StopResourceRes. See StopResourceRes for
     *         details.
     */
    public abstract Mono<StopResourceRes> stop(String cname, String uid, String resourceId, String sid,
            boolean asyncStop);
}
