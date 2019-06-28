package net.faleh.postalcode.api.v1;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.faleh.postalcode.database.PostalCode;

@Path("/v1")
@Api(tags = "recoverable")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Validated
public interface PostalCodeController {


    @NotNull
    @GET
    @ApiOperation("find postal codes by city name or place name starting with param")
    @Path("/{startingWith}")
    List<PostalCode> findPostalCode(@PathParam("startingWith") @NotBlank String startingWith);


}
