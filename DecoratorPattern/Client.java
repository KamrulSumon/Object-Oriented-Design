package com.sumon.ood;

/**
 * Decorator design pattern implementation
 * @author Kamrul Hasan
 * Ref: https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm
 */
public class Client {

	public static void main(String[] args) {

		Shape circle = new Circle();
		Shape rectangle = new Rectangle();

		Shape redCircle = new RedShapeDecorator(circle);
		Shape redRectangle = new RedShapeDecorator(rectangle);

		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("Circle with red border");
		redCircle.draw();

		System.out.println("Rectangle with normal border");
		rectangle.draw();

		System.out.println("Rectangle with red border");
		redRectangle.draw();
	}
}
