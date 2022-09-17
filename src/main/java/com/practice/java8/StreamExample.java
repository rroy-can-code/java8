package com.practice.java8;

import com.practice.java8.DTO.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {


    public static void main(String[] args) {
        // Filter Employees with salary >100

        List<Employee> emplyeesWithSalGT100 = TestUtil.loadData().stream().filter(employee -> employee.getSal() > 100).collect(Collectors.toList());
        emplyeesWithSalGT100.stream().forEach(System.out::println);

        // Group all employees by state
        Map<String, List<Employee>> employeesGroupByState= TestUtil.loadData().stream().collect(Collectors.groupingBy(Employee::getAddress,Collectors.toList()));
        for (Map.Entry<String, List<Employee>> entry:employeesGroupByState.entrySet()) {
            entry.getValue().stream().forEach(System.out::println);
        }



    }
}
