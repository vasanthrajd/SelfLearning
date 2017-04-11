package org.vasanth.messager.resource;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import org.vasanth.messager.model.Comment;
import org.vasanth.messager.service.CommentServices;
import org.vasanth.messager.service.MessageServices;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import java.util.List;
@Path("/")
public class CommentResource {

	CommentServices cservices=new CommentServices();
		
	@GET
	@Path("/{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Comment getCommentNumber(@PathParam("commentId")Long commentId,@PathParam("messageId")Long messageid ){
		return cservices.getSingleComments(messageid, commentId);
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getAllComments(@PathParam("messageId") Long messageId){
		return cservices.getAllComments(messageId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Comment addCommnet(@PathParam("messageId") Long messageId,Comment comment){
		return cservices.addComment(messageId, comment);
	}
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public Comment updateComment(@PathParam("messageId")Long messageId, Comment comment){
		return cservices.updateComment(messageId, comment);
	}
	@DELETE
	@Path("/{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public String removeComment(@PathParam("messagId") Long messageId, @PathParam("commentId") Long commentId){
		return cservices.removeComment(messageId, commentId);
	}
	
	
	
}
