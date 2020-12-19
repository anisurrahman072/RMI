/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

/**
 *
 * @author User
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javaBean.BankBean;

public class Server {
  public static void main(String args[]) {
    try {
        
      BankBean p1 = new BankBean(7283, "Client", 234);
      FileOutputStream f = new FileOutputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\Banking\\src\\banking\\myObjects.txt");
      ObjectOutputStream o = new ObjectOutputStream(f);
      o.writeObject(p1);
      o.close();
      f.close();
      
      ServerImplements s = new ServerImplements();
      Registry r = LocateRegistry.createRegistry(4000);
      Naming.rebind("rmi://localhost:4000/rmi_cal", s);
      System.out.println("Server has been started");
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
