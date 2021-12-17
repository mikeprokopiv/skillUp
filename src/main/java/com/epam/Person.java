package com.epam;

public class Person {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age <= 100) {
            this.age = age;
        }
    }

    public void print() {
        System.out.println("Person's name is " + getName());
        System.out.println("Person's age is " + getAge());
    }

}
