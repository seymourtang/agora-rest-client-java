package io.agora.rest.exception;

public class AgoraGatewayTimeoutException extends AgoraNeedRetryException {
    public AgoraGatewayTimeoutException(String message) {
        super(message);
    }
}
