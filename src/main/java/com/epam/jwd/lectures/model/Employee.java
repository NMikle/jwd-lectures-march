package com.epam.jwd.lectures.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

public class Employee implements Comparable<Employee>, Cloneable, Externalizable {

    private static final long serialVersionUID = 6894009947126375331L;

    /*private final String name;
    private final int age;
    private final Department department;*/

    private String name;
    private int age;
    private Department department;

    public Employee() {
        System.out.println("Default constructor for employee");
    }

    public Employee(String name, int age, Department department) {
        System.out.println("All fields constructor for employee");
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
        out.writeInt(this.age);
        out.writeObject(this.department);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.age = in.readInt();
        this.department = (Department) in.readObject();
    }
}
