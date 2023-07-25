/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.java.factory;

interface INotification {
     void userNotification();
}

class SMS implements INotification {

  // Overriding the userNotification method
  public void userNotification() {
    System.out.println("SMS notification sent!");
  }
}

class Email implements INotification {

  // Overriding the userNotification method
  public void userNotification() {
    System.out.println("Email notification sent!");
  }
}

class Push implements INotification {

  // Overriding the userNotification method
  public void userNotification() {
    System.out.println("Push notification sent!");
  }
}

class NotificationFactory {
    public INotification createNotification(String channel)
    {
        if (channel == null || channel.isEmpty())
            return null;

        if(channel == "SMS")
            return new SMS();

        else if(channel == "EMAIL")
            return new Email();

        else if(channel == "PUSH")
            return new Push();

        else{
            throw new IllegalArgumentException("Unknown channel "+channel);
        }
    }
}

public class NotificationServices {

  public static void main(String[] args) {
    NotificationFactory notificationFactory = new NotificationFactory();

    INotification notification = notificationFactory.createNotification("SMS");
    notification.userNotification();
  }
}