package org.vasanth.messager.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Comment {
	private Long commentId;
	private String comments;
	private Date createdDate;
	
	public Comment(){
		
	}
	
	public Comment(Long id, String comments){
		this.commentId=id;
		this.comments=comments;
		this.createdDate=new Date();
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
