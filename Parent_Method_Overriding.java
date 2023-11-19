package com.Lecture12;

public class Parent_Method_Overriding {

	public static void main(String[] args) {
		Parent_Method_Overriding pMO = new Parent_Method_Overriding();
		pMO.display();
		pMO.cash();
	}

	public void display() {
		System.out.println("This is parent class display");
	}

	public void cash() {
		System.out.println("This is parent cash");
	}
}
