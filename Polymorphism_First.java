package com.Lecture12;

public class Polymorphism_First {

public static void display(){
System.out.println("This is a non parametrized display Method");
}
public static void display(int i){
System.out.println("This is a int parameter display Method");
}
public static void display(int i, int j){
System.out.println("This is a multiple int parameter display Method");
}
public static void display(String s){
System.out.println("This is a string parameter display Method");
}
public static void display(String s1, String s2){
System.out.println("This is a multiple string parameter display Method");
}
public static void display(int i, String s1){
System.out.println("This is a int and string parameter display Method");
}
public static void display(String s1, int i ){
System.out.println("This is a string and integer parameter display Method");
}
public static void display(StringBuffer S){
System.out.println("This is a StringBuffer parameter display Method");
}
public static void display(StringBuilder S){
System.out.println("This is a StringBuilder parameter display Method");
}
public static void display(StringBuffer S1, String s2){
System.out.println("This is a StringBuffer and string parameter display Method");
}
public static void display(StringBuilder S1, StringBuffer S2){
System.out.println("This is a StringBuilder and String Buffer parameter display Method");
}

public static void main(String[] args) {
display();
display(1);
display(2,3);
display("Hello");
display("Hello, Taranvir");
display(10,"Taranvir");
display("Taranvir",10);
display(new StringBuffer("Hello"));
display(new StringBuilder("Taranvir"));
display(new StringBuffer("Hello"), "Singh");
display(new StringBuilder("Hello"),new StringBuffer("Singh"));
}

}
