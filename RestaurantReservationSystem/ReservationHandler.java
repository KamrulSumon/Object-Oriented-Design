package com.sumon.ood;

public class ReservationHandler {
	
	
	public void dispatchReservation(Reservation reservation){
		ReservationSystem rs = new ReservationSystem();
		rs.makeAReservation(reservation);
	}

}
