package com.sumon.ood;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape shape) {
		super(shape);
	}

	@Override
	public void draw() {
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}

	// set red border
	public void setRedBorder(Shape shape) {
		System.out.println("Border color: Red");
	}

}
