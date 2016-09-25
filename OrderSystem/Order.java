package com.sumon.ood;

import java.util.ArrayList;
import java.util.List;

/* order class that hold each order information */
public class Order {
	private Customer customer;
	private List<Item> items;
	
	public Order(Customer customer, Item item){
		items = new ArrayList<Item>();
		this.customer = customer;
		items.add(item);
	}
	
	public Customer getCustomer(){
		return customer;
	}
	/* add new item */
	public void addItem(Item item){
		items.add(item);
	}
	/* cancel an Item */
	public void cancelItem(Item item){
		int index = items.indexOf(item);
		items.remove(index);
	}
	
	/* return total price of this order */
	public double getTotal(){
		double total = 0.0;
		
		for(Item item : items){
			total += item.getTotalPrice();
		}
		return total;
	}
	
	public void prepare(){	
		for(Item item : items){			
			item.prepare();
		}		
	}

}
