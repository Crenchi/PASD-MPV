/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rethink.JobChoices.Cashier;


/**
 *
 * @author chris
 */
import com.mycompany.rethink.JobChoices.JobChoice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class CashierOptions extends JFrame implements ActionListener{

    JButton scanProducts;
    JButton close;

    public CashierOptions(){

        scanProducts = new JButton();
        scanProducts.setBounds(125,50,500,200);
        scanProducts.setText("Scan Products");
        scanProducts.setFocusable(false);
        scanProducts.setHorizontalAlignment(JButton.CENTER);
        scanProducts.setVerticalAlignment(JButton.CENTER);
        scanProducts.addActionListener(this);

        close = new JButton();
        close.setBounds(0,0,20,20);
        close.setText("X");
        close.addActionListener(this);

        this.setResizable(false);
        this.setSize(750,800);
        this.setLayout(null);
        this.add(scanProducts);
        this.add(close);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==scanProducts){
            CashRegisterUI scan = new CashRegisterUI();
            dispose();
            scan.setVisible(true);
        }
        if(e.getSource()==close){
            new JobChoice();
            dispose();
        }
        
    }
    
}
