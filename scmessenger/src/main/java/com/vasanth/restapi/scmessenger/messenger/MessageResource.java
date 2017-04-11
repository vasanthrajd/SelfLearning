package com.vasanth.restapi.scmessenger.messenger;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.vasanth.restapi.scmessenger.Service.MessageServiceResponse;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
/*
 * Annotate to expose the class for the jersey servlet container
 */


@Path("/messegesexample")
public class MessageResource {

	
	/*
	 * Annotate the HTTP Method to the Java Method. 
	 * Get HTTP Method is mapped to the Java Method
	 */
	/*
	 * 
	 */
	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessegesGet(){
		return "Message from REST RESOURCE";
	}
	
*/	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public MessageServiceResponse getResponse(){
		MessageServiceResponse response=new MessageServiceResponse("SUCCESS","Response Text");
		response.setMessage("Message Invocked for JSON");
		return response;
	}
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessagesPost(){
		return "Secured Message From REST RESOURCE";
	}
	
}
