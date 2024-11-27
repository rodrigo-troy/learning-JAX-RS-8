package com.rodrigotroy.learningjaxrs;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class RestResourceConfig extends ResourceConfig {
    private static final String PACKAGE = "com.rodrigotroy.learningjaxrs";

    public RestResourceConfig() {
        packages(PACKAGE);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE,
                 true);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK,
                 true);
    }
}
