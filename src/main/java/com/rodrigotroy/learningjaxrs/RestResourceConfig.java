package com.rodrigotroy.learningjaxrs;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class RestResourceConfig extends ResourceConfig {
    public RestResourceConfig() {
        packages("com.rodrigotroy.learningjaxrs");
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }

}
