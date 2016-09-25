package com.sumon.ood;

import java.util.ArrayList;
import java.util.List;

public class Meal {

	private List<IItem> items = new ArrayList<>(); // hold items for each meal

	// add item to meal
	public void addItem(IItem item) {
		items.add(item);
	}

	// get cost of meal
	public float getCost() {
		float cost = 0.0f;

		for (IItem item : items) {
			cost += item.price();
		}
		return cost;
	}

	// show item information
	public void showItems() {
		for (IItem item : items) {
			System.out.print("Item : " + item.name());
			System.out.print(", Packing: " + item.packing().pack());
			System.out.println(", Price : " + item.price());
		}
	}

}
