package io.agora.rest.exception;

public class AgoraInternalServerErrorException extends AgoraNeedRetryException {
    public AgoraInternalServerErrorException(String message) {
        super(message);
    }
}
