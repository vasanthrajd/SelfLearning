package org.vasanth.messanger.database;
import org.vasanth.messager.model.*;
import java.util.*;
public class DatabaseClass {

	private static Map<Long, Message> messages1=new HashMap<>();
	private static Map<Long, Profile> profiles=new HashMap<>();
	private static Map<Long, Comment> comments=new HashMap<>();
	
	public static Map<Long,Message> getMessages(){
		return messages1;
	}
	
	public static Map<Long, Profile> getProfiles(){
		return profiles;
	}
	
	public static Map<Long, Comment> getComments(){
		return comments;
	}
}