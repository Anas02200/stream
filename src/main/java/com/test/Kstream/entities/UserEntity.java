package com.test.Kstream.entities;

public class UserEntity {

	private String name;
	private long cardNumber;
 
	public UserEntity() {
		
	}

	public UserEntity(String name, long cardNumber) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	
}

