package com.rodrigotroy.learningjaxrs;

import io.swagger.v3.jaxrs2.integration.resources.AcceptHeaderOpenApiResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class RestResourceConfig extends ResourceConfig {
    private static final Logger logger = LogManager.getLogger(RestResourceConfig.class);

    private static final String PACKAGE = "com.rodrigotroy.learningjaxrs";

    public RestResourceConfig() {
        logger.info("Initializing Jersey application");

        packages(PACKAGE);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE,
                 true);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK,
                 true);

        register(OpenApiResource.class);
        register(AcceptHeaderOpenApiResource.class);
    }
}
