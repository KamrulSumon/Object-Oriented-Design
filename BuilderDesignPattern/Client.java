package com.sumon.ood;

/**
 * Implemeantation of Builder Pattern
 * @author Kamrul Hasan
 * Ref : https://www.tutorialspoint.com/design_pattern/builder_pattern.htm
 */
public class Client {
	public static void main(String[] args) {
		MealBuilder mealBuilder = new MealBuilder();

		Meal vegMeal = mealBuilder.prepareVegMeal();
		System.out.println("Veg meal");
		vegMeal.showItems();
		System.out.println("Total cost: " + vegMeal.getCost());

		Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
		System.out.println("Non-Veg meal");
		nonVegMeal.showItems();
		System.out.println("Total Cost : " + vegMeal.getCost());
	}
}
