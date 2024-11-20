package io.agora.rest.core;

import io.netty.buffer.ByteBuf;
import reactor.netty.http.client.HttpClientResponse;

public interface ErrorMapper {

    void statusCode(HttpClientResponse response);

    void checkError(ByteBuf buf);
}
