package com.sumon.ood;

interface ICallCenter{
	void setNextReceiver(Employee person);
	void receiveCall(Call call);
}


/* person class */
class Person{
	String name;
	String email;
	String phone;
	int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

class Employee extends Person implements ICallCenter{

	Employee employee;
	boolean busy = false;
	
	/* set the next receiver */
	@Override
	public void setNextReceiver(Employee person) {
		this.employee = person;
	}
	
	/* receive the call to handle if can't transfer to the appropriate handler */
	@Override
	public void receiveCall(Call call) {
		if(!busy){
			busy = true;
			System.out.println("Handling call from " + call.caller.getName()+ " -> Employee: " + getName());
			try {
				Thread.sleep(1000);
				busy = false;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("Can't handle call at this moment, trasfer call to" + employee.getName());
			employee.receiveCall(call);
		}
		
	}

}

class Respondent extends Employee{
	public Respondent(String name){
		this.name = name;
	}
}

class Manager extends Employee{
	public Manager(String name){
		this.name = name;
	}

}

class Director extends Employee{
	public Director(String name){
		this.name = name;
	}

}

/* class caller */ 
class Caller extends Person{
	
	public Caller(String name){
		this.name = name;
	}
	
	public Caller(){
		
	}

}

/* class Call */
class Call{
	Caller caller;
	Employee handler;
	public Call(Caller caller){
		this.caller = caller;
	}
}

/* class Call Handler */
class CallHandler{
	/* dispatch the call to the handler */
	public void dispatchCall(Call call, Employee handler){
		handler.receiveCall(call);
	}
}

/* Driver class */
public class CallCenter {

	public static void main(String[] args) {
		
		Employee respondent = new Respondent("Respondent");
		Employee manager = new Manager("Manager");
		Employee director = new Director("Director");
		
		respondent.setNextReceiver(manager);
		manager.setNextReceiver(director);
		
		Caller caller = new Caller("Sumon");
		Call call = new Call(caller);
		CallHandler handler = new CallHandler();
		handler.dispatchCall(call, respondent);
		
		caller = new Caller("Kamrul");
	    call = new Call(caller);
		handler.dispatchCall(call, respondent);


	}

}
