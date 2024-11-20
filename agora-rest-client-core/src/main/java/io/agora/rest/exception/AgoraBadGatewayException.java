package io.agora.rest.exception;

public class AgoraBadGatewayException extends AgoraNeedRetryException {
    public AgoraBadGatewayException(String message) {
        super(message);
    }
}
