package com.practice.java8.stream;

import com.practice.java8.DTO.Employee;
import com.practice.java8.util.TestUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamImpl {

    public List<Employee> empWithSalaryGt100() {
        return TestUtil.loadData()
                .stream()
                .filter(employee -> employee.getSal() > 100)
                .collect(Collectors.toList());
    }

    public Map<String, List<Employee>> groupEmployeesByState() {
        return TestUtil.loadData()
                .stream()
                .collect(Collectors.groupingBy(Employee::getAddress, Collectors.toList()));
    }

    public Map<String, List<String>> nameOfEmployeesByState() {
        return TestUtil.loadData().stream()
                .collect(Collectors.groupingBy(Employee::getAddress, Collectors.mapping(Employee::getName, Collectors.toList())));
    }


    public List<Employee> getFlatList() {
        List<Employee> flatList = TestUtil.loadComplexData()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return flatList;
    }

    public List<Employee> getEmployeesAfterHike() {
        List<Employee> employeesAfterHike = getFlatList()
                .stream()
                .peek(employee -> employee.setSal(employee.getSal() * 2))
                .collect(Collectors.toList());
       // employeesAfterHike.forEach(System.out::println);
        return employeesAfterHike;
    }

    //Count of employees whose sal is gt 200
    public long countEmployeesWithSalGt200() {
        return getEmployeesAfterHike()
                .stream()
                .filter(employee -> employee.getSal() > 200)
                .count();
    }

    //Employees sorted based on their names
    public List<Employee> sortedEmployeesByNames() {
        return getEmployeesAfterHike()
                .stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    //Employees avg sal
    public double avgSalOfEmployees() {
        return getEmployeesAfterHike()
                .stream()
                .mapToDouble(Employee::getSal)
                .average()
                .orElse(0);
    }

    // Sum of all sal
    public long getSumOfAllSal() {
        return getEmployeesAfterHike()
                .stream()
                .map(Employee::getSal)
                .reduce(0L, Long::sum);

    }

    public void displayEmployeeSummary() {
        DoubleSummaryStatistics statistics = getEmployeesAfterHike()
                .stream()
                .mapToDouble(Employee::getSal)
                .summaryStatistics();
        System.out.println("Max " + statistics.getMax()
                + " Sum " + statistics.getSum()
                + " Min " + statistics.getMin()
                + " Avg " + statistics.getAverage());
    }


    public String getConcatenatedEmployeeNames() {
        return getEmployeesAfterHike()
                .stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
    }

    public void generateKRandomNumbers(int k) {
        Stream.generate(Math::random)
                .limit(k)
                .forEach(System.out::println);
    }

}
