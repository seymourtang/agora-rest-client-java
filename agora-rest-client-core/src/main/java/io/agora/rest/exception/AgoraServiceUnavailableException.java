package io.agora.rest.exception;

public class AgoraServiceUnavailableException extends AgoraNeedRetryException {
    public AgoraServiceUnavailableException(String message) {
        super(message);
    }
}
