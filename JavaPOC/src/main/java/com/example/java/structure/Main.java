/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.structure;

/**
 *
 * @author jjagadee
 */
public class Main {

    public static void main(String[] args) {
        Employee emp1;
        emp1 = new Employee();
        emp1.setId("33043");
        emp1.setName("jayasimha");
        emp1.setDepartment("ACS");
        emp1.setGrossSalary(1500000);

        Employee emp2 = new Employee("33043", "jayasimha", "ACS", 1500000);

        Employee.setBonus(1000000);

        while (true) {
            if (emp1 == emp2) {
                System.out.println("Both are instances of Employee Class");
            }
            if (emp1.equals(emp2)) {
                System.out.println("Object State Matching");
            }

        }

    }

}
