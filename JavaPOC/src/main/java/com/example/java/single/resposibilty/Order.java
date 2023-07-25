/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.java.single.resposibilty;

import java.util.Random;

class Order {
 
    private Customer customer;
    private String orderId;
    private String itemName;
    private int quantity;
    private int totalBillAmt;
 
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId)
    {
        Random random = new Random();
 
        this.orderId = orderId + "-" + random.nextInt(500);
    }
    public String getItemName() { return itemName; }
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
        setOrderId(itemName);
    }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public int getTotalBillAmt() { return totalBillAmt; }
    public void setTotalBillAmt(int totalBillAmt)
    {
        this.totalBillAmt = totalBillAmt;
    }
 
    public void prepareOrder()
    {
        System.out.println("Preparing order for customer -"
                           + this.getCustomer().getName()
                           + " who has ordered "
                           + this.getItemName());
    }
}