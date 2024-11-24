package com.rodrigotroy.learningjaxrs.exception;

import com.rodrigotroy.learningjaxrs.domain.OperationResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * $ Project: learning-JAX-RS
 * User: rodrigotroy
 * Date: 24-11-24
 * Time: 17:17
 */
@javax.ws.rs.ext.Provider
public class NullPointerExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<NullPointerException> {
    private static final Logger logger = LogManager.getLogger(NullPointerExceptionMapper.class);

    @Override
    public javax.ws.rs.core.Response toResponse(NullPointerException exception) {
        logger.error("NullPointer exception occurred: ",
                exception);

        OperationResponse operationResponse = OperationResponse.builder()
                .withIsError(true)
                .withMessage(exception.getMessage())
                .build();

        return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.BAD_REQUEST)
                .entity(operationResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
