package io.agora.rest.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.agora.rest.exception.AgoraJsonException;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonCodec implements Codec {

    private static final Logger logger = LoggerFactory.getLogger(JsonCodec.class);

    private final ObjectMapper objectMapper;

    public JsonCodec() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public ByteBuf encode(Object object) {
        ByteBuf buffer = Unpooled.buffer();
        try {
            byte[] bytes = this.objectMapper.writeValueAsBytes(object);

            if (object != null) {
                logger.debug("request:{}", new String(bytes));
            }
            buffer.writeBytes(bytes);
        } catch (JsonProcessingException e) {
            throw new AgoraJsonException(String.format("could not encode object: %s", e.getMessage()),
                    e);
        }

        return buffer;
    }

    public <T> T decode(ByteBuf buffer, Class<T> tClass) {
        byte[] array;
        final int offset;
        int len = buffer.readableBytes();
        if (buffer.hasArray()) {
            array = buffer.array();
            offset = buffer.arrayOffset() + buffer.readerIndex();
        } else {
            array = ByteBufUtil.getBytes(buffer, buffer.readerIndex(), len, false);
            offset = 0;
        }

        logger.debug("response:{}", new String(array, offset, len));

        try {
            return this.objectMapper.readValue(array, offset, len, tClass);
        } catch (IOException e) {
            throw new AgoraJsonException(
                    String.format("could not decode class %s: %s", tClass.getName(),
                            e.getMessage()),
                    e);
        }
    }
}
