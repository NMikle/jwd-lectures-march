package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.model.Department;
import com.epam.jwd.lectures.model.Employee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        final Department sales = new Department("Sales");
        final Employee boris = new Employee("Boris", 39, sales);
        System.out.println("Serialization");

        try (final ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("res/emp.o"))) {
            outputStream.writeObject(boris);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Deserialization");
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("res/emp.o"))) {
            final Employee employee = (Employee) inputStream.readObject();
            System.out.println(employee);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            e.printStackTrace();
        }
    }
}
