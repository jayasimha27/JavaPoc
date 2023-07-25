/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.java.single.resposibilty;

class DeliveryApp {
 
    private Order order;
    public DeliveryApp(Order order) { this.order = order; }
 
    public void delivery()
    {
        // Here, we would want to interface with another
        // system which actually assigns the task of
        // delivery to different persons
        // based on location, etc.
        System.out.println("Delivering the order");
        System.out.println(
            "Order with order id as "
            + this.order.getOrderId()
            + " being delivered to "
            + this.order.getCustomer().getName());
        System.out.println(
            "Order is to be delivered to: "
            + this.order.getCustomer().getAddress());
    }
}