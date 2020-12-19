/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.io.*;
import java.rmi.server.UnicastRemoteObject;
import javaBean.BankBean;

/**
 *
 * @author User
 */
public class ServerImplements extends UnicastRemoteObject implements RemoteInterface {
    public ServerImplements() throws Exception {
        super();
    }
    
    FileInputStream fi = new FileInputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\Banking\\src\\banking\\myObjects.txt");
    ObjectInputStream oi = new ObjectInputStream(fi);
    BankBean pr1 = (BankBean) oi.readObject();
    
    public int getNumber(){
        return pr1.getNumber();
    }
    public String getName(){
        return pr1.getName();
    }
    public int getBalance(){
        return pr1.getBalance();
    }
    public void deposit(int amount){
        pr1.deposit(amount);
    }
    public void withdraw(int amount){
        pr1.withdraw(amount);
    }
    
    
}
