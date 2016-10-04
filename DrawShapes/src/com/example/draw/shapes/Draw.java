/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.draw.shapes;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import static javafx.application.Platform.exit;

/**
 *
 * @author Jayasimha
 */
public class Draw {

    public static void main(String[] args) {
        int i = 5;
        ShapeFactory shapeFactory = new ShapeFactory();

        //get an object of Circle and call its draw method.
        IShape shape1 = shapeFactory.getShape("CIRCLE");

        //call draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        IShape shape2 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Rectangle
        shape2.draw();

        //get an object of Square and call its draw method.
        IShape shape3 = shapeFactory.getShape("SQUARE");

        //call draw method of circle
        shape3.draw();

    }

}
