package com.sumon.ood;

/**
 * Implementation of Chain of Responsibility Design Pattern
 * @author Kamrul Hasan
 * @Ref  https://www.youtube.com/watch?v=jDX6x8qmjbA
 */

/* Contract */
interface IChain {
	void setNextChain(IChain nextChain);

	void calculate(Numbers request);
}

/* class numbers to be operated */
class Numbers {
	private int number1;
	private int number2;

	private String calculationWanted;

	public Numbers(int num1, int num2, String calcWanted) {
		number1 = num1;
		number2 = num2;
		calculationWanted = calcWanted;
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public String getCalculationWanted() {
		return calculationWanted;
	}

	public void setCalculationWanted(String calculationWanted) {
		this.calculationWanted = calculationWanted;
	}

}

/* add two numbers */
class AddNumber implements IChain {

	IChain nextChain;

	@Override
	public void setNextChain(IChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void calculate(Numbers request) {

		if (request.getCalculationWanted() == "add") {
			System.out.println(request.getNumber1() + " + " + request.getNumber2() + " = "
					+ (request.getNumber1() + request.getNumber2()));
		} else {
			nextChain.calculate(request);
		}

	}

}

/* subtract two numbers */
class SubTractNumber implements IChain {

	IChain nextChain;

	@Override
	public void setNextChain(IChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void calculate(Numbers request) {

		if (request.getCalculationWanted() == "sub") {
			System.out.println(request.getNumber1() + " - " + request.getNumber2() + " = "
					+ (request.getNumber1() - request.getNumber2()));
		} else {
			nextChain.calculate(request);
		}

	}

}

/* subtract two numbers */
class MultiplyNumber implements IChain {

	IChain nextChain;

	@Override
	public void setNextChain(IChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void calculate(Numbers request) {

		if (request.getCalculationWanted() == "mul") {
			System.out.println(request.getNumber1() + " * " + request.getNumber2() + " = "
					+ (request.getNumber1() * request.getNumber2()));
		} else {
			nextChain.calculate(request);
		}

	}

}

/* subtract two numbers */
class DivideNumber implements IChain {

	IChain nextChain;

	@Override
	public void setNextChain(IChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void calculate(Numbers request) {

		if (request.getCalculationWanted() == "div") {
			System.out.println(request.getNumber1() + " / " + request.getNumber2() + " = "
					+ (request.getNumber1() / request.getNumber2()));
		} else {
			System.out.println("Only works on add, sub, mul, div");
		}}

}


/* driver class */
public class ChainOfResponsibility {

	public static void main(String[] args) {
		
		IChain addChain = new AddNumber();
		IChain subChain = new SubTractNumber();
		IChain mulChain = new MultiplyNumber();
		IChain divChain = new DivideNumber();
		
		addChain.setNextChain(subChain);
		subChain.setNextChain(mulChain);
		mulChain.setNextChain(divChain);
		
		Numbers addition = new Numbers(4, 5, "add");
		addChain.calculate(addition);
		
		Numbers subtraction = new Numbers(4, 5, "sub");
		subChain.calculate(subtraction);
		
		Numbers division = new Numbers(4, 5, "div");
		addChain.calculate(division);
	}

}
