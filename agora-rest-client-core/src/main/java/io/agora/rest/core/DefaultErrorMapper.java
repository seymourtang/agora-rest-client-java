package io.agora.rest.core;

import io.agora.rest.AgoraException;
import io.agora.rest.exception.*;
import io.agora.rest.utils.ByteUtils;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.netty.http.client.HttpClientResponse;

public class DefaultErrorMapper implements ErrorMapper {

    private static final Logger logger = LoggerFactory.getLogger(DefaultErrorMapper.class);

    private HttpClientResponse response;

    private int statusCode;

    public DefaultErrorMapper() {
    }

    @Override
    public void statusCode(HttpClientResponse response) {
        this.statusCode = response.status().code();
        this.response = response;

    }

    @Override
    public void checkError(ByteBuf buf) {
        if (this.statusCode >= 400) {
            throw convertException(this.response, buf);
        }
    }

    public AgoraException convertException(HttpClientResponse response, ByteBuf buf) {
        HttpResponseStatus status = response.status();

        byte[] body = ByteUtils.toByteArray(buf);
        String reason = String.format("%s %s -> %d %s,body:%s", response.method(), response.uri(), status.code(),
                status.reasonPhrase(), new String(body));
        logger.info("reason:{}", reason);

        AgoraException exception = new AgoraUnknownException(reason);
        switch (statusCode) {
            case 400:
            case 405:
            case 406:
            case 415:
                exception = new AgoraBadRequestException(reason);
                break;
            case 401:
                exception = new AgoraUnauthorizedException(reason);
                break;
            case 403:
                exception = new AgoraForbiddenException(reason);
                break;
            case 404:
                exception = new AgoraNotFoundException(reason);
                break;
            case 429:
                exception = new AgoraTooManyRequestException(reason);
                break;
            case 500:
                exception = new AgoraInternalServerErrorException(reason);
                break;
            case 502:
                exception = new AgoraBadGatewayException(reason);
                break;
            case 503:
                exception = new AgoraServiceUnavailableException(reason);
                break;
            case 504:
                exception = new AgoraGatewayTimeoutException(reason);
        }

        exception.setErrCode(this.statusCode);

        return exception;
    }
}
