package com.sumon.ood;
/**
 * Abstract item class
 * @author Kamrul Hasan
 *
 */
public abstract class Item {
	
	protected int itemId;
	protected String itemName;
	protected double price;
	protected int quantity;
	
	
	
	public int getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}

	/* return total price */
	public double getTotalPrice(){
		return price * quantity;
	}
	
	public abstract void prepare();

}
