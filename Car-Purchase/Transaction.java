package com.sumon.ood;

public class Transaction {
	Transaction id;
	Order order;
	String transactionType;
	String status;
	Address billingAddress;
	
	public Transaction(Order order){
		this.order = order;
	}
}
