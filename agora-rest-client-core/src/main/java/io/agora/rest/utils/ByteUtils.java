package io.agora.rest.utils;

import io.netty.buffer.ByteBuf;

public class ByteUtils {

    public static byte[] toByteArray(ByteBuf buf) {
        byte[] bytes = new byte[buf.readableBytes()];
        buf.getBytes(buf.readerIndex(), bytes);
        return bytes;
    }
}
