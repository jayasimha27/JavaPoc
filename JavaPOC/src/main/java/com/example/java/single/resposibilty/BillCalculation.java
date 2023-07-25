/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.java.single.resposibilty;

import java.util.Random;

class BillCalculation {
 
    private Order order;
    public BillCalculation(Order order)
    {
        this.order = order;
    }
 
    public void calculateBill()
    {
        /* In the real world, we would want a kind of lookup
          functionality implemented here where we look for
          the price of each item included in the order, add
          them up and add taxes, delivery charges, etc on
          top to reach the total price. We will simulate
          this behaviour here, by generating a random number
          for total price.
        */
        Random rand = new Random();
        int totalAmt
            = rand.nextInt(200) * this.order.getQuantity();
 
        this.order.setTotalBillAmt(totalAmt);
        System.out.println("Order with order id  "
                           + this.order.getOrderId()
                           + " has a total bill amount of "
                           + this.order.getTotalBillAmt());
    }
}