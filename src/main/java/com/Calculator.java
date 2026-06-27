package com;
public class Calculator {



    // ❌ BUG: No validation for division

    public int divide(int a, int b) {

        return a / b;

    }



    // ❌ BUG: No validation for modulus

    public int modulus(int a, int b) {

        return a % b;

    }



    // ❌ CODE SMELL: Duplicate logic (same as multiply2)

    public int multiply(int a, int b) {

        return a * b;

    }



    public int multiply2(int a, int b) {

        return a * b;

    }



    // ❌ CODE SMELL: Duplicate logic again

    public int add(int a, int b) {

        int result = a + b;

        return result;

    }



    public int addAgain(int a, int b) {

        return a + b;

    }



    // ❌ CODE SMELL: Unused variable + long method

    public int complexCalculation(int a, int b) {



        int temp1 = a + b;

        int temp2 = a * b;

        int temp3 = a - b;



        int unusedVariable = 100; // Sonar will flag this



        if (temp1 > 0) {

            if (temp2 > 0) {

                if (temp3 > 0) {

                    return temp1 + temp2 + temp3;

                }

            }

        }



        return temp1;

    }



    // ❌ BUG: possible division by zero

    public int unsafeDivide(int a, int b) {

        return a / b;

    }



    // ❌ CODE SMELL: Dead code (never used)

    private void unusedMethod() {

        System.out.println("This method is never used");

    }



    // ❌ CODE SMELL: Hardcoded logic + poor naming

    public int calc(int x, int y) {

        return x + y * 2;

    }



    // ❌ CODE SMELL: Duplicate again

    public int sum1(int a, int b) {

        return a + b;

    }



    public int sum2(int a, int b) {

        return a + b;

    }

  

}

