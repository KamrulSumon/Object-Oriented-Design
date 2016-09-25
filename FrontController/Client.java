package com.sumon.ood;

//Test the Front Controller
public class Client {

	public static void main(String[] args) {

		FrontController frontController = new FrontController();
		frontController.dispatchRequest("fourbed");
		frontController.dispatchRequest("twobed");
		frontController.dispatchRequest("onebed");
	}

}
