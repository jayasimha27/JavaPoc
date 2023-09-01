/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.java.design.patterns.bridge;

// Refine abstraction 1 in bridge pattern
class Car extends Vehicle {
    public Car(IWorkshop workShop1, IWorkshop workShop2)
    {
        super(workShop1, workShop2);
    }
 
    @Override
    public void manufacture()
    {
        System.out.print("Car ");
        workShop1.work();
        workShop2.work();
    }
}
 