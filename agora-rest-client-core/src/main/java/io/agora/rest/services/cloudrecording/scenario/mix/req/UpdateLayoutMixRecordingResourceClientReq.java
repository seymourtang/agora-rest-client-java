package io.agora.rest.services.cloudrecording.scenario.mix.req;

import io.agora.rest.services.cloudrecording.api.req.UpdateLayoutResourceReq;

import java.util.List;

/**
 * @brief Client request for updating the layout of mix recording.
 * @since v0.4.0
 */
public class UpdateLayoutMixRecordingResourceClientReq {

    /**
     * Only need to set it in vertical layout.(Optional)
     * 
     * Specify the user ID of the large video window.
     */
    private String maxResolutionUID;

    /**
     * Composite video layout.(Optional)
     * 
     * The value can be set to:
     * 
     *  - 0: (Default) Floating layout.
     *     The first user to join the channel will be displayed as a large window, filling the entire canvas.
     *     The video windows of other users will be displayed as small windows, arranged horizontally from bottom to top, up to 4 rows, each with 4 windows.
     *     It supports up to a total of 17 windows of different users' videos.
     *  - 1: Adaptive layout.
     *     Automatically adjust the size of each user's video window according to the number of users, each user's video window size is consistent, and supports up to 17 windows.
     *  - 2: Vertical layout.
     *     The maxResolutionUid is specified to display the large video window on the left side of the screen, and the small video windows of other users are vertically arranged on the right side, with a maximum of two columns, 8 windows per column, supporting up to 17 windows.
     *  - 3: Customized layout.
     *     Set the layoutConfig field to customize the mixed layout.
     */
    private int mixedVideoLayout;

    /**
     * The background color of the video canvas.(Optional)
     * 
     * The RGB color table is supported, with strings formatted as a # sign and 6 hexadecimal digits.
     * 
     * The default value is "#000000", representing the black color.
     */
    private String backgroundColor;

    /**
     * The background image of the video canvas.(Optional)
     * 
     * The display mode of the background image is set to cropped mode.
     * 
     * Cropped mode: Will prioritize to ensure that the screen is filled.
     * The background image size is scaled in equal proportion until the entire screen is filled with the background image.
     * If the length and width of the background image differ from the video window,
     * the background image will be peripherally cropped to fill the window.
     */
    private String backgroundImage;

    /**
     * The URL of the default user screen background image.(Optional)
     * 
     * After configuring this field, when any user stops sending the video streams for more than 3.5 seconds,
     * the screen will switch to the background image;
     * this setting will be overridden if the background image is set separately for a UID.
     */
    private String defaultUserBackgroundImage;

    /**
     * The mixed video layout of users.(Optional)
     * 
     * An array of screen layout settings for each user, supporting up to 17 users.
     */
    private List<UpdateLayoutResourceReq.LayoutConfig> layoutConfig;

    /**
     * The background configuration.(Optional)
     * 
     * The backgroundConfig field is used to set the background of the video windows.
     */
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
