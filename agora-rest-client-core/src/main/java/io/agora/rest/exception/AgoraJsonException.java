package io.agora.rest.exception;

import io.agora.rest.AgoraException;

public class AgoraJsonException extends AgoraException {
    public AgoraJsonException(String message) {
        super(message);
    }

    public AgoraJsonException(String message, Throwable cause) {
        super(message, cause);
    }
}
