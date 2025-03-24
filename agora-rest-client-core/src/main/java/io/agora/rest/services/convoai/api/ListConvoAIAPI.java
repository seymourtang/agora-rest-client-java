package io.agora.rest.services.convoai.api;

import io.agora.rest.core.Context;
import io.agora.rest.services.convoai.req.ListConvoAIReq;
import io.agora.rest.services.convoai.res.ListConvoAIRes;
import io.netty.handler.codec.http.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class ListConvoAIAPI {

    private static final Logger logger = LoggerFactory.getLogger(ListConvoAIAPI.class);

    private final Context context;

    private final String pathPrefix;

    public ListConvoAIAPI(Context context, String pathPrefix) {
        this.context = context;
        this.pathPrefix = pathPrefix;
    }

    public Mono<ListConvoAIRes> handle(ListConvoAIReq request) {
        StringBuilder path = new StringBuilder(String.format("%s/agents",
                pathPrefix));

        if (request != null && request.toQueryString() != null) {
            path.append(String.format("?%s", request.toQueryString()));
        }

        logger.info("path:{}", path);

        return this.context.sendRequest(path.toString(), HttpMethod.GET, null, ListConvoAIRes.class);
    }
}
