package io.agora.rest.services.cloudrecording.enums;

public enum CloudRecordingModeEnum {
    INDIVIDUAL("individual"),
    MIX("mix"),
    WEB("web");

    private final String mode;

    CloudRecordingModeEnum(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}
