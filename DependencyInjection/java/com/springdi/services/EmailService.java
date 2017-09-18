package com.springdi.services;

public class EmailService implements MessageServices {

	@Override
	public boolean sendMessage(String message, String recipent) {
		// TODO Auto-generated method stub
		System.out.println("Email Sent to "+recipent+ " with Message="+message);
		return true;
	}

}
