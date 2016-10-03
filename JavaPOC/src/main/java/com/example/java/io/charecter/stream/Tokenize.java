/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.io.charecter.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author jjagadee
 */
public class Tokenize {

    public static void main(String[] args) {
        // read the input file
        String fileName = "";
        // use a TreeSet<String> which will automatically sort the words
        // in alphabetical order
        Set<String> words = new TreeSet<>();
        try (Scanner tokenizingScanner = new Scanner(new FileReader(fileName))) {
            // set the delimiter for text as non-words (special characters,
            // white-spaces, etc), meaning that all words other than punctuation
            // characters, and white-spaces will be returned
            tokenizingScanner.useDelimiter("\\W");
            while (tokenizingScanner.hasNext()) {
                String word = tokenizingScanner.next();
                if (!word.equals("")) { // process only non-empty strings
                    // convert to lowercase and then add to the set
                    words.add(word.toLowerCase());
                }
            }
            // now words are in alphabetical order without duplicates,
            // print the words separating them with tabs
            for (String word : words) {
                System.out.print(word + '\t');
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot read the input file - pass a valid file name");
        }
    }

}
