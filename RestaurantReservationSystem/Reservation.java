package com.sumon.ood;

import java.util.Calendar;
import java.util.Date;

public class Reservation {
	int id;
	int numberOfPeople;
	int startTime;
	int endTime;
	Date date;
	Guest guest;
	boolean status;
	
	public Reservation(int startTime, int endTime, int numberOfPeople, Guest guest){
		this.numberOfPeople = numberOfPeople;
		this.startTime = startTime;
		this.endTime = endTime;
		this.guest = guest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
