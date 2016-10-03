/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.inheritence;

/**
 *
 * @author jjagadee
 */
public class TransactionException extends Exception {

    public TransactionException(String message) {
        super(message);
    }

    public TransactionException(Throwable th) {
        super(th);
    }

    public TransactionException(String message, Throwable th) {
        super(message, th);
    }
}
