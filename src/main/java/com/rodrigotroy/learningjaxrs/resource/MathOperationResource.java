package com.rodrigotroy.learningjaxrs.resource;

import com.rodrigotroy.learningjaxrs.domain.OperationRequest;
import com.rodrigotroy.learningjaxrs.domain.OperationResponse;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * $ Project: learning-JAX-RS
 * User: rodrigotroy
 * Date: 23-11-24
 * Time: 21:32
 */
@RequestScoped
@Path("math")
public class MathOperationResource implements Serializable {
    @Inject
    private Logger logger;

    @POST
    @Path("operation")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response execute(@Valid OperationRequest request) {
        logger.info("Received operation request: {}",
                    request);

        if (request == null) {
            OperationResponse operationResponse = OperationResponse.builder()
                                                                   .withIsError(true)
                                                                   .withMessage("Invalid request")
                                                                   .build();

            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(operationResponse)
                           .type(MediaType.APPLICATION_JSON)
                           .build();
        }

        Double result = request.calculateResult();

        OperationResponse response = OperationResponse.builder()
                                                      .withIsError(false)
                                                      .withMessage("Success")
                                                      .withResult(result)
                                                      .build();

        logger.info("Response: {}",
                    response);

        return Response.ok()
                       .entity(response)
                       .type(MediaType.APPLICATION_JSON).build();
    }
}
