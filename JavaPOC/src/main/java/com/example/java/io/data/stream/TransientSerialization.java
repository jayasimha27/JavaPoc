/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.io.data.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author jjagadee
 */
public class TransientSerialization {

    public static void main(String[] args) {
        PrimeMinister primeMinister = new PrimeMinister("Narendra Modi", "2014 to 2019", "1stterm");
        System.out.println(primeMinister);

        //Serialize the object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/PrimeMinister.data"))) {
            oos.writeObject(primeMinister);
        } catch (FileNotFoundException fnfe) {
            System.err.println("cannot create a file with the given file name ");
        } catch (IOException ioe) {
            System.err.println("an I/O error occurred while processing the file");
            ioe.printStackTrace();
        } // the ObjectOutputStream will auto-close, so don't have to worry about it

        //De-serialize the object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/PrimeMinister.data"))) {
            Object obj = ois.readObject();
            if (obj != null && obj instanceof PrimeMinister) {
                PrimeMinister primeMinister1 = (PrimeMinister) obj;
                System.out.println(primeMinister1);
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("cannot create a file with the given file name ");
        } catch (IOException ioe) {
            System.err.println("an I/O error occurred while processing the file");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("cannot recognize the class of the object - is the file corrupted?");
        }
    }

}
