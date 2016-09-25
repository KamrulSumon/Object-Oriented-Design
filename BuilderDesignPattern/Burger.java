package com.sumon.ood;

// abstract Burger class
public abstract class Burger implements IItem {

	@Override
	public IPacking packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();
}
