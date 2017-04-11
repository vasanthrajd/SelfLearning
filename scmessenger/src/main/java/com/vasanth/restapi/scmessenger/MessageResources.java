package com.vasanth.restapi.scmessenger;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import com.vasanth.restapi.scmessenger.Service.CommentResource;
import com.vasanth.restapi.scmessenger.Service.MessageService;
import com.vasanth.restapi.scmessenger.bean.MessageFilter;
import com.vasanth.restapi.scmessenger.model.MessageModel;

@Path("/messages")
public class MessageResources {

	MessageService msgService=new MessageService();
	/*
	 * Get the list of all the messages
	 */
	
	@GET	
	public List<MessageModel> getMessages(@BeanParam MessageFilter beanParamFilter){
		if(beanParamFilter.getYear()>0){
			return msgService.getAllYearMessages(beanParamFilter.getYear());
		}
		if(beanParamFilter.getStart() >0 && beanParamFilter.getSize() >=0){
			return msgService.getAllMessagePaginated(beanParamFilter.getStart(), beanParamFilter.getSize());
		}
		
		return msgService.getAllMessages();
	}

	/*
	 * Get a Single Message
	 */
	@GET
	@Path("/{messageID}")
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MessageModel getsingleMessage(@PathParam("messageID") long id){
		
		return msgService.getMessage(id);
	}
	
	/*
	 * Create a Message by sending the request
	 */
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MessageModel addSingleMessage(MessageModel message){
		return msgService.addMessage(message);
	}
	
	/*
	 * Update a message by sending the Message ID
	 */
	
	@PUT
	@Path("/{messageID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MessageModel updateSingleMessage(@PathParam("messageID") long id,MessageModel message){
		message.setId(id);
		return msgService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void removeSingleMessage(@PathParam("messageID") long id, MessageModel message){
		msgService.removeMessage(id);
	}
	
	
	@Path("/{messageID}/comments")
	public CommentResource getComment(){
		return new CommentResource();
	}
	
}
