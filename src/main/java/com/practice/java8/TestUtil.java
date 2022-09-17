package com.practice.java8;

import com.practice.java8.DTO.Employee;

import java.util.Arrays;
import java.util.List;

public class TestUtil {
    public static List<Employee> loadData(){
        return Arrays.asList(new Employee("Rahul", 100,"Bangalore"),
                new Employee("Raj", 1000,"Bangalore"),
                new Employee("Ram", 1000,"Hydrabad"),
                new Employee("Raja", 100,"Gurugram"),
                new Employee("Raghu", 10000,"Bangalore"));
    }
}
