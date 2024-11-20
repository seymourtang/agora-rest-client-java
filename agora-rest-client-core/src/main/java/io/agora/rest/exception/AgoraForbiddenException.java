package io.agora.rest.exception;

import io.agora.rest.AgoraException;

public class AgoraForbiddenException extends AgoraException {
    public AgoraForbiddenException(String message) {
        super(message);
    }
}
