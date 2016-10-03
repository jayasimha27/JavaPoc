/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.structure;

import java.util.Objects;

/**
 *
 * @author Jayasimha<jayasimha.bj@gmail.com>
 */
public class Employee {

    public String id;
    private String name;
    private String department;
    private float grossSalary;
    private static double bonus = 100000;

    public Employee() {

    }

    public Employee(String pId, String pName, String pDepartment, float pGrossSalary) {
        super();
        this.id = pId;
        this.name = pName;
        this.department = pDepartment;
        this.grossSalary = pGrossSalary;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(float grossSalary) {
        this.grossSalary = grossSalary;
    }

    public static double getBonus() {
        return bonus;
    }

    public static void setBonus(double bonus) {
        Employee.bonus = bonus;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID =");
        builder.append(id);
        builder.append("\n");

        builder.append("Name =");
        builder.append(name);
        builder.append("\n");

        builder.append("Department =");
        builder.append(department);
        builder.append("\n");

        builder.append("Gross Salary =");
        builder.append(grossSalary);
        builder.append("\n");

        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee emp = (Employee) obj;

        return emp.id.equals(id)
                && emp.name.equals(name)
                && emp.department.equals(department)
                && emp.grossSalary == grossSalary;

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.department);
        hash = 41 * hash + Float.floatToIntBits(this.grossSalary);
        return hash;
    }

}
