package com.practice.java8.multithreading;

public class EvenOddNumberPrinter {

    public static void main(String[] args) {
        Printer even = new Printer(0);
        Printer odd = new Printer(1);
        Thread evenThread = new Thread(even, "Even Thread");
        Thread oddThread = new Thread(odd, "Odd Thread");
        evenThread.start();
        oddThread.start();
    }
}
