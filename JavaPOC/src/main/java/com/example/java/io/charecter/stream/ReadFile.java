/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.io.charecter.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jjagadee
 */
public class ReadFile {

    public static void main(String[] args) {
        String file = "";
        // try opening the file with FileReader
        try (FileReader inputFile = new FileReader(file)) {
            int ch = 0;
            // while there are characters to fetch, read, and print the
            // characters when EOF is reached, read() will return −1,
            // terminating the loop
            while ((ch = inputFile.read()) != -1) {
                // ch is of type int - convert it back to char
                // before printing
                System.out.print((char) ch);
            }
        } catch (FileNotFoundException fnfe) {
            // the passed file is not found ...
            System.err.printf("Cannot open the given file %s ", file);
        } catch (IOException ioe) {
            // some IO error occurred when reading the file ...
            System.err.printf("Error when processing file %s... skipping it", file);
        }
        // try-with-resources will automatically release FileReader object
    }

}
