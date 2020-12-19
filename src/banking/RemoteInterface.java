/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.rmi.Remote;

/**
 *
 * @author User
 */
public interface RemoteInterface extends Remote {
    public int getNumber()throws Exception;    
    public String getName()throws Exception;
    public int getBalance()throws Exception;
    public void deposit(int amount)throws Exception;
    public void withdraw(int amount)throws Exception;
}
