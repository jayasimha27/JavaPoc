/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.design.patterns.facade;

 
public class VegNonBothRestaurant implements Hotel {
 
    public Menu getMenu()
    {
        Both b = new Both();
        return b;
    }
}