package com.practice.java8.stream;

public class StreamExample {

    public static void main(String[] args) {
        StreamImpl streamExample = new StreamImpl();
        System.out.println(streamExample.groupEmployeesByState());
        System.out.println(streamExample.nameOfEmployeesByState());
    }
}
