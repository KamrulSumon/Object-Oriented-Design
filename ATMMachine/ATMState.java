package com.sumon.prog.ood;

public interface ATMState {
	//State: hasCard, noCard, hasPin, noCash
	void insertCard();
	void ejectCard();
	void insertPin(int pinEntered);
	void requestCash(int cashToWithdraw);
}
