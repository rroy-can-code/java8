package com.practice.java8.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Bangalore", "Chennai", "Kerala", "Kolkata");
        /**
         * Boolean valued function
         */
        Predicate<String> anyStringStartedWithK = (elt) -> elt.startsWith("K");
        for (String s : strings) {
            if (anyStringStartedWithK.test(s)) {
                System.out.println(s);
            }
        }

        Predicate<Integer> lt10 = number -> number > 10;
        Predicate<Integer> gt20 = number -> number < 20;
        System.out.println(lt10.and(gt20).test(15));
        //To reverse output of a predicate
        System.out.println(lt10.and(gt20).negate().test(15));

        System.out.println("If number greater than 7 " + testNumber(10, i -> i > 7));

        Predicate<String> isNotEmpty = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 0;
            }
        };
        Predicate<String> isContainsA = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("A");
            }
        };
        System.out.println(isNotEmpty.or(isContainsA).test(""));

    }

    private static boolean testNumber(int number, Predicate<Integer> predicate) {
        return predicate.test(number);
    }


}
