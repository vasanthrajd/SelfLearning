package org.vasanth.messager.model;

import java.util.Collection;
import java.util.HashSet;

public class ArrayMessage {
	private Collection<Message> message=new HashSet<Message>();

	private Profile profile;
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Collection<Message> getMessage() {
		return message;
	}

	public void setMessage(Collection<Message> message) {
		this.message = message;
	}
	
	
}
