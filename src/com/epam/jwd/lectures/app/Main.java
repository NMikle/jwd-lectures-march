package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.model.Department;
import com.epam.jwd.lectures.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        final Department prod = new Department("Production");
        final Department sales = new Department("Sales");
        final Department market = new Department("Marketing");

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Boris", 37, prod));
        employees.add(new Employee("Anna", 25, sales));
        employees.add(new Employee("Anton", 19, market));
        employees.add(new Employee("Bill", 43, sales));
        employees.add(new Employee("Bob", 28, sales));
        employees.add(new Employee("Lucy", 30, prod));

//        Collections.sort(employees);

//        employees.sort(comparing(Employee::getDepartment, comparing(Department::getTitle)).thenComparing(Employee::getName));

//        final Consumer<Employee> println = System.out::println;
//        final long start = new Date().getTime();
//        employees.forEach(println);
//        final long end = new Date().getTime();
//        System.out.println("time: " + (end - start));

//        final Predicate<Employee> employeesOlderThan30 = employee -> employee.getAge() >= 30;
//        final Function<Employee, Department> employeeToDepartment = Employee::getDepartment;
//        final Comparator<Department> byDepartmentTitle = comparing(Department::getTitle);
//        final Consumer<Department> printlnToConsole = System.out::println;
//        final long start = new Date().getTime();
//        employees.stream()
//                .filter(employeesOlderThan30)
//                .map(employeeToDepartment)
//                .sorted(byDepartmentTitle)
//                .distinct()
//                .forEach(printlnToConsole);
//        final long end = new Date().getTime();
//        System.out.println("time: " + (end - start));

//        Map<Department, List<Employee>> employeesByDepartment = new HashMap<>();

//        for (Employee employee : employees) {
//            final Department department = employee.getDepartment();
//            List<Employee> employeesInDepartment = employeesByDepartment.computeIfAbsent(department, k -> new ArrayList<>());
//            employeesInDepartment.add(employee);
//        }

//        final Map<Department, List<Employee>> employeesByDepartment = employees.stream()
//                .collect(
//                        Collectors.groupingBy(
//                                Employee::getDepartment,
//                                Collectors.mapping(Function.identity(), Collectors.toList())
//                        )
//                );

        final Map<Department, List<Employee>> employeesByDepartment = employees.stream()
                .collect(groupingBy(Employee::getDepartment, mapping(identity(), toList())));

        for (Department department : employeesByDepartment.keySet()) {
            System.out.println("Department: " + department.getTitle());
            employeesByDepartment.get(department).forEach(System.out::println);
            System.out.println("------------");
        }

    }

}
