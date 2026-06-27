package com;

public class Calculator {

    // ❌ BUG: No validation (division by zero possible)
    public int divide(int a, int b) {
        return a / b;
    }

    // ❌ BUG: No validation (modulus by zero possible)
    public int modulus(int a, int b) {
        return a % b;
    }

    // ❌ DUPLICATE LOGIC
    public int multiply(int a, int b) {
        return a * b;
    }

    public int multiply2(int a, int b) {
        return a * b;
    }

    // ❌ DUPLICATE LOGIC
    public int add(int a, int b) {
        return a + b;
    }

    public int addAgain(int a, int b) {
        return a + b;
    }

    public int sum1(int a, int b) {
        return a + b;
    }

    public int sum2(int a, int b) {
        return a + b;
    }

    // ❌ BAD DESIGN: deep nesting + unused variable
    public int complexCalculation(int a, int b) {

        int temp1 = a + b;
        int temp2 = a * b;
        int temp3 = a - b;

        int unusedVariable = 999;

        if (temp1 > 0) {
            if (temp2 > 0) {
                if (temp3 > 0) {
                    if (a > 0) {
                        if (b > 0) {
                            return temp1 + temp2 + temp3;
                        }
                    }
                }
            }
        }

        return 0;
    }

    // ❌ BUG: unsafe division
    public int unsafeDivide(int a, int b) {
        return a / b;
    }

    // ❌ DEAD CODE (never used in real flow)
    private void unusedMethod() {
        System.out.println("This method is never used anywhere");
    }

    // ❌ BAD NAMING
    public int calc(int x, int y) {
        return x + y * 2;
    }

    // ❌ MAGIC NUMBER + unclear logic
    public int process(int a, int b) {
        int result = a + b * 10 - 5;
        return result;
    }

    // ❌ ANOTHER DUPLICATE METHOD
    public int addition(int a, int b) {
        return a + b;
    }
}
