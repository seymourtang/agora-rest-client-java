package io.agora.rest.services.cloudrecording.scenario.mix.req;

import io.agora.rest.services.cloudrecording.api.req.UpdateLayoutResourceReq;

import java.util.List;

public class UpdateLayoutMixRecordingResourceClientReq {

    private String maxResolutionUID;

    private int mixedVideoLayout;

    private String backgroundColor;

    private String backgroundImage;

    private String defaultUserBackgroundImage;

    private List<UpdateLayoutResourceReq.LayoutConfig> layoutConfig;

    private List<UpdateLayoutResourceReq.BackgroundConfig> backgroundConfig;

    public static Builder builder() {
        return new Builder();
    }

    private UpdateLayoutMixRecordingResourceClientReq(Builder builder) {
        setMaxResolutionUID(builder.maxResolutionUID);
        setMixedVideoLayout(builder.mixedVideoLayout);
        setBackgroundColor(builder.backgroundColor);
        setBackgroundImage(builder.backgroundImage);
        setDefaultUserBackgroundImage(builder.defaultUserBackgroundImage);
        setLayoutConfig(builder.layoutConfig);
        setBackgroundConfig(builder.backgroundConfig);
    }

    public String getMaxResolutionUID() {
        return maxResolutionUID;
    }

    public void setMaxResolutionUID(String maxResolutionUID) {
        this.maxResolutionUID = maxResolutionUID;
    }

    public int getMixedVideoLayout() {
        return mixedVideoLayout;
    }

    public void setMixedVideoLayout(int mixedVideoLayout) {
        this.mixedVideoLayout = mixedVideoLayout;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getDefaultUserBackgroundImage() {
        return defaultUserBackgroundImage;
    }

    public void setDefaultUserBackgroundImage(String defaultUserBackgroundImage) {
        this.defaultUserBackgroundImage = defaultUserBackgroundImage;
    }

    public List<UpdateLayoutResourceReq.LayoutConfig> getLayoutConfig() {
        return layoutConfig;
    }

    public void setLayoutConfig(List<UpdateLayoutResourceReq.LayoutConfig> layoutConfig) {
        this.layoutConfig = layoutConfig;
    }

    public List<UpdateLayoutResourceReq.BackgroundConfig> getBackgroundConfig() {
        return backgroundConfig;
    }

    public void setBackgroundConfig(List<UpdateLayoutResourceReq.BackgroundConfig> backgroundConfig) {
        this.backgroundConfig = backgroundConfig;
    }

    @Override
    public String toString() {
        return "UpdateLayoutMixRecordingResourceClientReq{" +
                "maxResolutionUID='" + maxResolutionUID + '\'' +
                ", mixedVideoLayout=" + mixedVideoLayout +
                ", backgroundColor='" + backgroundColor + '\'' +
                ", backgroundImage='" + backgroundImage + '\'' +
                ", defaultUserBackgroundImage='" + defaultUserBackgroundImage + '\'' +
                ", layoutConfig=" + layoutConfig +
                ", backgroundConfig=" + backgroundConfig +
                '}';
    }

    public static final class Builder {
        private String maxResolutionUID;
        private int mixedVideoLayout;
        private String backgroundColor;
        private String backgroundImage;
        private String defaultUserBackgroundImage;
        private List<UpdateLayoutResourceReq.LayoutConfig> layoutConfig;
        private List<UpdateLayoutResourceReq.BackgroundConfig> backgroundConfig;

        private Builder() {
        }

        public Builder maxResolutionUID(String val) {
            maxResolutionUID = val;
            return this;
        }

        public Builder mixedVideoLayout(int val) {
            mixedVideoLayout = val;
            return this;
        }

        public Builder backgroundColor(String val) {
            backgroundColor = val;
            return this;
        }

        public Builder backgroundImage(String val) {
            backgroundImage = val;
            return this;
        }

        public Builder defaultUserBackgroundImage(String val) {
            defaultUserBackgroundImage = val;
            return this;
        }

        public Builder layoutConfig(List<UpdateLayoutResourceReq.LayoutConfig> val) {
            layoutConfig = val;
            return this;
        }

        public Builder backgroundConfig(List<UpdateLayoutResourceReq.BackgroundConfig> val) {
            backgroundConfig = val;
            return this;
        }

        public UpdateLayoutMixRecordingResourceClientReq build() {
            return new UpdateLayoutMixRecordingResourceClientReq(this);
        }
    }
}
