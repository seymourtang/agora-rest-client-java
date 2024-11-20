package io.agora.rest.exception;

import io.agora.rest.AgoraException;

public class AgoraUnauthorizedException extends AgoraException {
    public AgoraUnauthorizedException(String message) {
        super(message);
    }
}
