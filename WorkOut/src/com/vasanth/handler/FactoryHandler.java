package com.vasanth.handler;

import com.vasanth.service.FixedInterest;
import com.vasanth.service.Plan;
import com.vasanth.service.RecurringDeposit;

public class FactoryHandler {
	private Plan pl;
	public Plan createObject(String plan){
		if(plan.contains("fixed")){
			pl=new FixedInterest();
			
		}else if(plan.contains("recurring")){
			pl=new RecurringDeposit();
		}
		return pl;
	}
	
}
