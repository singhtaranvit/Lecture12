package com.Lecture12;

public class Child_Method_Overriding extends Parent_Method_Overriding{

	public static void main(String[] args) {
		Child_Method_Overriding cMO =  new Child_Method_Overriding();
		cMO.display();
		cMO.cash();

	}
	@Override
	public void display() {
		System.out.println("This is child display");
	}

	@Override
	public void cash() {
		System.out.println("This is child cash");
}
}