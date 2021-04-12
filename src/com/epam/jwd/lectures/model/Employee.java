package com.epam.jwd.lectures.model;

import java.util.Objects;

public class Employee implements Comparable<Employee>, Cloneable {

    private final String name;
    private final int age;
    private final Department department;

    public Employee(String name, int age, Department department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public Employee clone() {
        try {
            final Employee empClone = (Employee) super.clone();
            final Department departmentClone = this.department.clone();
            return new Employee(empClone.name, empClone.age, departmentClone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new IllegalStateException("Cloneable interface should be implemented");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(age, o.getAge());
    }
}
