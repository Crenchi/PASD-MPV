/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rethink.JobChoices;


/**
 *
 * @author chris
 */
import javax.swing.JButton;
import javax.swing.JFrame;

import com.mycompany.rethink.JobChoices.Cashier.CashierOptions;
import com.mycompany.rethink.JobChoices.FloorWorker.FloorWorkerOptions;
import com.mycompany.rethink.JobChoices.Manager.ManagerOptions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobChoice extends JFrame implements ActionListener{

    JButton managerButton;
    JButton cashierButton;
    JButton floorWorkerButton;

    public JobChoice(){

        managerButton = new JButton();
        managerButton.setBounds(125,50,500,200);
        managerButton.setText("Manager");
        managerButton.setFocusable(false);
        managerButton.setHorizontalAlignment(JButton.CENTER);
        managerButton.setVerticalAlignment(JButton.CENTER);
        managerButton.addActionListener(this);

        cashierButton = new JButton();
        cashierButton.setBounds(125,300,500,200);
        cashierButton.setText("Cashier");
        cashierButton.setFocusable(false);
        cashierButton.setHorizontalAlignment(JButton.CENTER);
        cashierButton.setVerticalAlignment(JButton.CENTER);
        cashierButton.addActionListener(this);

        floorWorkerButton = new JButton();
        floorWorkerButton.setBounds(125,550,500,200);
        floorWorkerButton.setText("Floor Worker");
        floorWorkerButton.setFocusable(false);
        floorWorkerButton.setHorizontalAlignment(JButton.CENTER);
        floorWorkerButton.setVerticalAlignment(JButton.CENTER);
        floorWorkerButton.addActionListener(this);


        this.setResizable(false);
        this.setSize(750,800);
        this.setLayout(null);
        this.add(managerButton);
        this.add(cashierButton);
        this.add(floorWorkerButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==managerButton){
            ManagerOptions managerFrame = new ManagerOptions();
            managerFrame.setVisible(true);
            dispose();
        }
        if(e.getSource()==cashierButton){
            CashierOptions cashierFrame = new CashierOptions();
            cashierFrame.setVisible(true);
            dispose();
        }
        if(e.getSource()==floorWorkerButton){
            FloorWorkerOptions floorWorkerFrame = new FloorWorkerOptions();
            floorWorkerFrame.setVisible(true);
            dispose();
        }
    }
}