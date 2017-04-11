package com.vasanth.restapi.scmessenger.DataBase;
import com.vasanth.restapi.scmessenger.model.MessageModel;
import com.vasanth.restapi.scmessenger.model.Profile;
import java.util.Map;
import java.util.HashMap;
public class DatabaseClass {

	public static Map<Long,MessageModel> messages=new HashMap<Long,MessageModel>();
	public static Map<String,Profile> profile = new HashMap<String,Profile>();
	
	public static Map<Long,MessageModel> getMessages(){
		return messages;
	}
	public static Map<String,Profile> getProfiles(){
		return profile;
	}
}
