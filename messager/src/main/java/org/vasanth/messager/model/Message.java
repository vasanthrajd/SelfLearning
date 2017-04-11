package org.vasanth.messager.model;
import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@XmlRootElement

public class Message {

	private String message;
	private Long id;
	private String author;
	private Date created;	
	private Map<Long,Comment> comments=new HashMap<>();
	
	private List<Link> links=new ArrayList<Link>();
	
	/*
	 * This No Argument Constructor is needed,
	 * Reason: The XML Response Framework or JSON Response Framework may need the No Arg 
	 * constructor needed in order to instantiate the response data.
	 */
	public Message(){
		
	}
	
	
	public Message(String message, Long id, String author, Date created) {
		super();
		this.message = message;
		this.id = id;
		this.author = author;
		this.created = created;
		Comment comment=new Comment(1L, "comments :" +1L);
		this.comments.put(1L, comment);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}


	public List<Link> getLinks() {
		return links;
	}


	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void addLink(String url, String rel){
		Link link=new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}

}
