package com.sumon.prog.ood;

public class TestATMMachine {

	public static void main(String[] args) {

		ATMMachine atmMachine = new ATMMachine();

		atmMachine.insertCard();
		atmMachine.ejectCard();
		atmMachine.insertCard();
		atmMachine.insertPin(1234);
		atmMachine.requestCash(2000);
		atmMachine.insertCard();
		atmMachine.insertPin(1234);

	}

}




// Special thanks :  http://www.newthinktank.com/2012/10/state-design-pattern-tutorial/
