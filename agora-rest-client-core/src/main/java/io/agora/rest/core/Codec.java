package io.agora.rest.core;

import io.netty.buffer.ByteBuf;

public interface Codec {

    ByteBuf encode(Object obj);

    <T> T decode(ByteBuf buffer, Class<T> clazz);
}
