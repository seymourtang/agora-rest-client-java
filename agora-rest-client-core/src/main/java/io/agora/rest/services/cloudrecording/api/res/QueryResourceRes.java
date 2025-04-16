package io.agora.rest.services.cloudrecording.api.res;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.agora.rest.exception.AgoraJsonException;
import io.agora.rest.services.cloudrecording.enums.CloudRecordingModeEnum;

import java.util.List;

public class QueryResourceRes {
    /**
     * The name of the channel to be recorded.
     */
    @JsonProperty("cname")
    private String cname;

    /**
     * The user ID used by the cloud recording service in the RTC channel to
     * identify the recording service in the channel.
     */
    @JsonProperty("uid")
    private String uid;

    /**
     * Unique identifier of the resource.
     */
    @JsonProperty("resourceId")
    private String resourceId;

    /**
     * Unique identifier of the recording session.
     */
    private String sid;

    @JsonProperty("serverResponse")
    private JsonNode serverResponse;

    @JsonIgnore
    private ServerResponseType serverResponseType;

    @JsonIgnore
    private QueryIndividualRecordingServerResponse queryIndividualRecordingServerResponse;

    @JsonIgnore
    private QueryIndividualVideoScreenshotServerResponse queryIndividualVideoScreenshotServerResponse;

    @JsonIgnore
    private MixRecordingHLSServerResponse mixRecordingHLSServerResponse;

    @JsonIgnore
    private MixRecordingHLSAndMP4ServerResponse mixRecordingHLSAndMP4ServerResponse;

    @JsonIgnore
    private WebRecordingServerResponse webRecordingServerResponse;

