/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rethink.JobChoices.Manager;

/**
 *
 * @author chris
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.rethink.JobChoices.JobChoice;
import javax.swing.JButton;
import javax.swing.JFrame;
public class ManagerOptions extends JFrame implements ActionListener{

    JButton stockInfo;
    JButton close;
    public ManagerOptions(){

        stockInfo = new JButton();
        stockInfo.setBounds(125,50,500,200);
        stockInfo.setText("Check Stock Information");
        stockInfo.setFocusable(false);
        stockInfo.setHorizontalAlignment(JButton.CENTER);
        stockInfo.setVerticalAlignment(JButton.CENTER);
        stockInfo.addActionListener(this);

        close = new JButton();
        close.setBounds(0,0,20,20);
        close.setText("X");
        close.addActionListener(this);

        this.setResizable(false);
        this.setSize(750,800);
        this.setLayout(null);
        this.add(stockInfo);
        this.add(close);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==stockInfo){
            StockInfo stockInf = new StockInfo();
            dispose();
            stockInf.setVisible(true);

        }
        if(e.getSource()==close){
            new JobChoice();
            dispose();
        }
        
    }
    
}

