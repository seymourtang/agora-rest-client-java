package io.agora.rest;

public class AgoraException extends RuntimeException {

    private Integer errCode;

    public AgoraException(String message) {
        super(message);
    }

    public AgoraException(String message, Throwable cause) {
        super(message, cause);
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }
}
