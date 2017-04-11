package com.vasanth.client;

import com.vasanth.service.EnumExample;

public class EnnumClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnumExample enumExample=EnumExample.College;
		System.out.println("Enum Holds\t"+enumExample);
		System.out.println("Enum Holds\t"+enumExample.School);
		System.out.println("Enum Holds using ordinal()\t"+enumExample.ordinal());
		System.out.println("Enum Example Name\t"+enumExample.name());
		System.out.println("Enum Values Method\t"+enumExample.value);
		
		for(EnumExample en:enumExample.values()){
			System.out.println(en+"\tValue :"+en.value+"\tName :"+en.name());
		}
	}

}

