/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rethink.JobChoices.FloorWorker;


/**
 *
 * @author chris
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PrintLabel extends JFrame implements ActionListener {


    JButton print;
    JButton close;
    JButton productIDEnter;
    JButton productNameEnter;

    public PrintLabel(){
        JPanel productIDPanel = new JPanel();
        productIDPanel.setBounds(0,20,750,150);
        productIDPanel.setLayout(null);
        productIDPanel.setBorder(BorderFactory.createEtchedBorder());

        JTextField productIDText = makeTextField(120,20,280,40);
        JLabel productIDLabel = makeLabel(20,20,100,40, "Product ID: ");
        productIDEnter = makeButton(410, 20, 90, 40, "Enter");


        JTextField productNameText = makeTextField(120,70,280,40);
        JLabel productNameLabel = makeLabel(20,70,100,40, "Product Name: ");
        productNameEnter = makeButton(410, 70, 90, 40, "Enter");

        productIDPanel.add(productIDText);
        productIDPanel.add(productIDLabel);
        productIDPanel.add(productIDEnter);
        productIDPanel.add(productNameText);
        productIDPanel.add(productNameLabel);
        productIDPanel.add(productNameEnter);

        print = makeButton(300, 700, 75, 50, "Print");
        print.setHorizontalAlignment(JButton.CENTER);
        print.setVerticalAlignment(JButton.CENTER);

        close = new JButton();
        close.setBounds(0,0,20,20);
        close.setText("X");
        close.addActionListener(this);

        this.setResizable(false);
        this.setSize(750,800);
        this.setLayout(null);
        this.add(productIDPanel);
        this.add(print);
        this.add(close);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==print){

        }
        if(e.getSource()==productIDEnter){

        }
        if(e.getSource()==productNameEnter){

        }
        if(e.getSource()==close){
            new FloorWorkerOptions();
            dispose();
        }
        
    }

    public JButton makeButton(int posx, int posy, int width, int height, String text){
        JButton x = new JButton();
        x.setBounds(posx,posy,width,height);
        x.setText(text);
        x.addActionListener(this);

        return x;
    }

    public JLabel makeLabel(int posx, int posy, int width, int height, String text){
        JLabel x = new JLabel(text);
        x.setBounds(posx, posy, width, height);
        return x;
    }

    public JTextField makeTextField(int posx, int posy, int width, int height){
        JTextField x = new JTextField();
        x.setBounds(posx, posy, width, height);
        x.setLayout(null);
        return x;
    }

}

