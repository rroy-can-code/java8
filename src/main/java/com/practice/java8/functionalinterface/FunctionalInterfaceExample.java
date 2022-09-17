package com.practice.java8.functionalinterface;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Square square = x -> x * x;
        System.out.println(square.area(8));
    }

    //FI is interface with one abstract method or can have multiple default methods
    @FunctionalInterface
    interface Square {
        int area(int val);
    }
}
