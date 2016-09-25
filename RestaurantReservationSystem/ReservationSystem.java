package com.sumon.ood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReservationSystem {
	int startTime;
	int endTime;
	int totalNumberOfSeats;
	
	List<Table> availableTables = new ArrayList<Table>();
	List<Table> occupiedTables = new ArrayList<Table>();
	
	
	public void initializedReservationSystem(int startTime, int endTime, int numberofSeatss){
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalNumberOfSeats = numberofSeatss;
	}
	
	public void makeAReservation(Reservation reservation){
		boolean availability = checkAvailablity(reservation);
	}
	
	public Reservation searchReservation(int reservationID){
		
	}
	
	public Reservation searchReservation(String guestName) {

	}

	public Reservation searchReservation(int startTime, int endTime) {

	}
	
	public Reservation searchReservation(Date date) {

	}
	
	public boolean cancelReservation(int reservationID){
		
	}
	
	/* check for within operation hours */
	public boolean isWithinOperationHours(int startTime, int endTime){
		if(this.startTime <= startTime && this.endTime <= endTime){
			return true;
		}else{
			return false;
		}
	}
	/* check for enough resources and time to full-fill the reservation*/
	public boolean checkAvailablity(Reservation reservation){
		// check for time limit and enough tables
		if(isWithinOperationHours(reservation.startTime, reservation.endTime) && isEnoughTables(reservation)){
			
		}
	}
	
	/* check whether there are enough tables to assign */ 
	public boolean isEnoughTables(Reservation reservation){
		int NPerson = reservation.numberOfPeople;
		//Arrays.sort(availableTables) //sort by desc so that bigger table assign first
		for(Table t : availableTables){
			NPerson -= t.size;
		}
		return NPerson <= 0 ? true : false;
	}
}
