package com.vasanth.client;
import java.util.*;
public class CollectionCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Object> strList=new ArrayList<Object>();
		strList.add("First");
		strList.add("Second");
		strList.add("Third");
		
		List<Object> intList=new ArrayList<Object>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		
		List<Object> longList=new ArrayList<Object>();
		longList.add(1l);
		longList.add(2l);
		longList.add(3l);
		
		CollectionCheck.showOutput(strList);
		CollectionCheck.showOutput(intList);
		CollectionCheck.showOutput(longList);
		

	}
    public static void showOutput(List<Object> obj){
    	
    	for(Object tmp:obj){
    		if(tmp instanceof Integer){
    			
    			System.out.println(""+(tmp instanceof Integer)+"\t"+tmp);
    		}
    		if(tmp instanceof String){
    			System.out.println(""+(tmp instanceof String)+"\t"+tmp);
    		}
    		if(tmp instanceof Long){
    			System.out.println(""+(tmp instanceof Long)+"\t"+tmp);
    		}
    	}
    }
}
