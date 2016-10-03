/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.inheritence;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jayasimja<jayasimha.bj@gmail.com>
 */
public abstract class BankAccount implements IBankAccount {

    protected String accountNo;
    protected String branch;
    protected double balance;
    protected float interest;
    protected AccountType accountType;
    
    public BankAccount(AccountType type){
        this.accountType=type;
    }

    @Override
    public AccountType getType() {
        return accountType;
    }

    @Override
    public boolean credit(int amount) throws TransactionException {
        try {
            //Todo - Credit amount from accout based on business rules;
            balance += amount;
        } catch (Exception ex) {
            Logger.getLogger(BankAccount.class.getName())
                    .log(Level.WARNING, "Credit Operation Failed , AccountNo {}", accountNo);
            throw new TransactionException("Credit Operation Failed,  AccountNo :" + accountNo, ex);
        } finally {
            //Todo : Close Recover
        }
        return true;
    }

    public boolean credit(float amount) throws TransactionException {
        try {
            //Todo - Credit amount from accout based on business rules;
            balance += amount;
        } catch (Exception ex) {
            Logger.getLogger(BankAccount.class.getName())
                    .log(Level.WARNING, "Credit Operation Failed , AccountNo {}", accountNo);
            throw new TransactionException("Credit Operation Failed,  AccountNo :" + accountNo, ex);
        } finally {
            //Todo : Close Recover
        }
        return true;
    }

    public boolean debit(int amount) throws TransactionException {
        if (balance < amount) {
            Logger.getLogger(BankAccount.class.getName())
                    .log(Level.WARNING, "Debit Operation Failed  due to insuffcient fund, AccountNo {}", accountNo);
            throw new TransactionException("Debit Operation Failed  due to insuffcient fund,  AccountNo :" + accountNo);
        } else {
            balance -= amount;
        }
        return true;
    }

    public boolean debit(float amount) throws TransactionException {

        if (balance < amount) {
            Logger.getLogger(BankAccount.class.getName())
                    .log(Level.WARNING, "Debit Operation Failed  due to insuffcient fund, AccountNo {}", accountNo);
            throw new TransactionException("Debit Operation Failed  due to insuffcient fund,  AccountNo :" + accountNo);
        } else {
            balance -= amount;
        }
        return true;
    }

    public double getBalance() throws TransactionException {
        return 10000;
    }

}
