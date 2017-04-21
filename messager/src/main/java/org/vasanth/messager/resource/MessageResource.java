package org.vasanth.messager.resource;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.soap.MessageFactory;

import org.vasanth.messager.bean.MessageFilter;
import org.vasanth.messager.model.ArrayMessage;
import org.vasanth.messager.model.Message;
import org.vasanth.messager.model.Profile;
import org.vasanth.messager.service.MessageServices;

/*
 * @Path -- This Path Annotation will help jersey servlet to point to which class it should refer
 * when a request is made. 
 */
@Path("/messages")
public class MessageResource {
	/*
	 * @GET -- This will help to understand about what kind of method, Rest API request is 
	 * initiated.
	 */
	/*
	 * @Produces -- This will help the method provide on which type it can show the result back
	 * to the request 
	 */
	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	
	public String getMessageList(){
		return "This is first REST GET API Resource";
	}*/
	
	MessageServices service=new MessageServices();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessageList(@BeanParam MessageFilter beanParam){
		if(beanParam.getYear()>0){
			return service.getAllYearMessages(beanParam.getYear());
		} if(beanParam.getStart()>0 && beanParam.getSize()>0){
			
			return service.getMessagesPaginated(beanParam.getStart(), beanParam.getSize());
		}
		return service.getAllMessages();
	}
	/*
	 * This is for Testing the Path Param in the Rest API Call
	 * This helps in raising the web URI with Subsequent path
	 */
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "Test Reply for PATH PARAM";
	}
	/*
	 * In above we provided a hard coded path, which shows us what it can point to
	 * ex./webapi/messages/test
	 * 
	 * But if the Path is unique and different but it should address a method to fetch it's
	 * related result then we need to use path param in generic format as like below.
	 */
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") Long messageId,@Context UriInfo uriInfo){
		Message message=service.getMessage(messageId);
		String url = getMessageURI(uriInfo, message);
		message.addLink(url, "self");	
		message.addLink(getCommentURI(uriInfo, message), "Comment");
		return service.getMessage(messageId);
	}
	private String getMessageURI(UriInfo uriInfo, Message message) {
		String url=uriInfo.getAbsolutePathBuilder().path(MessageResource.class).path(String.valueOf(message.getId())).build().toString();
		return url;
	}
	private String getCommentURI(UriInfo uriInfo, Message message) {
		String url=uriInfo.getAbsolutePathBuilder().
				path(MessageResource.class).
				path(MessageResource.class,"getCommentResource").				
				resolveTemplate("messageId", String.valueOf(message.getId())).				
				build().toString();
				
				
		return url;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uriInfo){
		Message newMessage=service.addMessage(message);
		String newId=String.valueOf(newMessage.getId());
		URI uri=uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMessage).build();
	}
	/* This is for the POST Method
	 * @POST
	@Produces(MediaType.TEXT_PLAIN)
	public String getPostMessageList(){
		return "This is First POST REST API Response";
	}*/
	/*
	 * This is for the Update operation that will update any existing Message Values in the 
	 * DatabaseClass.
	 */
	
	@PUT
	@Path("/{messageId}") 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") Long messageId,  Message message ){
		message.setId(messageId);
		return service.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	/*
	 * This Will be needed for the DELETE Method, as it is not required when you do the delete 
	 * operation, simply sending the requested path will delete the resource from the services.
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 */
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId")Long id){
		service.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
	@POST
	@Path("/arraymessage")
	@Consumes(MediaType.APPLICATION_JSON)
	public String getOutput(ArrayMessage arrayMessage){
		
		Set<Message> message=(Set<Message>) arrayMessage.getMessage();
		System.out.println(message.size());
		for(Message msg:message){
			System.out.println(msg.getMessage());
			System.out.println(msg.getAuthor());
			
		}
		Profile profile=arrayMessage.getProfile();
		System.out.println(profile.getFirstName());
		System.out.println(profile.getLastName());
		return "ArrayMessage"; 
	}
	
}
