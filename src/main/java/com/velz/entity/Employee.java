package com.velz.entity;

import java.util.Objects;
//
public class Employee {
    private int id;
    private String name;
    private EmployeeRank rank;

    public Employee(int id, String name, EmployeeRank rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", rank=" + rank +
               '}';
    }
}
