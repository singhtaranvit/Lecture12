package com.Lecture12;

public class Child_Abstraction extends Abstraction {
	public static void main(String[] args) {
		Child_Abstraction cA = new Child_Abstraction();
		cA.logic();
		cA.secret();

	}
		@Override
	public void logic() {
		System.out.println("This is over-ridden logic method");

	}

	@Override
	public void secret() {
		System.out.println("This is over-ridden secret method");

	}

}

