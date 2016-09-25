package com.sumon.ood;

//act as Front controller that accept the request and send to dispatcher 
public class FrontController {

	private Dispatcher dispatcher;

	public FrontController() {
		dispatcher = new Dispatcher();
	}

	// check for valid user
	private boolean isAuthenticateUser() {
		System.out.println("User is Authenticated Successfully");
		return true;
	}

	// log the request
	private void logRequest(String req) {
		System.out.println("Apt requested: " + req);
	}

	//dispatch the request
	public void dispatchRequest(String request) {
		logRequest(request);

		if (isAuthenticateUser()) {
			dispatcher.dispatch(request);
		}
	}
}
