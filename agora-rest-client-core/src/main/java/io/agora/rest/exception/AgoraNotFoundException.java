package io.agora.rest.exception;

import io.agora.rest.AgoraException;

public class AgoraNotFoundException extends AgoraException {
    public AgoraNotFoundException(String message) {
        super(message);
    }
}
