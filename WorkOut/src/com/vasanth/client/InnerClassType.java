package com.vasanth.client;

public class InnerClassType {
	
	MuserInfo muserInfo=new MuserInfo();
	public static void main(String[] args){
		InnerClassType i=new InnerClassType();
		i.show();
		
		
	}
	public void show()
	{
		
		MuserTimeZone tmp=new MuserTimeZone();
		tmp.setId(1);
		tmp.setDescription("Description");
		tmp.setName("Name");
		tmp.setShortDesc("short Description");
		muserInfo.setMuserTimeZone(tmp);
		System.out.println(muserInfo.getMuserTimeZone().toString());
		
		
	
	}
}
