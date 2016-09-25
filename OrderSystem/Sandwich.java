package com.sumon.ood;

/* Concrete class */
public class Sandwich extends Item{
	
	private static final int ID = 1000;
	private static final String NAME = "sandwich";
	private static final double PRICE = 1.99;

	public Sandwich(int qty){
		itemId = ID;
		itemName = NAME;
		price = PRICE;
		quantity = qty;
	}
	
	@Override
	public void prepare() {
		processBread();
		processMeat();
		packSandwich();
	}

	private void processBread() {
		System.out.println("Processing Sandwich Bread...");
		
	}
	
	private void processMeat() {
		System.out.println("Processing Sandwich Meat...");
		
	}
	
	private void packSandwich() {
		System.out.println("Packing Sandwich...");
		
	}
}
