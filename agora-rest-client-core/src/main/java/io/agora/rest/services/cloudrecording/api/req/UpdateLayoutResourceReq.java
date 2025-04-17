package io.agora.rest.services.cloudrecording.api.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UpdateLayoutResourceReq {

    @JsonProperty("cname")
    private String cname;

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("clientRequest")
    private ClientRequest clientRequest;

    private UpdateLayoutResourceReq(Builder builder) {
        this.cname = builder.cname;
        this.uid = builder.uid;
        this.clientRequest = builder.clientRequest;
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

    public ClientRequest getClientRequest() {
        return clientRequest;
    }

    public void setClientRequest(ClientRequest clientRequest) {
        this.clientRequest = clientRequest;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String cname;

        private String uid;

        private ClientRequest clientRequest;

        private Builder() {
        }

        public Builder cname(String cname) {
            this.cname = cname;
            return this;
        }

        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        public Builder clientRequest(ClientRequest clientRequest) {
            this.clientRequest = clientRequest;
            return this;
        }

        public UpdateLayoutResourceReq build() {
            return new UpdateLayoutResourceReq(this);
        }
    }

    public static class ClientRequest {

        @JsonProperty("maxResolutionUid")
        private String maxResolutionUID;

        @JsonProperty("mixedVideoLayout")
        private int mixedVideoLayout;

        @JsonProperty("backgroundColor")
        private String backgroundColor;

        @JsonProperty("backgroundImage")
        private String backgroundImage;

        @JsonProperty("defaultUserBackgroundImage")
        private String defaultUserBackgroundImage;

        @JsonProperty("layoutConfig")
        private List<LayoutConfig> layoutConfig;

        @JsonProperty("backgroundConfig")
        private List<BackgroundConfig> backgroundConfig;

        private ClientRequest(Builder builder) {
            this.maxResolutionUID = builder.maxResolutionUID;
            this.mixedVideoLayout = builder.mixedVideoLayout;
            this.backgroundColor = builder.backgroundColor;
            this.backgroundImage = builder.backgroundImage;
            this.defaultUserBackgroundImage = builder.defaultUserBackgroundImage;
            this.layoutConfig = builder.layoutConfig;
            this.backgroundConfig = builder.backgroundConfig;
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

        public List<LayoutConfig> getLayoutConfig() {
            return layoutConfig;
        }

        public void setLayoutConfig(List<LayoutConfig> layoutConfig) {
            this.layoutConfig = layoutConfig;
        }

        public List<BackgroundConfig> getBackgroundConfig() {
            return backgroundConfig;
        }

        public void setBackgroundConfig(List<BackgroundConfig> backgroundConfig) {
            this.backgroundConfig = backgroundConfig;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder {

            private String maxResolutionUID;

            private int mixedVideoLayout;

            private String backgroundColor;

            private String backgroundImage;

            private String defaultUserBackgroundImage;

            private List<LayoutConfig> layoutConfig;

            private List<BackgroundConfig> backgroundConfig;

            private Builder() {
            }

            public Builder maxResolutionUID(String maxResolutionUID) {
                this.maxResolutionUID = maxResolutionUID;
                return this;
            }

            public Builder mixedVideoLayout(int mixedVideoLayout) {
                this.mixedVideoLayout = mixedVideoLayout;
                return this;
            }

            public Builder backgroundColor(String backgroundColor) {
                this.backgroundColor = backgroundColor;
                return this;
            }

            public Builder backgroundImage(String backgroundImage) {
                this.backgroundImage = backgroundImage;
                return this;
            }

            public Builder defaultUserBackgroundImage(String defaultUserBackgroundImage) {
                this.defaultUserBackgroundImage = defaultUserBackgroundImage;
                return this;
            }

            public Builder layoutConfig(List<LayoutConfig> layoutConfig) {
                this.layoutConfig = layoutConfig;
                return this;
            }

            public Builder backgroundConfig(List<BackgroundConfig> backgroundConfig) {
                this.backgroundConfig = backgroundConfig;
                return this;
            }

            public ClientRequest build() {
                return new ClientRequest(this);
            }
        }

        @Override
        public String toString() {
            return "ClientRequest{" +
                    "maxResolutionUID='" + maxResolutionUID + '\'' +
                    ", mixedVideoLayout=" + mixedVideoLayout +
                    ", backgroundColor='" + backgroundColor + '\'' +
                    ", backgroundImage='" + backgroundImage + '\'' +
                    ", defaultUserBackgroundImage='" + defaultUserBackgroundImage + '\'' +
                    ", layoutConfig=" + layoutConfig +
                    ", backgroundConfig=" + backgroundConfig +
                    '}';
        }
    }

    /**
     * @brief Configurations of user's video window to be updated.
     * @since v0.4.0
     */
    public static class LayoutConfig {

        /**
         * The content of the string is the UID of the user to be displayed in the area,
         * 32-bit unsigned integer.
         */
        @JsonProperty("uid")
        private String uid;

        /**
         * The relative value of the horizontal coordinate of the upper-left corner of
         * the screen, accurate to six decimal places.
         * <p>
         * Layout from left to right, with 0.0 at the far left and 1.0 at the far right.
         * <p>
         * This field can also be set to the integer 0 or 1.
         * <p>
         * The value range is [0,1].
         */
        @JsonProperty("x_axis")
        private Float xAxis;

        /**
         * The relative value of the vertical coordinate of the upper-left corner of
         * this screen in the screen, accurate to six decimal places.
         * <p>
         * Layout from top to bottom, with 0.0 at the top and 1.0 at the bottom.
         * <p>
         * This field can also be set to the integer 0 or 1.
         * <p>
         * The value range is [0,1].
         */
        @JsonProperty("y_axis")
        private Float yAxis;

        /**
         * The relative value of the width of this screen, accurate to six decimal
         * places.
         * <p>
         * This field can also be set to the integer 0 or 1.
         * <p>
         * The value range is [0,1].
         */
        @JsonProperty("width")
        private Float width;

        /**
         * The relative value of the height of this screen, accurate to six decimal
         * places.
         * <p>
         * This field can also be set to the integer 0 or 1.
         * <p>
         * The value range is [0,1].
         */
        @JsonProperty("height")
        private Float height;

        /**
         * The transparency of the user's video window. Accurate to six decimal places.
         * <p>
         * 0.0 means the user's video window is transparent, and 1.0 indicates that it
         * is completely opaque.
         * <p>
         * The value range is [0,1].
         * <p>
         * The default value is 1.
         */
        @JsonProperty("alpha")
        private Float alpha;

        /**
         * The display mode of users' video windows.
         * <p>
         * The rendering mode can be set to:
         * <p>
         * - 0: Cropped mode.(Default)
         * Prioritize to ensure the screen is filled.
         * The video window size is proportionally scaled until it fills the screen.
         * If the video's length and width differ from the video window,
         * the video stream will be cropped from its edges to fit the window,
         * under the aspect ratio set for the video window.
         * <p>
         * - 1: Fit mode.
         * Prioritize to ensure that all video content is displayed.
         * The video size is scaled proportionally until one side of the video window is
         * aligned with the screen border.
         * If the video scale does not comply with the window size,
         * the video will be scaled to fill the screen while maintaining its aspect
         * ratio.
         * <p>
         * This scaling may result in a black border around the edges of the video.
         */
        @JsonProperty("render_mode")
        private Integer renderMode;

        private LayoutConfig(Builder builder) {
            this.uid = builder.uid;
            this.xAxis = builder.xAxis;
            this.yAxis = builder.yAxis;
            this.width = builder.width;
            this.height = builder.height;
            this.alpha = builder.alpha;
            this.renderMode = builder.renderMode;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public Float getXAxis() {
            return xAxis;
        }

        public void setXAxis(Float xAxis) {
            this.xAxis = xAxis;
        }

        public Float getYAxis() {
            return yAxis;
        }

        public void setYAxis(Float yAxis) {
            this.yAxis = yAxis;
        }

        public Float getWidth() {
            return width;
        }

        public void setWidth(Float width) {
            this.width = width;
        }

        public Float getHeight() {
            return height;
        }

        public void setHeight(Float height) {
            this.height = height;
        }

        public Float getAlpha() {
            return alpha;
        }

        public void setAlpha(Float alpha) {
            this.alpha = alpha;
        }

        public Integer getRenderMode() {
            return renderMode;
        }

        public void setRenderMode(Integer renderMode) {
            this.renderMode = renderMode;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder {

            private String uid;

            private Float xAxis;

            private Float yAxis;

            private Float width;

            private Float height;

            private Float alpha;

            private Integer renderMode;

            private Builder() {
            }

            public Builder uid(String uid) {
                this.uid = uid;
                return this;
            }

            public Builder xAxis(Float xAxis) {
                this.xAxis = xAxis;
                return this;
            }

            public Builder yAxis(Float yAxis) {
                this.yAxis = yAxis;
                return this;
            }

            public Builder width(Float width) {
                this.width = width;
                return this;
            }

            public Builder height(Float height) {
                this.height = height;
                return this;
            }

            public Builder alpha(Float alpha) {
                this.alpha = alpha;
                return this;
            }

            public Builder renderMode(Integer renderMode) {
                this.renderMode = renderMode;
                return this;
            }

            public LayoutConfig build() {
                return new LayoutConfig(this);
            }
        }

        @Override
        public String toString() {
            return "LayoutConfig{" +
                    "uid='" + uid + '\'' +
                    ", xAxis=" + xAxis +
                    ", yAxis=" + yAxis +
                    ", width=" + width +
                    ", height=" + height +
                    ", alpha=" + alpha +
                    ", renderMode=" + renderMode +
                    '}';
        }
    }

    /**
     * @brief Configurations of user's background image to be updated.
     * @since v0.4.0
     */
    public static class BackgroundConfig {

        /**
         * The string content is the UID.(Required)
         */
        @JsonProperty("uid")
        private String uid;

        /**
         * The URL of the user's background image.(Required)
         * <p>
         * After setting the background image, if the user stops sending the video
         * stream for more than 3.5 seconds,
         * the screen will switch to the background image.
         * <p>
         * URL supports the HTTP and HTTPS protocols, and the image formats supported
         * are JPG and BMP.
         * <p>
         * The image size must not exceed 6 MB.
         * <p>
         * The settings will only take effect after the recording service successfully
         * downloads the image;
         * if the download fails, the settings will not take effect.
         * <p>
         * Different field settings may overlap each other.
         */
        @JsonProperty("image_url")
        private String imageURL;

        /**
         * The display mode of users' video windows.(Optional)
         * <p>
         * The value can be set to:
         * <p>
         * - 0: cropped mode.(Default)
         * Prioritize to ensure the screen is filled.
         * The video window size is proportionally scaled until it fills the screen.
         * If the video's length and width differ from the video window,
         * the video stream will be cropped from its edges to fit the window, under the
         * aspect ratio set for the video window.
         * <p>
         * - 1: Fit mode.
         * Prioritize to ensure that all video content is displayed.
         * The video size is scaled proportionally until one side of the video window is
         * aligned with the screen border.
         */
        @JsonProperty("render_mode")
        private Integer renderMode;

        private BackgroundConfig(Builder builder) {
            this.uid = builder.uid;
            this.imageURL = builder.imageURL;
            this.renderMode = builder.renderMode;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getImageURL() {
            return imageURL;
        }

        public void setImageURL(String imageURL) {
            this.imageURL = imageURL;
        }

        public Integer getRenderMode() {
            return renderMode;
        }

        public void setRenderMode(Integer renderMode) {
            this.renderMode = renderMode;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder {

            private String uid;

            private String imageURL;

            private Integer renderMode;

            public Builder uid(String uid) {
                this.uid = uid;
                return this;
            }

            public Builder imageURL(String imageURL) {
                this.imageURL = imageURL;
                return this;
            }

            public Builder renderMode(Integer renderMode) {
                this.renderMode = renderMode;
                return this;
            }

            public BackgroundConfig build() {
                return new BackgroundConfig(this);
            }
        }

        @Override
        public String toString() {
            return "BackgroundConfig{" +
                    "uid='" + uid + '\'' +
                    ", imageURL='" + imageURL + '\'' +
                    ", renderMode=" + renderMode +
                    '}';
        }
    }
}
