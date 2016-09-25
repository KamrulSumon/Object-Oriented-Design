package com.sumon.ood;

public abstract class ColdDrink implements IItem {

	@Override
	public IPacking packing() {
		return new Bottle();
	}

	@Override
	public abstract String name();

	@Override
	public abstract float price();

}
