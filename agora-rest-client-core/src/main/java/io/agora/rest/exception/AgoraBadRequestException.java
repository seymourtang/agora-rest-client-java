package io.agora.rest.exception;

import io.agora.rest.AgoraException;

public class AgoraBadRequestException extends AgoraException {
    public AgoraBadRequestException(String message) {
        super(message);
    }
}
