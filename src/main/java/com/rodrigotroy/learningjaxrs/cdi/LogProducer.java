package com.rodrigotroy.learningjaxrs.cdi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * $ Project: bci_ffmm_apv
 * User: rodrigotroy
 * Date: 29-12-15
 * Time: 10:08
 */
public class LogProducer implements Serializable {
    @Produces
    @Dependent
    public Logger createLogger(InjectionPoint injectionPoint) {
        return LogManager.getLogger(injectionPoint.getBean().getBeanClass());
    }
}
