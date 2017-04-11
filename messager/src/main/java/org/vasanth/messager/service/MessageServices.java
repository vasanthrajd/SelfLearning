package org.vasanth.messager.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.*;

import org.vasanth.messager.Exception.DataNotFoundException;
import org.vasanth.messager.model.Message;
import org.vasanth.messanger.database.DatabaseClass;

public class MessageServices {

		private static Map<Long,Message> messages=DatabaseClass.getMessages();
	
		public MessageServices(){
			super();
			messages.put(1L, new Message("First Message", 1l, "Vasanth", new Date()));
			messages.put(2L, new Message("Second Message", 2l, "Vasanth", new Date()));
			messages.put(3L, new Message("Third Message", 3l, "Vasanth", new Date()));
			messages.put(4L, new Message("Four Message", 4l, "Vasanth", new Date()));
		}
	
		public List<Message> getAllMessages(){
			return new ArrayList<Message>(messages.values());
		}
		
		public Message getMessage(Long id){
			Message message=messages.get(id);
			if(message == null){
				throw new DataNotFoundException("Message you are looking for :"+id+" is not available");
			}
			return messages.get(id);
		}
		
		public Message addMessage(Message message){
			message.setId( (long)(messages.size() + 1));
			message.setCreated(new Date());
			messages.put(message.getId(), message);
			return message;
		}
		
		public Message updateMessage(Message message){
			if(message.getId()<=0){
				return null;
			}
			messages.put(message.getId(), message);
			Set<Long> keys=messages.keySet();
					
			return message;
		}
		public Message removeMessage(Long id){
			return messages.remove(id);
		}
		
		public List<Message> getAllYearMessages(int year){
			List<Message> messageList=new ArrayList<Message>();
			Calendar cal=Calendar.getInstance();
			for(Message msg:messages.values()){
				cal.setTime(msg.getCreated());
				if(cal.get(Calendar.YEAR)==year){
					System.out.println("YEAR>>>>"+msg.toString());
					messageList.add(msg);
				}
			}			
			return messageList;
		}
		
		public List<Message> getMessagesPaginated(int start, int size){
			List<Message> listMessage=new ArrayList<Message>(messages.values());
			if(size > listMessage.size())
				return listMessage.subList(start, listMessage.size()-start);
			else
				return listMessage.subList(start, start+size);
		}
}


