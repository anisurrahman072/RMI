/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.rmi.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class Client extends javax.swing.JFrame {
    Label rs1 = new Label("");
    Label rs2 = new Label("");
    Label rs3 = new Label("");
    Label rs4 = new Label("Enter deposit money: ");
    TextField t1 = new TextField(30);
    JButton b1 = new JButton("Deposit");
    
    Label rs5 = new Label("Enter withdraw money: ");
    TextField t2 = new TextField(30);
    JButton b2 = new JButton("Withdraw");
    
    Panel p = new Panel(new GridLayout(4, 1, 5, 5));
    RemoteInterface s;

    /**
     * Creates new form Client
     */
    public Client() {
        super("Client Side");
        setSize(250, 250);
        setLocation(300, 300);
        getContentPane().add(p, "North");
        p.add(rs1);
        p.add(rs2);
        p.add(rs3);
        p.add(rs4);
        p.add(t1);
        p.add(b1);
        p.add(rs5);
        p.add(t2);
        p.add(b2);
        try {
            String ipp = JOptionPane.showInputDialog("Please enter the IP Address to Connect");
            int port =4000;
            String ip = "rmi://" + ipp +":"+ port+ "/rmi_cal";
            s = (RemoteInterface) Naming.lookup(ip);
            int number = s.getNumber();
            String name = s.getName();
            int balance = s.getBalance();
            rs1.setText("Account Number = " + number);            
            rs2.setText("Account Name = " + name);
            rs3.setText("Account Balance = " + balance+ " tk");
            System.out.println(balance);


        } catch (Exception exp) {
          JOptionPane.showMessageDialog(null, exp.getMessage());
        }
        
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int a = Integer.parseInt(t1.getText());
                try {
                    s.deposit(a);
                    int newBal = s.getBalance();
                    rs3.setText("Account Balance = " + newBal+ " tk");
                } catch (Exception epx) { 
                }
            }
        });
        
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int a = Integer.parseInt(t2.getText());
                try {
                    s.withdraw(a);
                    int newBal = s.getBalance();
                    rs3.setText("Account Balance = " + newBal+ " tk");
                } catch (Exception epx) { 
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Client c = new Client();
        c.setDefaultCloseOperation(EXIT_ON_CLOSE);
        c.setVisible(true);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
