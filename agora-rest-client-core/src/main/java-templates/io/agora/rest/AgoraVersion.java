package io.agora.rest;

public class AgoraVersion {
    private static final String version = "${project.version}";

    public static String getVersion() {
        return version;
    }
}
