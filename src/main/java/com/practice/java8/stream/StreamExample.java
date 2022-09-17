package com.practice.java8.stream;

import com.practice.java8.DTO.Employee;
import com.practice.java8.util.TestUtil;

import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {


    public static void main(String[] args) {
        // Filter Employees with salary >100

        List<Employee> emplyeesWithSalGT100 = TestUtil.loadData().stream().filter(employee -> employee.getSal() > 100).collect(Collectors.toList());
        emplyeesWithSalGT100.stream().forEach(System.out::println);

        // Group all employees by state
        Map<String, List<Employee>> employeesGroupByState = TestUtil.loadData().stream().collect(Collectors.groupingBy(Employee::getAddress, Collectors.toList()));
        for (Map.Entry<String, List<Employee>> entry : employeesGroupByState.entrySet()) {
            entry.getValue().stream().forEach(System.out::println);
        }
        // Group name of all employees by state
        Map<String, List<String>> employeeNamesGroupByState = TestUtil.loadData().stream()
                .collect(Collectors.groupingBy(Employee::getAddress, Collectors.mapping(Employee::getName, Collectors.toList())));
        for (Map.Entry<String, List<String>> entry : employeeNamesGroupByState.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("========");
            entry.getValue().stream().forEach(System.out::println);
            System.out.println();
        }

        // Flattern Stream
        List<Employee> flatList = TestUtil.loadComplexData().stream().flatMap(Collection::stream).collect(Collectors.toList());
        flatList.forEach(System.out::println);

        //Hike time !!! 100% increment this time
        List<Employee> employeesAfterHike = flatList.stream().peek(employee -> employee.setSal(employee.getSal() * 2)).collect(Collectors.toList());
        employeesAfterHike.forEach(System.out::println);

        //Count of employees whose sal is gt 100

        long employeeCountWithSalGT100 = employeesAfterHike.stream().filter(employee -> employee.getSal() > 200).count();
        System.out.println("Employee with sal gt 100  " + employeeCountWithSalGT100);

        //Employees sorted based on their names

        List<Employee> employees = employeesAfterHike.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
        System.out.println("Employees sorted based on their names ");
        employees.forEach(System.out::println);

        //Employees avg sal

        Double avgSal = employees.stream().mapToDouble(Employee::getSal).average().orElse(0);
        System.out.println("Average sal of employees " + avgSal);

        // Sum of all sal
        Long sumOfAllSal = employees.stream().map(Employee::getSal).reduce(0L, Long::sum);
        System.out.println("Sum of sal of employees " + sumOfAllSal);

        String emplyeeNames = employees.stream().map(Employee::getName).collect(Collectors.joining(", "));
        System.out.println("Employee names " + emplyeeNames);

        DoubleSummaryStatistics statistics = employees.stream().mapToDouble(Employee::getSal).summaryStatistics();
        System.out.println("Max " + statistics.getMax() + " Sum " + statistics.getSum() + " Min " + statistics.getMin() + " Avg " + statistics.getAverage());

        //Infinite Streams
        // Generate random numbers
        Stream.generate(Math::random).limit(5).forEach(System.out::println);

    }
}
