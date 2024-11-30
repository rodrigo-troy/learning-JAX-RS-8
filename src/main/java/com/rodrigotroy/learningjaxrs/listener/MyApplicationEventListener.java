package com.rodrigotroy.learningjaxrs.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.server.monitoring.ApplicationEvent;
import org.glassfish.jersey.server.monitoring.ApplicationEventListener;
import org.glassfish.jersey.server.monitoring.RequestEvent;
import org.glassfish.jersey.server.monitoring.RequestEventListener;

import javax.ws.rs.ext.Provider;

/**
 * Created with IntelliJ IDEA.
 * $ Project: learning-JAX-RS
 * User: rodrigotroy
 * Date: 30-11-24
 * Time: 12:56
 */
@Provider
public class MyApplicationEventListener implements ApplicationEventListener {
    private static final Logger LOG = LogManager.getLogger(MyApplicationEventListener.class);

    private Integer requestID = 0;

    @Override
    public void onEvent(ApplicationEvent applicationEvent) {
        LOG.info("Application event: {}",
                 applicationEvent.getType());
    }

    @Override
    public RequestEventListener onRequest(RequestEvent requestEvent) {
        LOG.info("Request event: {}",
                 requestEvent.getType());
        requestID++;

        return new MyRequestEventListener(requestID);
    }
}
