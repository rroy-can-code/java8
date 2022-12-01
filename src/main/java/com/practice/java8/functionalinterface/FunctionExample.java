package com.practice.java8.functionalinterface;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, Double> half = val -> val / 2.0;
        half = half.compose(a -> a * 3);
        half = half.andThen(a -> a + 3.0);
        System.out.println(half.apply(10));
    }
}
