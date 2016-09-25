package com.sumon.ood;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	int orderId;
	Buyer buyer;
	Seller seller;
	Date date;
	Car car;
	BigDecimal price;
	int quantity;
	int discount;
	
	public Order(Buyer buyer, Seller seller, Car car, BigDecimal price, int quantity) {
		this.buyer = buyer;
		this.seller = seller;
		this.car = car;
		this.price = price;
		this.quantity = quantity;
	}
	
}
