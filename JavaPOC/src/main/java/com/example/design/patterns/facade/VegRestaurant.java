/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.design.patterns.facade;

public class VegRestaurant implements Hotel {
 
    public Menu getMenu()
    {
        Menu v = new VegMenu();
        return v;
    }
}
