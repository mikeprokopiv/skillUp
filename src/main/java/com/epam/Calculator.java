package com.epam;

public class Calculator {

    public int summarization(int a, int b) {
        int result = a + b;
        System.out.println("the result is " + result);
        return result;
    }

    public int subtraction(int a, int b) {
        int result = a - b;
        System.out.println("the result is " + result);
        return result;
    }

    public int division(int a, int b) {
        if (b == 0) {
            System.out.println("You can not divide by 0, please enter a valid input");
        } else {
            int result = a / b;
            System.out.println("the result is " + result);
            return result;
        }
        return b;
    }

    public int multiplication(int a, int b) {
        int result = a * b;
        System.out.println("the result is " + result);
        return result;
    }

}
