package com.example;

public class Calculator {

    int summarization(int a, int b) {
        int result = a + b;
        System.out.println("the result is " + result);
        return result;
    }

    int subtraction(int a, int b) {
        int result = a - b;
        System.out.println("the result is " + result);
        return result;
    }

    int division(int a, int b) {
        if (b == 0) {
            System.out.println("You can not divide by 0, please enter a valid input");
        } else {
            int result = a / b;
            System.out.println("the result is " + result);
            return result;
        }
        return b;
    }

    int multiplication(int a, int b) {
        int result = a * b;
        System.out.println("the result is " + result);
        return result;
    }

}
