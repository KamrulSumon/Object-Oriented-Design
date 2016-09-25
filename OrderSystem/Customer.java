package com.sumon.ood;

/* customer information */
public class Customer {
	private int customerId;
	private String customerName;
	private double balance;
	
	public Customer(int customerId, String customerName, double initBalance){
		this.customerId = customerId;
		this.customerName = customerName;
		this.balance = initBalance;
	}
	
	// can implement charge, and refund method
	public boolean charge(double amount){
		if(balance >= amount){
			balance -= amount;
			return true;
		}
		else{
			return false;
		}
	}
	
	public void refund(double amount){
		balance += amount;
	}
}
