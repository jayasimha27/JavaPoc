/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.java.design.patterns.facade;

public interface IHotelKeeper {

    public VegMenu getVegMenu();

    public NonVegMenu getNonVegMenu();

    public Both getVegNonMenu();

}