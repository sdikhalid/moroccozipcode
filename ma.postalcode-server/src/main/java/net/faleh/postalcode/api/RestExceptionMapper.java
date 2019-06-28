package net.faleh.postalcode.api;

import javax.inject.Named;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import lombok.extern.slf4j.Slf4j;

@Provider
@Named
@Slf4j
public class RestExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {

        log.error("unexpected exception on a REST WS call: ", exception);
        return Response.serverError().build();
    }


}