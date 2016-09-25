package com.sumon.ood;

import java.util.ArrayList;
import java.util.List;

/* robot that takes order from customer */
public class Robot {
	private int robotId;
	private List<Order> orders;
	
	public Robot(int robotId){
		this.robotId = robotId;
		orders = new ArrayList<>();
	}
	
	/* take an order */
	public boolean takeOrder(Order order){
		Customer customer = order.getCustomer();
		boolean isSuccess = customer.charge(order.getTotal());
		
		if(isSuccess){
			orders.add(order);
		}
		return isSuccess;
	}
	
	/* cancel an order */
	public void cancelOrder(Order order){
		int index = orders.indexOf(order);
		orders.remove(index);
		
		Customer customer = order.getCustomer();
		customer.refund(order.getTotal());
	}
	
	public void prepare(){
		for(Order order : orders){
			order.prepare();
		}
	}
}
