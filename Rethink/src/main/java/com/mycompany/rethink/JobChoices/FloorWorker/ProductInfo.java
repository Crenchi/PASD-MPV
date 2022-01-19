/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rethink.JobChoices.FloorWorker;


/**
 *
 * @author chris
 */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProductInfo extends JFrame implements ActionListener {

    JButton close;
    JButton productIDEnter;
    JButton productNameEnter;

    public ProductInfo(){
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



        JPanel info = new JPanel();
        info.setBounds(0,170,750,600);
        info.setLayout(null);
        info.setBorder(BorderFactory.createEtchedBorder());

        JLabel currentStock = makeLabel(20,20,355,150, "Current Stock: ");
        currentStock.setHorizontalAlignment(JLabel.CENTER);
        currentStock.setBorder(BorderFactory.createEtchedBorder());
        currentStock.setFont(new Font("Serif", Font.PLAIN, 30));
        JLabel dueDate = makeLabel(20,170,355,150, "Next Due Date: ");
        dueDate.setHorizontalAlignment(JLabel.CENTER);
        dueDate.setBorder(BorderFactory.createEtchedBorder());
        dueDate.setFont(new Font("Serif", Font.PLAIN, 30));
        JLabel price = makeLabel(20,320,355,150, "Price: ");
        price.setHorizontalAlignment(JLabel.CENTER);
        price.setBorder(BorderFactory.createEtchedBorder());
        price.setFont(new Font("Serif", Font.PLAIN, 30));
        JLabel aisle = makeLabel(20,470,355,150, "Aisle: ");
        aisle.setHorizontalAlignment(JLabel.CENTER);
        aisle.setBorder(BorderFactory.createEtchedBorder());
        aisle.setFont(new Font("Serif", Font.PLAIN, 30));

        JLabel currentStockInfo = makeLabel(375,20,355,150, "");
        currentStockInfo.setHorizontalAlignment(JLabel.CENTER);
        currentStockInfo.setBorder(BorderFactory.createEtchedBorder());
        currentStockInfo.setFont(new Font("Serif", Font.PLAIN, 30));
        JLabel dueDateInfo = makeLabel(375,170,355,150, "");
        dueDateInfo.setHorizontalAlignment(JLabel.CENTER);
        dueDateInfo.setBorder(BorderFactory.createEtchedBorder());
        dueDateInfo.setFont(new Font("Serif", Font.PLAIN, 30));
        JLabel priceInfo = makeLabel(375,320,355,150, "");
        priceInfo.setHorizontalAlignment(JLabel.CENTER);
        priceInfo.setBorder(BorderFactory.createEtchedBorder());
        priceInfo.setFont(new Font("Serif", Font.PLAIN, 30));
        JLabel aisleInfo = makeLabel(375,470,355,150, "");
        aisleInfo.setHorizontalAlignment(JLabel.CENTER);
        aisleInfo.setBorder(BorderFactory.createEtchedBorder());
        aisleInfo.setFont(new Font("Serif", Font.PLAIN, 30));

        info.add(currentStock);
        info.add(dueDate);
        info.add(price);
        info.add(aisle);
        info.add(currentStockInfo);
        info.add(dueDateInfo);
        info.add(priceInfo);
        info.add(aisleInfo);



        close = new JButton();
        close.setBounds(0,0,20,20);
        close.setText("X");
        close.addActionListener(this);

        this.setResizable(false);
        this.setSize(750,800);
        this.setLayout(null);
        this.add(productIDPanel);
        this.add(close);
        this.add(info);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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

