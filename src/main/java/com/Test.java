package com;

public class Test {
	  public static void main(String[] args) {



        Calculator c = new Calculator();



        System.out.println("Add: " + c.add(10, 5));

        System.out.println("Multiply: " + c.multiply(10, 5));

        System.out.println("Divide: " + c.divide(10, 0)); // ❌ Runtime crash (bug)

    }

}
