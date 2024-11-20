package io.agora.rest.exception;

import io.agora.rest.AgoraException;

public class AgoraTooManyRequestException extends AgoraException {
    public AgoraTooManyRequestException(String message) {
        super(message);
    }
}
