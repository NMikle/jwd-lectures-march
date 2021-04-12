package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.model.Department;
import com.epam.jwd.lectures.model.Employee;

public class Main {

    public static void main(String[] args) {
        final Department market = new Department("marketing");
        final Employee vasya = new Employee("Vasya", 25, market);
        final Employee vasyaClone = vasya.clone();
        System.out.println(vasya == vasyaClone);
        System.out.println(vasya.getName() == vasyaClone.getName()); //should be in same place for memory optimization
//        System.out.println(vasya.getAge() == vasyaClone.getAge()); //comparison by value
        System.out.println(vasya.getDepartment() == vasyaClone.getDepartment());
    }
}
