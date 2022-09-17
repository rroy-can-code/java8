package com.practice.java8.multithreading;

class Printer implements Runnable {
    static final Object lock = new Object();
    static int counter = 1;
    int remainder;

    public Printer(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            synchronized (lock) {
                while (counter % 2 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + counter++);
                lock.notify();
            }
        }
    }

}
