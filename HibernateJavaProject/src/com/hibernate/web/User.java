package com.hibernate.web;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class User implements Serializable{
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int userId;
	private int panCard;
	private int rationCard;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPanCard() {
		return panCard;
	}
	public void setPanCard(int panCard) {
		this.panCard = panCard;
	}
	public int getRationCard() {
		return rationCard;
	}
	public void setRationCard(int rationCard) {
		this.rationCard = rationCard;
	}
	
	
}
