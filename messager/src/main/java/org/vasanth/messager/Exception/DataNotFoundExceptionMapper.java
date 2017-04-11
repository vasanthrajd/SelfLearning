package org.vasanth.messager.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.vasanth.messager.model.ErrorMessage;
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException arg0) {
		// TODO Auto-generated method stub
		ErrorMessage err=new ErrorMessage("Message you are looking for Not Found",404,"http://localhost:8011");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(err).build();
	}
	

}
