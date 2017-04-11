package org.vasanth.messager.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.vasanth.messager.model.ErrorMessage;

//@Provider
public class GenerirExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable th){
		ErrorMessage errMsg=new ErrorMessage(th.getMessage(),500,"http://localhost:8011");
		return Response.status(Status.NOT_FOUND).entity(errMsg).build();
	}

}
