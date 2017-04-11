package com.vasanth.service;

/**
 * @author EE206105
 *
 */
public enum EnumExample {
	University(10), College(20), School(30);
	/*
	 * Using the Constructor to Define the Values for the Ennum;
	 */
	public int value;
	private EnumExample(int i){
		this.value=i;
	}

	
}
