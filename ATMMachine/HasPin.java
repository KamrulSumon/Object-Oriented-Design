package com.sumon.prog.ood;

public class HasPin implements ATMState {

	ATMMachine atmMachine;

	public HasPin(ATMMachine newATMMachine) {
		atmMachine = newATMMachine;
	}

	@Override
	public void insertCard() {

		System.out.println("You already entered a card");
	}

	@Override
	public void ejectCard() {

		System.out.println("You already entered a card");
		atmMachine.setATMState(atmMachine.getNoCardState());

	}

	@Override
	public void insertPin(int pinEntered) {

		System.out.println("You already entered a PIN");
	}

	@Override
	public void requestCash(int cashToWithdraw) {

		if (cashToWithdraw > atmMachine.cashInMachine) {
			System.out.println("Don't have enough cash available");
			System.out.println("Your card is ejected");
			atmMachine.setATMState(atmMachine.getNoCashState());
		} else {
			System.out.println(cashToWithdraw + " is provided from your account");
			System.out.println("Your card is ejected");
			atmMachine.setATMState(atmMachine.getNoCardState());

			if (atmMachine.cashInMachine <= 0) {
				atmMachine.setATMState(atmMachine.getNoCashState());
			}
		}

	}

}
