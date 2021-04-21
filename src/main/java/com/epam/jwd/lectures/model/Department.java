package com.epam.jwd.lectures.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

public class Department implements Cloneable, Serializable {

    private static final long serialVersionUID = -1158832209795294894L;

    //    private final String title;
    private String title;

//    public Department() {
//        System.out.println("default constructor for department");
//    }

    public Department(String title) {
        System.out.println("all fields constructor for department");
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public Department clone() {
        try {
            return (Department) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new IllegalStateException("Cloneable!!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Department{" +
                "title='" + title + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        System.out.println("Serializing department's title");
        outputStream.writeObject(this.title);
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        System.out.println("Deserializing department's title");
        this.title = String.valueOf(inputStream.readObject());
    }
}
