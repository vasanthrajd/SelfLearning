package com.springdi.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdi.consumer.MyAppXml;
import com.springdi.services.TwitterServices;

public class ClientXMLApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/*
		 * First way to read the Bean 
		 */
		MyAppXml xml=context.getBean(MyAppXml.class);
		/*
		MyAppXml xml=(MyAppXml) context.getBean("xmlBeanInjector");
		*/
		xml.processMessage("XML Message to the Sender", "vasanth@gmail.com");
		TwitterServices tw=(TwitterServices) context.getBean("twitter");
		tw.sendMessage("Twitter Message", "##Spring Twitter");
		context.close();
	}

}
