package io.agora.rest.exception;

import io.agora.rest.AgoraException;

public class AgoraNeedRetryException extends AgoraException {
    public AgoraNeedRetryException(String message) {
        super(message);
    }
}
