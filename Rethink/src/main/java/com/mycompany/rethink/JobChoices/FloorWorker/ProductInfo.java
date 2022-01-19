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

import java.awt.Font;
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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProductInfo extends JFrame implements ActionListener {

    Product[] product;
    JButton close;
    JButton productIDEnter;
    JButton productNameEnter;
    JTextField productIDText;
    JTextField productNameText;
    JLabel currentStockInfo;
    JLabel dueDateInfo;
    JLabel priceInfo;
    JLabel aisleInfo;


    public ProductInfo(){
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

        currentStockInfo = makeLabel(375,20,355,150, "");
        currentStockInfo.setHorizontalAlignment(JLabel.CENTER);
        currentStockInfo.setBorder(BorderFactory.createEtchedBorder());
        currentStockInfo.setFont(new Font("Serif", Font.PLAIN, 30));
        dueDateInfo = makeLabel(375,170,355,150, "");
        dueDateInfo.setHorizontalAlignment(JLabel.CENTER);
        dueDateInfo.setBorder(BorderFactory.createEtchedBorder());
        dueDateInfo.setFont(new Font("Serif", Font.PLAIN, 30));
        priceInfo = makeLabel(375,320,355,150, "");
        priceInfo.setHorizontalAlignment(JLabel.CENTER);
        priceInfo.setBorder(BorderFactory.createEtchedBorder());
        priceInfo.setFont(new Font("Serif", Font.PLAIN, 30));
        aisleInfo = makeLabel(375,470,355,150, "");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Random rand = new Random();
        if(e.getSource()==productIDEnter){
            String id = productIDText.getText();
            int y = Integer.parseInt(id);
            for(Product x: product) {
                if (x.getId() == y) {
                    priceInfo.setText(String.format("\u20ac %.2f", ((double) x.getPrice_in_cents()/100)));
                    aisleInfo.setText(String.valueOf(rand.nextInt(16)));
                    LocalDateTime date = LocalDateTime.now().plusDays(rand.nextInt(5));
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    dueDateInfo.setText(date.format(formatter));
                    productNameText.setText(x.getName());
                    currentStockInfo.setText(String.valueOf(rand.nextInt(25)));
                }
            }
        }
        if(e.getSource()==productNameEnter){
            String name = productNameText.getText();
            for(Product x: product) {
                if (x.getName().equals(name)) {
                    priceInfo.setText(String.format("\u20ac %.2f", ((double) x.getPrice_in_cents()/100)));
                    aisleInfo.setText(String.valueOf(rand.nextInt(15) + 1));
                    LocalDateTime date = LocalDateTime.now().plusDays(rand.nextInt(5));
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    dueDateInfo.setText(date.format(formatter));
                    productIDText.setText(String.valueOf(x.getId()));
                    currentStockInfo.setText(String.valueOf(rand.nextInt(25)));
                }
            }
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

