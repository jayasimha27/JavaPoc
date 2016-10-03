/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.inheritence;

/**
 *
 * @author jayasimha<jayasimha.bj@gmail.com>
 */
public interface IBankAccount {

    public AccountType getType() throws TransactionException;

    public boolean credit(int amount) throws TransactionException;

    public boolean credit(float amount) throws TransactionException;

    public boolean debit(int amount) throws TransactionException;

    public boolean debit(float amount) throws TransactionException;

    public double getBalance() throws TransactionException;

    public long getInterest() throws TransactionException;

}
