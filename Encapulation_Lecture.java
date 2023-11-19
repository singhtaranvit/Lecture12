package com.Lecture12;

public class Encapulation_Lecture {

	private int value;

	public void setValue(int x) {

		value =x;

	}
	public int getValue() {
		return value;
	}
	static class Encapsulation2
	{

	public static void main(String[] args) {
		Encapulation_Lecture enC= new Encapulation_Lecture();
		enC.setValue(100);
		System.out.println(enC.getValue());
	}

}
}