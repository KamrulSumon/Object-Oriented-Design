package com.sumon.prog.ood;

public class NoCard implements ATMState {

	ATMMachine atmMachine;

	public NoCard(ATMMachine newATMMachine) {
		atmMachine = newATMMachine;
	}

	@Override
	public void insertCard() {

		System.out.println("Please enter PIN");
		atmMachine.setATMState(atmMachine.getYesCardState());

	}

	@Override
	public void ejectCard() {

		System.out.println("You have not entered card");
	}

	@Override
	public void insertPin(int pinEntered) {

		System.out.println("You have not entered card");
	}

	@Override
	public void requestCash(int cashToWithdraw) {

		System.out.println("You have not entered card");
	}

}
