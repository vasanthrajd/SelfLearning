package org.vasanth.messager.service;

import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.util.Date;

import org.vasanth.messager.model.Comment;
import org.vasanth.messager.model.ErrorMessage;
import org.vasanth.messager.model.Message;
import org.vasanth.messanger.database.DatabaseClass;
import java.util.List;
import java.util.ArrayList;

public class CommentServices {
	
	private Map<Long, Message> messages=DatabaseClass.getMessages();
	
	public CommentServices(){
		super();		
	}
	
	public List<Comment> getAllComments(Long messageid){
		return new ArrayList<Comment>( messages.get(messageid).getComments().values());
	}
	
	public Comment getSingleComments(Long messageid,Long commentId){
		ErrorMessage errMsg=new ErrorMessage("Not Found Message ID", 404,"http://localhost:8011");
		Response response=Response.status(Status.NOT_FOUND).entity(errMsg).build();
		
		Message message=messages.get(messageid);
		if(message==null){
			throw new WebApplicationException();
		}
		
		Map<Long,Comment> msgComment=messages.get(messageid).getComments();
		if(msgComment.get(commentId)==null){
				throw new NotFoundException(response);
		}
		
		if(msgComment.get(commentId)!=null){
			return msgComment.get(commentId); 
		}
		return null;
	}

	
	public Comment addComment(Long messageid, Comment comment){
		Map<Long, Comment> msgComment=messages.get(messageid).getComments();
		comment.setCommentId((long)msgComment.size()+1);
		comment.setCreatedDate(new Date());
		msgComment.put(comment.getCommentId(), comment);
		messages.get(messageid).setComments(msgComment);
		return comment;
	}
	
	public Comment updateComment(Long messageid, Comment comment){
		Map<Long,Comment> msgComment=messages.get(messageid).getComments();
		if(comment.getCommentId()<=0){
			return null;
		}
		msgComment.put(comment.getCommentId(),comment);
		messages.get(messageid).setComments(msgComment);
		return comment;
	}
	
	public String removeComment(Long messageid, Long commentId){
		Map<Long,Comment> msgComment=messages.get(messageid).getComments();
		System.out.println(msgComment.get(commentId).toString());
		if(msgComment.get(commentId)!=null){
			msgComment.remove(commentId);
			messages.get(messageid).setComments(msgComment);
			return "Success";
		}
		return "No Comments Found";
	}
	
}
