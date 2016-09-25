package com.sumon.ood;

//Dispatcher handed over the request to appropriate handler
public class Dispatcher {

	private FourBedRoomApt fourBed;
	private TwoBedRoomApt twoBed;
	private OneBedRoomApt oneBed;

	public Dispatcher() {
		fourBed = new FourBedRoomApt();
		twoBed = new TwoBedRoomApt();
		oneBed = new OneBedRoomApt();
	}

	// hand over the request
	public void dispatch(String request) {

		if (request.equalsIgnoreCase("fourbed")) {
			fourBed.show();
		} else if (request.equalsIgnoreCase("twobed")) {
			twoBed.show();
		} else {
			oneBed.show();
		}
	}
}