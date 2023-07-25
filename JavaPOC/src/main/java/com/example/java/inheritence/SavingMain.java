/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.java.inheritence;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jayasimha_Bj
 */
public class SavingMain {
    
    public static void main(String[] args) {
        IBankAccount acccount=new SavingsAccount(AccountType.SAVINGS);
        try {
            acccount.credit(100);
        } catch (TransactionException ex) {
            System.out.println(""+ex.getMessage());
            Logger.getLogger(SavingMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
  
    
}
