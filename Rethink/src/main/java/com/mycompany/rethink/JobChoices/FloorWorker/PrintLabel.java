/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rethink.JobChoices.FloorWorker;


/**
 *
 * @author chris
 */

import com.google.gson.Gson;
import com.mycompany.rethink.JobChoices.Cashier.Product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.swing.*;

public class PrintLabel extends JFrame implements ActionListener {


    Product[] product;
    JButton print;
    JButton close;
    JButton productIDEnter;
    JButton productNameEnter;
    JTextField productIDText;
    JTextField productNameText;

    JLabel priceLabel;
    JLabel aisleLabel;
    JLabel nameLabel;
    JLabel vatLabel;
    JLabel idLabel;


    public PrintLabel(){
        try {
            product = CashierProduct();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel productIDPanel = new JPanel();
        productIDPanel.setBounds(0,20,750,150);
        productIDPanel.setLayout(null);
        productIDPanel.setBorder(BorderFactory.createEtchedBorder());

        productIDText = makeTextField(120,20,280,40);
        JLabel productIDLabel = makeLabel(20,20,100,40, "Product ID: ");
        productIDEnter = makeButton(410, 20, 90, 40, "Enter");


        productNameText = makeTextField(120,70,280,40);
        JLabel productNameLabel = makeLabel(20,70,100,40, "Product Name: ");
        productNameEnter = makeButton(410, 70, 90, 40, "Enter");

        productIDPanel.add(productIDText);
        productIDPanel.add(productIDLabel);
        productIDPanel.add(productIDEnter);
        productIDPanel.add(productNameText);
        productIDPanel.add(productNameLabel);
        productIDPanel.add(productNameEnter);

        JPanel labelPanel = new JPanel();
        labelPanel.setBounds(200,300,350,100);
        labelPanel.setBackground(Color.white);
        labelPanel.setLayout(null);
        labelPanel.setBorder(BorderFactory.createEtchedBorder());

        //productIDText = makeTextField(120,20,280,40);
        priceLabel = makeLabel(220,10,110,60, "\u20ac2,00");
        idLabel = makeLabel(10,35,100,40, "#0");
        nameLabel = makeLabel(10,0,200,60, "Default product");
        aisleLabel = makeLabel(10,50,200,60, "Aisle 0");
        vatLabel = makeLabel(220,60,110,40, "Vat 9.0%");
        Font font = new Font(nameLabel.getFont().getName(), Font.BOLD, 20);
        Font font2 = new Font(nameLabel.getFont().getName(), Font.PLAIN, 36);
        nameLabel.setFont(font);
        priceLabel.setFont(font2);

        labelPanel.add(priceLabel);
        labelPanel.add(nameLabel);
        labelPanel.add(aisleLabel);
        labelPanel.add(idLabel);
        labelPanel.add(vatLabel);

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
        this.add(labelPanel);
        this.add(print);
        this.add(close);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==print){
            JOptionPane.showMessageDialog(null, "The label is sent to the label printer.");
        }
        if(e.getSource()==productIDEnter){
            String id = productIDText.getText();
            int y = Integer.parseInt(id);
            for(Product x: product) {
                if (x.getId() == y) {
                    productNameText.setText(x.getName());
                    setLabelInfo(x);
                }
            }
        }
        if(e.getSource()==productNameEnter){
            String name = productNameText.getText();
            for(Product x: product) {
                if (x.getName().equals(name)) {
                    productIDText.setText(String.valueOf(x.getId()));
                    setLabelInfo(x);
                }
            }
        }
        if(e.getSource()==close){
            new FloorWorkerOptions();
            dispose();
        }
        
    }

    private void setLabelInfo(Product x) {
        Random rand = new Random();
        nameLabel.setText(x.getName());
        aisleLabel.setText("Aisle " + (rand.nextInt(15) + 1));
        idLabel.setText("#" + x.getId());
        vatLabel.setText("Vat " + x.getVat_rate()*100 + "%");

    }

    public Product[] CashierProduct() throws IOException {

        String url = "https://rethink-supplier.herokuapp.com/product/";

        HttpURLConnection httpClient =
                (HttpURLConnection) new URL(url).openConnection();

        // optional default is GET
        httpClient.setRequestMethod("GET");

        //add request header
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.2 Safari/605.1.15");
        httpClient.setRequestProperty("Authorization", "Token 48cebd60bac911ede007d9d484552aaae8cb5738");
        httpClient.setRequestProperty("Accept", "application/json");

        int responseCode = httpClient.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            //Product[] products = new Gson().fromJson(response, Product.class);
            Gson gson = new Gson();
            Product[] products = gson.fromJson(response.toString(), Product[].class);


            //print result
            System.out.println(response.toString());
            return products;

        } catch (Exception e){
            System.out.println("Something went wrong.");
        }
        return null;
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

