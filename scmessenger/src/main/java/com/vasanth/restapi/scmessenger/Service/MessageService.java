package com.vasanth.restapi.scmessenger.Service;

import com.vasanth.restapi.scmessenger.DataBase.DatabaseClass;
import com.vasanth.restapi.scmessenger.model.MessageModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

public class MessageService {

	/*
	 * MessageModel mc=new MessageModel();
	 */
	
	private Map<Long,MessageModel> messages=DatabaseClass.getMessages();
	
	public MessageService (){
		super();
		messages.put(1L, new MessageModel(101,"Service Message 1","Vasanth"));
		messages.put(2L, new MessageModel(102,"Service Message 2", "Raj"));	
	}
	
	public List<MessageModel> getAllMessages(){
		System.out.println("Get ALL MESSAGES ");
		System.out.println(messages.values());
		return new ArrayList<MessageModel>(messages.values());
		/* This is old Code to understand how the Message were built.*/
		/*List<MessageModel> listMessages=new ArrayList<MessageModel>();
		MessageModel msg1=new MessageModel(1, "First Rest API String", "Vasanth");
		MessageModel msg2=new MessageModel(2,"Second Rest API String","Raj");
		listMessages.add(msg1);
		listMessages.add(msg2);
		return listMessages;*/
	}
	
	public List<MessageModel> getAllYearMessages(int year){
		List<MessageModel> listMessageYear=new ArrayList<MessageModel>();
		
		Calendar cal=Calendar.getInstance();
		for(MessageModel tmp:messages.values()){
			cal.setTime(tmp.getCreatedAt());
			if(cal.get(Calendar.YEAR)==year){
				listMessageYear.add(tmp);
			}
		}
		return listMessageYear;
	}
	
	public List<MessageModel> getAllMessagePaginated(int start, int size){
		ArrayList<MessageModel> listMode=new ArrayList<MessageModel>(messages.values());
		return listMode.subList(start, start+size);
	}
	
	
	public MessageModel addMessage(MessageModel message){
		System.out.println("ADD NEW MESSAGE");
		message.setId(messages.size()+1);
	//	message.setCreatedAt(new Date());
		messages.put(message.getId(),message);
		return message;
	}
	
	public MessageModel getMessage(long id){
		System.out.println("Get SINGlE MESSAGES ");
		return messages.get(id);
	}
	
	public MessageModel updateMessage(MessageModel message){
		if(message.getId() < 0){
			return null;
		}
		
		messages.put(message.getId(),message);
		return message;
		
	}
	public MessageModel removeMessage(long id){
		return messages.remove(id);
	}

	
	
}
