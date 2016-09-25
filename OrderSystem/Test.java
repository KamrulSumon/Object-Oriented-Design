package com.sumon.ood;

/**
 * Implementation of order system
 * @author Kamrul Hasan
 * @source https://www.careercup.com/question?id=5739705276563456
 */

public class Test {

	public static void main(String[] args) {
		Robot robot = new Robot(200);		// make a robot
		
		Customer customerA = new Customer(1, "John", 300.0);		// new customer
		Sandwich sandwich = new Sandwich(2);
		Order order = new Order(customerA, sandwich);		// make a order		
				
		//order.addItem(sandwich);
		robot.takeOrder(order);		// take the, order
		
		Customer customerB = new Customer(2, "Jack", 200.0);		// comes in a customer
		sandwich = new Sandwich(5);
		order = new Order(customerB, sandwich);		// make a order		
			
		//order.addItem(sandwich);
		robot.takeOrder(order);		// take the order
		robot.prepare();		// prepare the food
		

	}

}
