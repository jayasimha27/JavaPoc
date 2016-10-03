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
 * @author Jayasimha<jayasimha.jagadeesha@oracle.com>
 */
public class SavingsAccount extends BankAccount {

    public SavingsAccount(AccountType type) {
        super(type);
    }

    @Override
    public boolean debit(int amount) throws TransactionException {
        if (isMinimumBalance()) {
            Logger.getLogger(BankAccount.class.getName())
                    .log(Level.WARNING, "Debit Operation Failed  due to insuffcient fund, AccountNo {}", accountNo);
            throw new TransactionException("Debit Operation Failed  due to insuffcient fund,  AccountNo :" + accountNo);
        } else {
            balance -= amount;
        }
        return true;
    }

    @Override
    public boolean debit(float amount) throws TransactionException {

        if (isMinimumBalance()) {
            Logger.getLogger(BankAccount.class.getName())
                    .log(Level.WARNING, "Debit Operation Failed  due to insuffcient fund, AccountNo {}", accountNo);
            throw new TransactionException("Debit Operation Failed  due to insuffcient fund,  AccountNo :" + accountNo);
        } else {
            balance -= amount;
        }
        return true;
    }

    @Override
    public long getInterest() throws TransactionException {
        //Todo : Calculate the annual interest accordance to Business rule
        return 0;
    }

    private boolean isMinimumBalance() {
        //TODO : Calculate the minim required balance for savings account
        return true;
    }

}
