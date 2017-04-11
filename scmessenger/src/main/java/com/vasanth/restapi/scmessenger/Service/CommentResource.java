package com.vasanth.restapi.scmessenger.Service;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
@Path("/")
public class CommentResource {
	
	@GET
	@Path("/{commentID}")
	public String testComment(@PathParam("commentID") long commentId, @PathParam("messageID")long messageId){
		return "Comment Service Is reached : "+commentId+" for the message : "+messageId;
		
	}
	@GET
	public String test(){
		return "Comment Invoked";
	}

}
