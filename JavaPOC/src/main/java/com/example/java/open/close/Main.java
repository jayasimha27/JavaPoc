/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.java.open.close;

// Java Program to illustrate Open Closed Principle
 
// Class 1
// Helper class
// To store dimensions of a cuboid
// length, breadth and height
class Cuboid {
     
    // Member variables
    public double length;
    public double breadth;
    public double height;
}
 
// Class 2
// Helper class
// To calculate the volume of geometric objects
class Application {
 
    // It returns the total volume of the geometric objects
    public double get_total_volume(Cuboid[] geo_objects)
    {
        // Variable to store total volume
        double vol_sum = 0;
 
        // Iteratively calculating the volume of each object
        // and adding it to the total volume
        for (Cuboid geo_obj : geo_objects) {
             
            // Iteratively calculating the volume of each object
            // and adding it to the total volume
            vol_sum += geo_obj.length * geo_obj.breadth
                       * geo_obj.height;
        }
 
        // returning the to total volume
        return vol_sum;
    }
}
 
// Class 3
// Main Class
// To demonstrate working of all classes
public class Main {
 
    // Main driver method
    public static void main(String args[])
    {
        // Initializing a cuboid one & declaring dimensions by
        // creating an object of Cuboid class in main() method
        Cuboid cb1 = new Cuboid();
 
        // Custom entries
        cb1.length = 5;
        cb1.breadth = 10;
        cb1.height = 15;
 
        // Similarly, initializing a cuboid2 and declaring dimensions
        // by creating object of Cuboid class in the main() method
        Cuboid cb2 = new Cuboid();
 
        // Custom entries
        cb2.length = 2;
        cb2.breadth = 4;
        cb2.height = 6;
 
        // Initializing a cuboid3 and declaring dimensions by
        // creating object of Cuboid class in the main() method
        Cuboid cb3 = new Cuboid();
 
        // Custom entries
        cb3.length = 3;
        cb3.breadth = 12;
        cb3.height = 15;
 
        // Now, declaring andinitializing Array of cuboids
        Cuboid[] c_arr = new Cuboid[3];
        c_arr[0] = cb1;
        c_arr[1] = cb2;
        c_arr[2] = cb3;
 
        // Initializing the Application class
        Application app = new Application();
         
        // Getting the total volume
        // using get_total_volume
        double vol = app.get_total_volume(c_arr);
         
        // Print and Display the Total Volume
        System.out.println("The total volume is " + vol);
    }
}