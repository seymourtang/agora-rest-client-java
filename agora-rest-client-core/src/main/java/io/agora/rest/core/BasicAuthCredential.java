package io.agora.rest.core;

import io.netty.handler.codec.http.HttpHeaders;

/**
 * @brief BasicAuthCredential provides basic authentication for agora rest client
 * @since v0.3.0
 */
public class BasicAuthCredential implements Credential {

    private final String username;

    private final String password;

    private final static String name = "BasicAuth";

    /**
     * @param username Customer ID obtained from the Agora console
     * @param password Customer secret obtained from the Agora console
     */
    public BasicAuthCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setAuthorization(HttpHeaders headers) {
        headers.set("Authorization",
                "Basic " + java.util.Base64.getEncoder().encodeToString((username + ":" + password).getBytes()));
    }

    @Override
    public String toString() {
        return "BasicAuthCredential{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
