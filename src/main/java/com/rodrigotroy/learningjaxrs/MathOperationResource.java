package com.rodrigotroy.learningjaxrs;

import com.rodrigotroy.learningjaxrs.domain.OperationRequest;
import com.rodrigotroy.learningjaxrs.domain.OperationResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * $ Project: learning-JAX-RS
 * User: rodrigotroy
 * Date: 23-11-24
 * Time: 21:32
 */
@javax.ws.rs.Path("math")
public class MathOperationResource {
    private static final Logger logger = LogManager.getLogger(MathOperationResource.class);

    @POST
    @javax.ws.rs.Path("operation")
    @javax.ws.rs.Consumes({MediaType.APPLICATION_JSON})
    @javax.ws.rs.Produces({MediaType.APPLICATION_JSON})
    public Response execute(OperationRequest request) {
        logger.info("Received operation request: {}", request);

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

        Double result = request.getOperation().apply(request.getFirstNumber(),
                                                     request.getSecondNumber());

        OperationResponse response = OperationResponse.builder()
                                                      .withIsError(false)
                                                      .withMessage("Success")
                                                      .withResult(result)
                                                      .build();

        return Response.ok()
                       .entity(response)
                       .type(MediaType.APPLICATION_JSON).build();
    }
}
