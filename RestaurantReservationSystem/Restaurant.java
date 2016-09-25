package com.sumon.ood;

public class Restaurant {

	public static void main(String[] args) {
		
		ReservationSystem rs = new ReservationSystem();
		rs.initializedReservationSystem(9, 11, 200);
		
		ReservationHandler rh = new ReservationHandler();
		Guest guest = new Guest("Sumon", "4237377548", "hasanm@goldmail.etsu.edu","1403 College Heights Rd");
		Reservation r = new Reservation(12, 1, 5, guest);
		rh.dispatchReservation(r);

	}

}
