/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rethink.JobChoices.FloorWorker;



/**
 *
 * @author chris
 */
import com.mycompany.rethink.JobChoices.JobChoice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FloorWorkerOptions extends JFrame implements ActionListener{

    JButton printLabe;
    JButton productInfo;
    JButton close;
    public FloorWorkerOptions(){

        printLabe = new JButton();
        printLabe.setBounds(125,50,500,200);
        printLabe.setText("Print Label");
        printLabe.setFocusable(false);
        printLabe.setHorizontalAlignment(JButton.CENTER);
        printLabe.setVerticalAlignment(JButton.CENTER);
        printLabe.addActionListener(this);

        productInfo = new JButton();
        productInfo.setBounds(125,300,500,200);
        productInfo.setText("Check Product Information");
        productInfo.setFocusable(false);
        productInfo.setHorizontalAlignment(JButton.CENTER);
        productInfo.setVerticalAlignment(JButton.CENTER);
        productInfo.addActionListener(this);

        close = new JButton();
        close.setBounds(0,0,20,20);
        close.setText("X");
        close.addActionListener(this);

        this.setResizable(false);
        this.setSize(750,800);
        this.setLayout(null);
        this.add(printLabe);
        this.add(productInfo);
        this.add(close);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==printLabe){
            PrintLabel printLabl = new PrintLabel();
            printLabl.setVisible(true);
            dispose();
        }
        if(e.getSource()==productInfo){
            ProductInfo proInfo = new ProductInfo();
            proInfo.setVisible(true);
            dispose();
        }
        if(e.getSource()==close){
            new JobChoice();
            dispose();
        }
        
    }
    
}
