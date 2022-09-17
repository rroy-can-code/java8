package com.practice.java8.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
 public class Employee {
    private String name;
    private long sal;
    private String address;

}