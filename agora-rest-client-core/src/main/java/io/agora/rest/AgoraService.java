package io.agora.rest;

import io.agora.rest.core.AgoraProperty;
import io.agora.rest.core.Context;
import io.agora.rest.core.DefaultContext;
import io.agora.rest.services.cloudrecording.CloudRecordingApi;

public class AgoraService {

    private final AgoraProperty agoraProperty;

    private final Context context;

    private final CloudRecordingApi cloudRecordingApi;

    public AgoraService(AgoraProperty agoraProperty) {
        this.agoraProperty = agoraProperty;
        this.context = new DefaultContext(agoraProperty);
        this.cloudRecordingApi = new CloudRecordingApi(context);
    }

    public Context context() {
        return context;
    }


    public AgoraProperty getAgoraProperty() {
        return agoraProperty;
    }

    public CloudRecordingApi cloudRecording() {
        return cloudRecordingApi;
    }
}
