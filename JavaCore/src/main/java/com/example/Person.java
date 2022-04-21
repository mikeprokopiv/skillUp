package com.example;

class Person {
    String name;
    int age;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        if (age > 0 && age <= 100) {
            this.age = age;
        }
    }

    void print() {
        System.out.println("Person's name is " + getName());
        System.out.println("Person's age is " + getAge());
    }

}