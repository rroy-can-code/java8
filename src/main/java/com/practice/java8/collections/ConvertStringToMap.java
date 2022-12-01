package com.practice.java8.collections;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Write a method using java8 which takes input as a string of the following format.
 * And returns a collection containing the key-value pairs from the input string.
 * “name=Megha&company=Cropin.&phone=9566&city=Blr”
 */
public class ConvertStringToMap {
    public static void main(String[] args) {
        String string ="name=Rahul&company=Cropin.&phone=9566&city=Blr";
        Map<String, String> map = Arrays.stream(string.split("&"))
                .map(str-> str.split("="))
                .collect(Collectors.toMap(str->str[0], string1->string1[1]));
        System.out.println(map);

    }
}
