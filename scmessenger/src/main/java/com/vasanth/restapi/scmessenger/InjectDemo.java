package com.vasanth.restapi.scmessenger;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/inject")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemo {
	@GET
	@Path("annonations")
	public String getParamsUsingAnnonations(@MatrixParam("param")String matrixparam,
											@HeaderParam("accept") String customHeader)
												{
		return "Annonations: "+matrixparam + " Custom Header: " + customHeader;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers){
		String cookies = headers.getCookies().toString();
		return "Path : "+uriInfo.getAbsolutePath().toString()+ " Cookie :"+cookies;
	}
	
	
}
