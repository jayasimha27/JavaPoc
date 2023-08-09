/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.java.design.patterns.factory;

class Factory {

    public static void main(String[] args) {

        Transport t1 = CabService.getInstance().getCab("CAR");
        System.out.println(t1.getRate());

        Transport t2 = CabService.getInstance().getCab("BIKE");
        System.out.println(t2.getRate());

    }
}

class CabService {

    private static CabService onlyInstance;

    // Make the constructor private so its only accessible to
    // members of the class.
    private CabService() {
    }

    // Create a static method for object creation
    synchronized public static CabService getInstance() {

        if (onlyInstance == null) {
            // Only instantiate the object when needed.
            synchronized (CabService.class) {
                if (onlyInstance == null) {
                    onlyInstance = new CabService();
                }
            }
        }
        return onlyInstance;
    }

    public Transport getCab(String type) {
        return new CabFactory().getTransport(type);
    }
}

class CabFactory {

    //Factory method that returns transport based on type requested
    public Transport getTransport(String type) {
        switch (type) {
            case "CAR":
                return new Car();
            case "BIKE":
                return new Bike();
            default:
                return null;
        }
    }
}

//Transport abstract class
abstract class Transport {

    double rate = 0;

    public double getRate() {
        return rate;
    }
}

class Car extends Transport {

    double rate = 10;

    public double getRate() {
        return rate;
    }
}

class Bike extends Transport {

    double rate = 5;

    public double getRate() {
        return rate;
    }
}
