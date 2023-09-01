/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.java.design.patterns.bridge;

// abstraction in bridge pattern
abstract class Vehicle {
    protected IWorkshop workShop1;
    protected IWorkshop workShop2;
 
    protected Vehicle(IWorkshop workShop1, IWorkshop workShop2)
    {
        this.workShop1 = workShop1;
        this.workShop2 = workShop2;
    }
 
    abstract public void manufacture();
}