package com.epam;

public class App {
    public static void main(String[] args) {

        //initiating instance and method call for LongestWord class
        LongestWord longestWord = new LongestWord();
        longestWord.longestWord("My example sentence");

        //initiating instance and method call for ReverseWord class
        ReverseWord reverseWord = new ReverseWord();
        reverseWord.reverseWord("Hello World");

        //initiating instance and method call for Calculator class
        Calculator c = new Calculator();
        c.summarization(3, 2); // result should be 5
        c.division(8, 2); // result should be 4
        c.subtraction(5, 2); //result should be 3
        c.multiplication(2, 3); //result should be 6

        //initiating instance and method call for Capitalizer class
        Capitalizer capitalizer = new Capitalizer();
        capitalizer.capitalize("My example sentence");

        //initiating instance and method call for Factorial class
        Factorial factorial = new Factorial();
        factorial.factorial(14);

        //initiating instance and method call for Person class
        Person p1 = new Person();
        p1.setName("Steve");
        p1.setAge(34);
        p1.print();
    }
}
