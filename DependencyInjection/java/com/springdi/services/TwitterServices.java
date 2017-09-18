package com.springdi.services;

public class TwitterServices implements MessageServices {

	@Override
	public boolean sendMessage(String message, String recipent) {
		// TODO Auto-generated method stub
		System.out.println("Twitter Message Sent to "+recipent+ " with Message="+message);
		return true;
	}

}
