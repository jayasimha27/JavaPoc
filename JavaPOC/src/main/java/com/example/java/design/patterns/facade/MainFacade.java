/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.java.design.patterns.facade;

public class MainFacade
{
    public static void main (String[] args)
    {
        IHotelKeeper keeper = new HotelKeeperImplementation();
         
        VegMenu v = keeper.getVegMenu();
        NonVegMenu nv = keeper.getNonVegMenu();
        Both both= keeper.getVegNonMenu();
 
    }
}