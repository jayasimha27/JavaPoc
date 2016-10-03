/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.io.charecter.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author jjagadee
 */
public class BufferedReadWrite {

    public static void main(String[] files) {
        String srcFile = "";
        String dstFile = "";
        // try opening the source and destination file
        // with FileReader and FileWriter
        try (BufferedReader inputFile = new BufferedReader(new FileReader(srcFile));
                BufferedWriter outputFile = new BufferedWriter(new FileWriter(dstFile))) {
            int ch = 0;
            // while there are characters to fetch, read the characters from
            // source stream and write them to the destination stream
            while ((ch = inputFile.read()) != -1) {
                // ch is of type int - convert it back to char before
                // writing it
                outputFile.write((char) ch);
            }
            // no need to call flush explicitly for outputFile - the close()
            // method will first call flush before closing the outputFile stream
        } catch (FileNotFoundException fnfe) {
            // the passed file is not found ...
            System.err.println("Cannot open the file " + fnfe.getMessage());
        } catch (IOException ioe) {
            // some IO error occurred when reading the file ...
            System.err.printf("Error when processing file; exiting ... ");
        }
        // try-with-resources will automatically release FileReader object
    }
}
