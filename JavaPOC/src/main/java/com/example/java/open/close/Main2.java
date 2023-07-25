/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.java.open.close;

// Java Program to illustrate Open Closed Principle
 
// Importing all classes from java.math package
// to compute mathematic calculations
import java.math.*;
 
// Class 1
// Helper Class
// Abstract class--which needs to be extended
abstract class Geo_objects {
 
   // Abstract function--which needs to overriden
    public abstract double get_volume();
}
 
// Class 2
// Helper Class
// Extending the Geo_objects to fit cuboid dimensions
class Cuboid_2 extends Geo_objects {
     
    // used to store length, breadth and height of a cuboid
 
    public double length;
    public double breadth;
    public double height;
 
    // overrided function to calculate
    // the volume of a cuboid
    // @Override
    public double get_volume()
    {
        return length * breadth * height;
    }
}
 
// Class 3
// Helper Class
// Extending Geo_objects to fit sphere dimension
 class Sphere_2 extends Geo_objects {
     
    // To store radius of a sphere
    public double radius;
 
    // Overrided function to calculate
    //  the volume of a sphere
     
    //@Override
    public double get_volume()
    {
        return (4 / 3) * Math.PI * radius * radius * radius;
    }
}
 
// Class 4
// Helper class
// To calculate the volume of geometric objects
class Application2 {
 
    public double
        get_total_volume(Geo_objects[] geo_objects)
    {
        // Initially initializing sum to zero
        double vol_sum = 0;
 
        // Iterating using for each loop
        for (Geo_objects geo_obj : geo_objects) {
            vol_sum += geo_obj.get_volume();
        }
  
        return vol_sum;
    }
}
 
// Class 5
// Main class
// To demonstrate working of all classes
public class Main2 {
 
    // Main driver method
    public static void main(String args[])
    {
        // Initializing cuboid1 as well as declaring
        // its dimensions.
        Cuboid_2 cb1 = new Cuboid_2();
 
        // Custom entries
        cb1.length = 5;
        cb1.breadth = 10;
        cb1.height = 15;
 
        // Initializing Cuboid2 as well as declaring
        // its dimensions.
        Cuboid_2 cb2 = new Cuboid_2();
        cb2.length = 2;
        cb2.breadth = 4;
        cb2.height = 6;
 
        // initializing Cuboid3 as well as declaring
        // its dimensions.
        Cuboid_2 cb3 = new Cuboid_2();
        cb3.length = 3;
        cb3.breadth = 12;
        cb3.height = 15;
 
        // initializing Sphere1 as well as declaring
        // its dimension.
        Sphere_2 sp1 = new Sphere_2();
        sp1.radius = 5;
 
        // initializing Sphere2 as well as declaring
        // its dimension.
        Sphere_2 sp2 = new Sphere_2();
        sp2.radius = 2;
 
        // initializing Sphere3 as well as declaring
        // its dimension.
        Sphere_2 sp3 = new Sphere_2();
        sp3.radius = 3;
 
        // Now, initializing and declaring
        // an array of Geo_objects
        Geo_objects[] g_arr = new Geo_objects[6];
 
        // Setting Geo_objects to cuboid class
        g_arr[0] = cb1;
        g_arr[1] = cb2;
        g_arr[2] = cb3;
 
        // Setting Geo_objects to sphere class
        g_arr[3] = sp1;
        g_arr[4] = sp2;
        g_arr[5] = sp3;
 
        // Initializing the Application class
        Application2 app = new Application2();
         
        // Getting the total volume
        // using get_total_volume
        double vol = app.get_total_volume(g_arr);
 
        // Printing total volume
        System.out.println("The total volume is " + vol);
    }
}