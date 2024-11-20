package io.agora.rest.exception;

import io.agora.rest.AgoraException;

public class AgoraUnknownException extends AgoraException {
    public AgoraUnknownException(String message) {
        super(message);
    }
}