    @JsonIgnore
    private WebRecordingRtmpPublishServerResponse webRecordingRtmpPublishServerResponse;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @JsonIgnore
    public void setServerResponse(CloudRecordingModeEnum mode) throws Exception {
        JsonNode fileListModeNode = this.serverResponse.path("fileListMode");
        this.serverResponseType = ServerResponseType.QUERY_SERVER_RESPONSE_UNKNOWN_TYPE;

        switch (mode) {
            case INDIVIDUAL:
                if (fileListModeNode.isTextual() && "json".equals(fileListModeNode.asText())) {
                    this.serverResponseType = ServerResponseType.QUERY_INDIVIDUAL_RECORDING_SERVER_RESPONSE_TYPE;
                    this.queryIndividualRecordingServerResponse = objectMapper.treeToValue(this.serverResponse,
                            QueryIndividualRecordingServerResponse.class);
                } else {
                    this.serverResponseType = ServerResponseType.QUERY_INDIVIDUAL_VIDEO_SCREENSHOT_SERVER_RESPONSE_TYPE;
                    this.queryIndividualVideoScreenshotServerResponse = objectMapper.treeToValue(this.serverResponse,
                            QueryIndividualVideoScreenshotServerResponse.class);
                }
                break;
            case MIX:
                if (fileListModeNode.isMissingNode()) {
                    break;
                }

                if ("string".equals(fileListModeNode.asText())) {
                    this.serverResponseType = ServerResponseType.QUERY_MIX_RECORDING_HLS_SERVER_RESPONSE_TYPE;
                    this.mixRecordingHLSServerResponse = objectMapper.treeToValue(this.serverResponse,
                            MixRecordingHLSServerResponse.class);
                } else if ("json".equals(fileListModeNode.asText())) {
                    this.serverResponseType = ServerResponseType.QUERY_MIX_RECORDING_HLS_AND_MP4_SERVER_RESPONSE_TYPE;
                    this.mixRecordingHLSAndMP4ServerResponse = objectMapper.treeToValue(this.serverResponse,
                            MixRecordingHLSAndMP4ServerResponse.class);
                } else {
                    throw new AgoraJsonException("unknown fileList mode");
                }
                break;
            case WEB:
                // Check for specific service types in WEB mode
                JsonNode extensionServiceState = this.serverResponse.path("extensionServiceState");

                if (extensionServiceState.isArray() && extensionServiceState.size() > 0) {
                    String serviceName = extensionServiceState.get(0).path("serviceName").asText();

                    switch (serviceName) {
                        case "rtmp_publish_service":
                            this.serverResponseType = ServerResponseType.QUERY_WEB_RECORDING_RTMP_PUBLISH_SERVER_RESPONSE_TYPE;
                            this.webRecordingRtmpPublishServerResponse = objectMapper.treeToValue(this.serverResponse,
                                    WebRecordingRtmpPublishServerResponse.class);
                            break;

                        case "web_recorder_service":
                            this.serverResponseType = ServerResponseType.QUERY_WEB_RECORDING_SERVER_RESPONSE_TYPE;
                            this.webRecordingServerResponse = objectMapper.treeToValue(this.serverResponse,
                                    WebRecordingServerResponse.class);
                            break;

                        default:
                            throw new AgoraJsonException("Unknown service name: " + serviceName);
                    }
                } else {
                    this.serverResponseType = ServerResponseType.QUERY_WEB_RECORDING_SERVER_RESPONSE_TYPE;
                    this.webRecordingServerResponse = objectMapper.treeToValue(this.serverResponse,
                            WebRecordingServerResponse.class);
                }
                break;
        }
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public JsonNode getServerResponse() {
        return serverResponse;
    }

    public void setServerResponse(JsonNode serverResponse) {
        this.serverResponse = serverResponse;
    }

    public ServerResponseType getServerResponseType() {
        return serverResponseType;
    }

    public void setServerResponseType(ServerResponseType serverResponseType) {
        this.serverResponseType = serverResponseType;
    }

    public QueryIndividualRecordingServerResponse getQueryIndividualRecordingServerResponse() {
        return queryIndividualRecordingServerResponse;
    }

    public void setQueryIndividualRecordingServerResponse(
            QueryIndividualRecordingServerResponse queryIndividualRecordingServerResponse) {
        this.queryIndividualRecordingServerResponse = queryIndividualRecordingServerResponse;
    }

    public QueryIndividualVideoScreenshotServerResponse getQueryIndividualVideoScreenshotServerResponse() {
        return queryIndividualVideoScreenshotServerResponse;
    }

    public void setQueryIndividualVideoScreenshotServerResponse(
            QueryIndividualVideoScreenshotServerResponse queryIndividualVideoScreenshotServerResponse) {
        this.queryIndividualVideoScreenshotServerResponse = queryIndividualVideoScreenshotServerResponse;
    }

    public MixRecordingHLSServerResponse getMixRecordingHLSServerResponse() {
        return mixRecordingHLSServerResponse;
    }

    public void setMixRecordingHLSServerResponse(MixRecordingHLSServerResponse mixRecordingHLSServerResponse) {
        this.mixRecordingHLSServerResponse = mixRecordingHLSServerResponse;
    }

    public MixRecordingHLSAndMP4ServerResponse getMixRecordingHLSAndMP4ServerResponse() {
        return mixRecordingHLSAndMP4ServerResponse;
    }

    public void setMixRecordingHLSAndMP4ServerResponse(
            MixRecordingHLSAndMP4ServerResponse mixRecordingHLSAndMP4ServerResponse) {
        this.mixRecordingHLSAndMP4ServerResponse = mixRecordingHLSAndMP4ServerResponse;
    }

    public WebRecordingServerResponse getWebRecordingServerResponse() {
        return webRecordingServerResponse;
    }

    public void setWebRecordingServerResponse(WebRecordingServerResponse webRecordingServerResponse) {
        this.webRecordingServerResponse = webRecordingServerResponse;
    }

    public WebRecordingRtmpPublishServerResponse getWebRecordingRtmpPublishServerResponse() {
        return webRecordingRtmpPublishServerResponse;
    }

    public void setWebRecordingRtmpPublishServerResponse(
            WebRecordingRtmpPublishServerResponse webRecordingRtmpPublishServerResponse) {
        this.webRecordingRtmpPublishServerResponse = webRecordingRtmpPublishServerResponse;
    }

    @Override
    public String toString() {
        return "QueryResourceRes{" +
                "webRecordingServerResponse=" + webRecordingServerResponse +
                ", mixRecordingHLSAndMP4ServerResponse=" + mixRecordingHLSAndMP4ServerResponse +
                ", mixRecordingHLSServerResponse=" + mixRecordingHLSServerResponse +
                ", queryIndividualVideoScreenshotServerResponse=" + queryIndividualVideoScreenshotServerResponse +
                ", queryIndividualRecordingServerResponse=" + queryIndividualRecordingServerResponse +
                ", serverResponseType=" + serverResponseType +
                ", serverResponse=" + serverResponse +
                ", sid='" + sid + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", uid='" + uid + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }

    public enum ServerResponseType {
        QUERY_SERVER_RESPONSE_UNKNOWN_TYPE,
        QUERY_INDIVIDUAL_RECORDING_SERVER_RESPONSE_TYPE,
        QUERY_INDIVIDUAL_VIDEO_SCREENSHOT_SERVER_RESPONSE_TYPE,
        QUERY_MIX_RECORDING_HLS_SERVER_RESPONSE_TYPE,
        QUERY_MIX_RECORDING_HLS_AND_MP4_SERVER_RESPONSE_TYPE,
        QUERY_WEB_RECORDING_SERVER_RESPONSE_TYPE,
        QUERY_WEB_RECORDING_RTMP_PUBLISH_SERVER_RESPONSE_TYPE
    }

    /**
     * @brief Server response returned by the individual recording Query API.
     * @since v0.4.0
     */
    public static class QueryIndividualRecordingServerResponse {
        /**
         * Current status of the cloud service:
         * <p>
         * - 0: Cloud service has not started.
         * <p>
         * - 1: The cloud service initialization is complete.
         * <p>
         * - 2: The cloud service components are starting.
         * <p>
         * - 3: Some cloud service components are ready.
         * <p>
         * - 4: All cloud service components are ready.
         * <p>
         * - 5: The cloud service is in progress.
         * <p>
         * - 6: The cloud service receives the request to stop.
         * <p>
         * - 7: All components of the cloud service stop.
         * <p>
         * - 8: The cloud service exits.
         * <p>
         * - 20: The cloud service exits abnormally.
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * The data format of the fileList field:
         * <p>
         * - "string": fileList is of String type. In composite recording mode,
         * if avFileType is set to ["hls"], fileListMode is "string".
         * <p>
         * - "json": fileList is a JSON Array. When avFileType is set to ["hls","mp4"]
         * in the individual or composite recording mode, fileListMode is set to "json".
         */
        @JsonProperty("fileListMode")
        private String fileListMode;

        /*
         * The file list.
         */
        @JsonProperty("fileList")
        private List<FileDetail> fileList;

        /**
         * The recording start time of the file, the Unix timestamp, in seconds.
         */
        @JsonProperty("sliceStartTime")
        private Long sliceStartTime;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getFileListMode() {
            return fileListMode;
        }

        public void setFileListMode(String fileListMode) {
            this.fileListMode = fileListMode;
        }

        public List<FileDetail> getFileList() {
            return fileList;
        }

        public void setFileList(List<FileDetail> fileList) {
            this.fileList = fileList;
        }

        public Long getSliceStartTime() {
            return sliceStartTime;
        }

        public void setSliceStartTime(Long sliceStartTime) {
            this.sliceStartTime = sliceStartTime;
        }

        @Override
        public String toString() {
            return "QueryIndividualRecordingServerResponse{" +
                    "status=" + status +
                    ", fileListMode='" + fileListMode + '\'' +
                    ", fileList=" + fileList +
                    ", sliceStartTime=" + sliceStartTime +
                    '}';
        }

        public static class FileDetail {
            /**
             * The file names of the M3U8 and MP4 files generated during recording.
             */
            @JsonProperty("fileName")
            private String fileName;

            /**
             * The recording file type.
             * <p>
             * - "audio": Audio-only files.
             * <p>
             * - "video": Video-only files.
             * <p>
             * - "audio_and_video": audio and video files
             */
            @JsonProperty("trackType")
            private String trackType;

            /**
             * User UID, indicating which user's audio or video stream is being recorded.
             * <p>
             * In composite recording mode, the uid is "0".
             */
            @JsonProperty("uid")
            private String uid;

            /**
             * Whether the users were recorded separately.
             * <p>
             * - true: All users are recorded in a single file.
             * <p>
             * - false: Each user is recorded separately.
             */
            @JsonProperty("mixedAllUser")
            private Boolean mixedAllUser;

            /**
             * Whether or not can be played online.
             * <p>
             * - true: The file can be played online.
             * <p>
             * - false: The file cannot be played online.
             */
            @JsonProperty("isPlayable")
            private Boolean isPlayable;

            /**
             * The recording start time of the file, the Unix timestamp, in seconds.
             */
            @JsonProperty("sliceStartTime")
            private Long sliceStartTime;

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public String getTrackType() {
                return trackType;
            }

            public void setTrackType(String trackType) {
                this.trackType = trackType;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public Boolean getMixedAllUser() {
                return mixedAllUser;
            }

            public void setMixedAllUser(Boolean mixedAllUser) {
                this.mixedAllUser = mixedAllUser;
            }

            public Boolean getPlayable() {
                return isPlayable;
            }

            public void setPlayable(Boolean playable) {
                isPlayable = playable;
            }

            public Long getSliceStartTime() {
                return sliceStartTime;
            }

            public void setSliceStartTime(Long sliceStartTime) {
                this.sliceStartTime = sliceStartTime;
            }

            @Override
            public String toString() {
                return "FileDetail{" +
                        "fileName='" + fileName + '\'' +
                        ", trackType='" + trackType + '\'' +
                        ", uid='" + uid + '\'' +
                        ", mixedAllUser=" + mixedAllUser +
                        ", isPlayable=" + isPlayable +
                        ", sliceStartTime=" + sliceStartTime +
                        '}';
            }
        }
    }

    /**
     * @brief Server response returned by the individual recording
     *        QueryVideoScreenshot API.
     * @since v0.4.0
     */
    public static class QueryIndividualVideoScreenshotServerResponse {
        /**
         * Current status of the cloud service:
         * <p>
         * - 0: Cloud service has not started.
         * <p>
         * - 1: The cloud service initialization is complete.
         * <p>
         * - 2: The cloud service components are starting.
         * <p>
         * - 3: Some cloud service components are ready.
         * <p>
         * - 4: All cloud service components are ready.
         * <p>
         * - 5: The cloud service is in progress.
         * <p>
         * - 6: The cloud service receives the request to stop.
         * <p>
         * - 7: All components of the cloud service stop.
         * <p>
         * - 8: The cloud service exits.
         * <p>
         * - 20: The cloud service exits abnormally.
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * The recording start time of the file, the Unix timestamp, in seconds.
         */
        @JsonProperty("sliceStartTime")
        private Long sliceStartTime;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Long getSliceStartTime() {
            return sliceStartTime;
        }

        public void setSliceStartTime(Long sliceStartTime) {
            this.sliceStartTime = sliceStartTime;
        }

        @Override
        public String toString() {
            return "QueryIndividualVideoScreenshotServerResponse{" +
                    "status=" + status +
                    ", sliceStartTime=" + sliceStartTime +
                    '}';
        }
    }

    /**
     * @brief Server response returned by the mix recording QueryHLS API.
     * @since v0.4.0
     */
    public static class MixRecordingHLSServerResponse {
        /**
         * Current status of the cloud service:
         * <p>
         * - 0: Cloud service has not started.
         * <p>
         * - 1: The cloud service initialization is complete.
         * <p>
         * - 2: The cloud service components are starting.
         * <p>
         * - 3: Some cloud service components are ready.
         * <p>
         * - 4: All cloud service components are ready.
         * <p>
         * - 5: The cloud service is in progress.
         * <p>
         * - 6: The cloud service receives the request to stop.
         * <p>
         * - 7: All components of the cloud service stop.
         * <p>
         * - 8: The cloud service exits.
         * <p>
         * - 20: The cloud service exits abnormally.
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * The data format of the fileList field:
         * <p>
         * - "string": fileList is of String type. In composite recording mode,
         * if avFileType is set to ["hls"], fileListMode is "string".
         * <p>
         * - "json": fileList is a JSON Array. When avFileType is set to ["hls","mp4"]
         * in the individual or composite recording mode, fileListMode is set to "json".
         */
        @JsonProperty("fileListMode")
        private String fileListMode;

        /*
         * The file list.
         */
        @JsonProperty("fileList")
        private String fileList;

        /**
         * The recording start time of the file, the Unix timestamp, in seconds.
         */
        @JsonProperty("sliceStartTime")
        private Long sliceStartTime;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getFileListMode() {
            return fileListMode;
        }

        public void setFileListMode(String fileListMode) {
            this.fileListMode = fileListMode;
        }

        public String getFileList() {
            return fileList;
        }

        public void setFileList(String fileList) {
            this.fileList = fileList;
        }

        public Long getSliceStartTime() {
            return sliceStartTime;
        }

        public void setSliceStartTime(Long sliceStartTime) {
            this.sliceStartTime = sliceStartTime;
        }

        @Override
        public String toString() {
            return "MixRecordingHLSServerResponse{" +
                    "status=" + status +
                    ", fileListMode='" + fileListMode + '\'' +
                    ", fileList='" + fileList + '\'' +
                    ", sliceStartTime=" + sliceStartTime +
                    '}';
        }
    }

    /**
     * @brief Server response returned by the mix recording QueryHLSAndMP4 API.
     * @since v0.4.0
     */
    public static class MixRecordingHLSAndMP4ServerResponse {
        /**
         * Current status of the cloud service:
         * <p>
         * - 0: Cloud service has not started.
         * <p>
         * - 1: The cloud service initialization is complete.
         * <p>
         * - 2: The cloud service components are starting.
         * <p>
         * - 3: Some cloud service components are ready.
         * <p>
         * - 4: All cloud service components are ready.
         * <p>
         * - 5: The cloud service is in progress.
         * <p>
         * - 6: The cloud service receives the request to stop.
         * <p>
         * - 7: All components of the cloud service stop.
         * <p>
         * - 8: The cloud service exits.
         * <p>
         * - 20: The cloud service exits abnormally.
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * The data format of the fileList field:
         * <p>
         * - "string": fileList is of String type. In composite recording mode,
         * if avFileType is set to ["hls"], fileListMode is "string".
         * <p>
         * - "json": fileList is a JSON Array. When avFileType is set to ["hls","mp4"]
         * in the individual or composite recording mode, fileListMode is set to "json".
         */
        @JsonProperty("fileListMode")
        private String fileListMode;

        /*
         * The file list.
         */
        @JsonProperty("fileList")
        private List<FileDetail> fileList;

        @JsonProperty("sliceStartTime")
        private Long sliceStartTime;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getFileListMode() {
            return fileListMode;
        }

        public void setFileListMode(String fileListMode) {
            this.fileListMode = fileListMode;
        }

        public List<FileDetail> getFileList() {
            return fileList;
        }

        public void setFileList(List<FileDetail> fileList) {
            this.fileList = fileList;
        }

        public Long getSliceStartTime() {
            return sliceStartTime;
        }

        public void setSliceStartTime(Long sliceStartTime) {
            this.sliceStartTime = sliceStartTime;
        }

        @Override
        public String toString() {
            return "MixRecordingHLSAndMP4ServerResponse{" +
                    "status=" + status +
                    ", fileListMode='" + fileListMode + '\'' +
                    ", fileList=" + fileList +
                    ", sliceStartTime=" + sliceStartTime +
                    '}';
        }

        public static class FileDetail {
            @JsonProperty("fileName")
            private String fileName;

            @JsonProperty("trackType")
            private String trackType;

            @JsonProperty("uid")
            private String uid;

            @JsonProperty("mixedAllUser")
            private Boolean mixedAllUser;

            @JsonProperty("isPlayable")
            private Boolean isPlayable;

            @JsonProperty("sliceStartTime")
            private Long sliceStartTime;

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public String getTrackType() {
                return trackType;
            }

            public void setTrackType(String trackType) {
                this.trackType = trackType;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public Boolean getMixedAllUser() {
                return mixedAllUser;
            }

            public void setMixedAllUser(Boolean mixedAllUser) {
                this.mixedAllUser = mixedAllUser;
            }

            public Boolean getPlayable() {
                return isPlayable;
            }

            public void setPlayable(Boolean playable) {
                isPlayable = playable;
            }

            public Long getSliceStartTime() {
                return sliceStartTime;
            }

            public void setSliceStartTime(Long sliceStartTime) {
                this.sliceStartTime = sliceStartTime;
            }

            @Override
            public String toString() {
                return "FileDetail{" +
                        "fileName='" + fileName + '\'' +
                        ", trackType='" + trackType + '\'' +
                        ", uid='" + uid + '\'' +
                        ", mixedAllUser=" + mixedAllUser +
                        ", isPlayable=" + isPlayable +
                        ", sliceStartTime=" + sliceStartTime +
                        '}';
            }
        }
    }

    /**
     * @brief Server response returned by the web recording Query API.
     * @since v0.4.0
     */
    public static class WebRecordingServerResponse {
        /**
         * Current status of the cloud service:
         * <p>
         * - 0: Cloud service has not started.
         * <p>
         * - 1: The cloud service initialization is complete.
         * <p>
         * - 2: The cloud service components are starting.
         * <p>
         * - 3: Some cloud service components are ready.
         * <p>
         * - 4: All cloud service components are ready.
         * <p>
         * - 5: The cloud service is in progress.
         * <p>
         * - 6: The cloud service receives the request to stop.
         * <p>
         * - 7: All components of the cloud service stop.
         * <p>
         * - 8: The cloud service exits.
         * <p>
         * - 20: The cloud service exits abnormally.
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * The extension service state.
         */
        @JsonProperty("extensionServiceState")
        private List<ExtensionServiceState> extensionServiceState;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public List<ExtensionServiceState> getExtensionServiceState() {
            return extensionServiceState;
        }

        public void setExtensionServiceState(List<ExtensionServiceState> extensionServiceState) {
            this.extensionServiceState = extensionServiceState;
        }

        @Override
        public String toString() {
            return "WebRecordingServerResponse{" +
                    "status=" + status +
                    ", extensionServiceState=" + extensionServiceState +
                    '}';
        }

        /**
         * @brief The extension service state.
         * @since v0.4.0
         */
        public static class ExtensionServiceState {
            /**
             * Extension service payload
             */
            @JsonProperty("payload")
            private Payload payload;

            /**
             * Name of the extended service:
             * <p>
             * - "web_recorder_service": Represents the extended service is web page
             * recording.
             * <p>
             * - "rtmp_publish_service": Represents the extended service is to push web page
             * recording to the CDN.
             */
            @JsonProperty("serviceName")
            private String serviceName;

            @Override
            public String toString() {
                return "ExtensionServiceState{" +
                        "payload=" + payload +
                        ", serviceName='" + serviceName + '\'' +
                        '}';
            }

            /**
             * @brief Extended service payload.
             * @since v0.4.0
             */
            public static class Payload {
                /**
                 * The file list.
                 */
                @JsonProperty("fileList")
                private List<FileDetail> fileList;

                /**
                 * Whether the page recording is in pause state:
                 * <p>
                 * - true: In pause state.
                 * <p>
                 * - false: The page recording is running.
                 */
                @JsonProperty("onhold")
                private Boolean onhold;

                /**
                 * The status of uploading subscription content to the extension service:
                 * <p>
                 * - "init": The service is initializing.
                 * <p>
                 * - "inProgress": The service has started and is currently in progress.
                 * <p>
                 * - "exit": Service exits.
                 */
                @JsonProperty("state")
                private String state;

                public void setFileList(List<FileDetail> fileList) {
                    this.fileList = fileList;
                }

                public Boolean getOnhold() {
                    return onhold;
                }

                public void setOnhold(Boolean onhold) {
                    this.onhold = onhold;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                @Override
                public String toString() {
                    return "Payload{" +
                            "fileList=" + fileList +
                            ", onhold=" + onhold +
                            ", state='" + state + '\'' +
                            '}';
                }

                /**
                 * @brief The file detail.
                 * @since v0.4.0
                 */
                public static class FileDetail {
                    /**
                     * The file name.
                     */
                    @JsonProperty("filename")
                    private String filename;

                    /**
                     * The recording start time of the file, the Unix timestamp, in seconds.
                     */
                    @JsonProperty("sliceStartTime")
                    private Long sliceStartTime;

                    public String getFilename() {
                        return filename;
                    }

                    public void setFilename(String filename) {
                        this.filename = filename;
                    }

                    public Long getSliceStartTime() {
                        return sliceStartTime;
                    }

                    public void setSliceStartTime(Long sliceStartTime) {
                        this.sliceStartTime = sliceStartTime;
                    }

                    @Override
                    public String toString() {
                        return "FileDetail{" +
                                "filename='" + filename + '\'' +
                                ", sliceStartTime=" + sliceStartTime +
                                '}';
                    }
                }

            }
        }
    }

    /**
     * @brief Server response returned by the web recording Query API.
     * @since v0.4.0
     */
    public static class WebRecordingRtmpPublishServerResponse {
        /**
         * Current status of the cloud service:
         * <p>
         * - 0: Cloud service has not started.
         * <p>
         * - 1: The cloud service initialization is complete.
         * <p>
         * - 2: The cloud service components are starting.
         * <p>
         * - 3: Some cloud service components are ready.
         * <p>
         * - 4: All cloud service components are ready.
         * <p>
         * - 5: The cloud service is in progress.
         * <p>
         * - 6: The cloud service receives the request to stop.
         * <p>
         * - 7: All components of the cloud service stop.
         * <p>
         * - 8: The cloud service exits.
         * <p>
         * - 20: The cloud service exits abnormally.
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * The extension service state.
         */
        @JsonProperty("extensionServiceState")
        private List<ExtensionServiceState> extensionServiceState;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public List<ExtensionServiceState> getExtensionServiceState() {
            return extensionServiceState;
        }

        public void setExtensionServiceState(List<ExtensionServiceState> extensionServiceState) {
            this.extensionServiceState = extensionServiceState;
        }

        @Override
        public String toString() {
            return "WebRecordingServerResponse{" +
                    "status=" + status +
                    ", extensionServiceState=" + extensionServiceState +
                    '}';
        }

        /**
         * @brief The extension service state.
         * @since v0.4.0
         */
        public static class ExtensionServiceState {
            /**
             * Extension service payload
             */
            @JsonProperty("payload")
            private Payload payload;

            /**
             * Name of the extended service:
             * <p>
             * - "web_recorder_service": Represents the extended service is web page
             * recording.
             * <p>
             * - "rtmp_publish_service": Represents the extended service is to push web page
             * recording to the CDN.
             */
            @JsonProperty("serviceName")
            private String serviceName;

            @Override
            public String toString() {
                return "ExtensionServiceState{" +
                        "payload=" + payload +
                        ", serviceName='" + serviceName + '\'' +
                        '}';
            }

            /**
             * @brief Extended service payload.
             * @since v0.4.0
             */
            public static class Payload {

                /**
                 * The status of uploading subscription content to the extension service:
                 * <p>
                 * - "init": The service is initializing.
                 * <p>
                 * - "inProgress": The service has started and is currently in progress.
                 * <p>
                 * - "exit": Service exits.
                 */
                @JsonProperty("state")
                private String state;

                /**
                 * The status of the push stream to the CDN.
                 */
                @JsonProperty("outputs")
                private List<Output> outputs;

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public List<Output> getOutputs() {
                    return outputs;
                }

                public void setOutputs(List<Output> outputs) {
                    this.outputs = outputs;
                }

                @Override
                public String toString() {
                    return "Payload{" +
                            "state='" + state + '\'' +
                            ", outputs=" + outputs +
                            '}';
                }

                /**
                 * @brief The file detail.
                 * @since v0.4.0
                 */
                public static class FileDetail {
                    /**
                     * The file name.
                     */
                    @JsonProperty("filename")
                    private String filename;

                    /**
                     * The recording start time of the file, the Unix timestamp, in seconds.
                     */
                    @JsonProperty("sliceStartTime")
                    private Long sliceStartTime;

                    public String getFilename() {
                        return filename;
                    }

                    public void setFilename(String filename) {
                        this.filename = filename;
                    }

                    public Long getSliceStartTime() {
                        return sliceStartTime;
                    }

                    public void setSliceStartTime(Long sliceStartTime) {
                        this.sliceStartTime = sliceStartTime;
                    }

                    @Override
                    public String toString() {
                        return "FileDetail{" +
                                "filename='" + filename + '\'' +
                                ", sliceStartTime=" + sliceStartTime +
                                '}';
                    }
                }

                /**
                 * @brief The push stream to the CDN output.
                 * @since v0.4.0
                 */
                public static class Output {
                    /**
                     * The CDN address to which you push the stream.
                     */
                    @JsonProperty("rtmpUrl")
                    private String rtmpUrl;

                    /**
                     * The current status of stream pushing of the web page recording:
                     * <p>
                     * - "connecting": Connecting to the CDN server.
                     * <p>
                     * - "publishing": The stream pushing is going on.
                     * <p>
                     * - "onhold": Set whether to pause the stream pushing.
                     * <p>
                     * - "disconnected": Failed to connect to the CDN server. Agora recommends
                     * that you change the CDN address to push the stream.
                     */
                    @JsonProperty("status")
                    private String status;

                    public String getRtmpUrl() {
                        return rtmpUrl;
                    }

                    public void setRtmpUrl(String rtmpUrl) {
                        this.rtmpUrl = rtmpUrl;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    @Override
                    public String toString() {
                        return "Output{" +
                                "rtmpUrl='" + rtmpUrl + '\'' +
                                ", status='" + status + '\'' +
                                '}';
                    }
                }
            }
        }
    }
}