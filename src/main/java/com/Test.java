package com;

public class Test {
	  public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println("Add: " + calc.add(10, 5));
        System.out.println("Multiply: " + calc.multiply(10, 5));
        System.out.println("Divide: " + calc.divide(10, 5));
        System.out.println("Modulus: " + calc.modulus(10, 5));
        System.out.println("Process: " + calc.process(10, 5));
    }

}
