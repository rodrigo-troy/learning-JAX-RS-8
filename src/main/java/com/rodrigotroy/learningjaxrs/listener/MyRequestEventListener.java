package com.rodrigotroy.learningjaxrs.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.server.monitoring.RequestEvent;
import org.glassfish.jersey.server.monitoring.RequestEventListener;

import javax.ws.rs.ext.Provider;

/**
 * Created with IntelliJ IDEA.
 * $ Project: learning-JAX-RS
 * User: rodrigotroy
 * Date: 30-11-24
 * Time: 13:21
 */
@Provider
public class MyRequestEventListener implements RequestEventListener {
    private static final Logger LOG = LogManager.getLogger(MyRequestEventListener.class);

    private final Integer requestID;

    public MyRequestEventListener(Integer requestID) {
        this.requestID = requestID;
    }

    @Override
    public void onEvent(RequestEvent requestEvent) {
        LOG.info("[Request {}]: {}",
                 requestID,
                 requestEvent.getType());

    }
}
