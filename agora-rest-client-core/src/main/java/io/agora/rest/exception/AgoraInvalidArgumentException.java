package io.agora.rest.exception;

import io.agora.rest.AgoraException;

public class AgoraInvalidArgumentException extends AgoraException {
    public AgoraInvalidArgumentException(String message) {
        super(message);
    }
}
