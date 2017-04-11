package com.vasanth.client;

import com.vasanth.handler.FactoryHandler;
import com.vasanth.service.Plan;

public class FindInterest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Plan p1=new FactoryHandler().createObject("fixed");
			p1.showInterestRate();
			Plan p2=new FactoryHandler().createObject("recurring");
			p2.showInterestRate();
	}	

}
