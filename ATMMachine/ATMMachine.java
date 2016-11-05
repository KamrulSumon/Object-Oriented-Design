package com.sumon.prog.ood;

public class ATMMachine {

	ATMState hasCard;
	ATMState noCard;
	ATMState hasCorrectPin;
	ATMState atmOutOfMoney;

	ATMState atmState;

	int cashInMachine = 2000;
	boolean correctPinEntered = false;

	public ATMMachine() {

		hasCard = new HasCard(this);
		noCard = new NoCard(this);
		hasCorrectPin = new HasPin(this);
		atmOutOfMoney = new NoCash(this);

		atmState = noCard;

		if (cashInMachine < 0) {

			atmState = atmOutOfMoney;
		}
	}

	// set new state
	public void setATMState(ATMState newATMState) {
		atmState = newATMState;
	}

	// set new cash in ATM
	public void setCashInMachine(int newCashInMachine) {
		cashInMachine = newCashInMachine;
	}

	// insert card
	public void insertCard() {
		atmState.insertCard();
	}

	// eject card
	public void ejectCard() {
		atmState.ejectCard();
	}

	// cash withdraw
	public void requestCash(int cashToWithdraw) {
		atmState.requestCash(cashToWithdraw);
	}

	// pin entered
	public void insertPin(int pinEntered) {
		atmState.insertPin(pinEntered);
	}

	// return state of ATM
	public ATMState getYesCardState() {
		return hasCard;
	}

	public ATMState getNoCardState() {
		return noCard;
	}

	public ATMState getHasPin() {
		return hasCorrectPin;
	}

	public ATMState getNoCashState() {
		return atmOutOfMoney;
	}

}
