package io.agora.rest.core;

import io.netty.handler.codec.http.HttpHeaders;

public interface Credential {

    String getName();

    void setAuthorization(HttpHeaders headers);
}
