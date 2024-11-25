package com.rodrigotroy.learningjaxrs.exception;

import com.rodrigotroy.learningjaxrs.domain.OperationResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * $ Project: learning-JAX-RS
 * User: rodrigotroy
 * Date: 24-11-24
 * Time: 19:33
 */
@javax.ws.rs.ext.Provider
public class ConstraintViolationExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<ConstraintViolationException> {
    private static final Logger logger = LogManager.getLogger(ConstraintViolationExceptionMapper.class);

    @Override
    public javax.ws.rs.core.Response toResponse(ConstraintViolationException exception) {
        logger.error("ConstraintViolation exception occurred: ",
                exception);


        String errorMessages = exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessageTemplate)
                .sorted()
                .collect(Collectors.joining("; "));

        OperationResponse operationResponse = OperationResponse.builder()
                .withIsError(true)
                .withMessage(errorMessages)
                .build();

        return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.BAD_REQUEST)
                .entity(operationResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
