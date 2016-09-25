package com.sumon.ood;

public class Customer {
	String name;
	String phone;
	String email;
	Address address;
	
	public Customer(String name, String phone, String email, Address address) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
}
