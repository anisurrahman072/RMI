/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaBean;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class BankBean implements Serializable{
    int ac_num;
    String ac_name;
    int balance;
    
    public BankBean(int ac_num, String ac_name, int balance){
        this.ac_name = ac_name;
        this.ac_num = ac_num;
        this.balance = balance;
    }
    
    public int getNumber()
    {
        return ac_num;
    }
    public String getName()
    {
        return ac_name;
    }
    public int getBalance()
    {
        return balance;
    }
    public void deposit(int amount)
    {
        balance += amount;
    }
    public void withdraw(int amount)
    {
        balance -= amount;
    }
}
