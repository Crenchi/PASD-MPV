/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rethink.JobChoices.Cashier;

/**
 *
 * @author chris
 */
import com.google.gson.Gson;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class CashRegisterUI extends JFrame implements ActionListener {

    String euro = "\u20ac";
    JButton productIDEnter;
    JButton productNameEnter;
    JButton card;
    JButton cash;
    JButton number1;
    JButton number2;
    JButton number3;
    JButton number4;
    JButton number5;
    JButton number6;
    JButton number7;
    JButton number8;
    JButton number9;
    JButton number0;
    JButton clear;
    JButton delete;
    JTextField price;
    JTextField productIDText;
    Product[] product;
    JLabel totalPrice;
    JLabel vatPrice;
    JLabel subTotalPrice;
    JTextField productNameText;
    JScrollPane scroll;
    LinkedHashMap <Integer, Integer> hashMap;
    JPanel groceryList;
    JPanel productsListPanel;

    JButton close;
    public CashRegisterUI(){
        hashMap = new LinkedHashMap<Integer, Integer>();
        try {
            product = CashierProduct();
        } catch (IOException e) {
            e.printStackTrace();
        }


        JPanel productIDPanel = new JPanel();
        productIDPanel.setBounds(0,20,500,150);
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



        productsListPanel = new JPanel();
        productsListPanel.setBounds(0,160,500,50);
        productsListPanel.setLayout(null);
        productsListPanel.setBorder(BorderFactory.createEtchedBorder());

        JLabel productQuantity = makeLabel(0, 20, 75, 30, "Quantity");
        productQuantity.setBorder(BorderFactory.createEtchedBorder());
        JLabel productName = makeLabel(75, 20, 325, 30, "Name");
        productName.setBorder(BorderFactory.createEtchedBorder());
        JLabel productPricePer = makeLabel(400, 20, 50, 30, "Each");
        productPricePer.setBorder(BorderFactory.createEtchedBorder());
        JLabel productPriceTotal = makeLabel(450, 20, 50, 30, "Total");
        productPriceTotal.setBorder(BorderFactory.createEtchedBorder());

        productsListPanel.add(productQuantity);
        productsListPanel.add(productName);
        productsListPanel.add(productPricePer);
        productsListPanel.add(productPriceTotal);
        
        groceryList = new JPanel(new FlowLayout());
        groceryList.setBounds(0,210, 500, 300);
        groceryList.setBorder(BorderFactory.createEtchedBorder());
        //scroll = new JScrollPane();



        JPanel pricingPanel = new JPanel();
        pricingPanel.setBounds(0,550,500,250);
        pricingPanel.setLayout(null);
        pricingPanel.setBorder(BorderFactory.createEtchedBorder());

        JLabel subTotal = makeLabel(0, 0, 75, 70, "Sub-total");
        subTotal.setBorder(BorderFactory.createEtchedBorder());
        subTotal.setHorizontalAlignment(JLabel.CENTER);
        JLabel vat = makeLabel(0, 70, 75, 70, "VAT");
        vat.setBorder(BorderFactory.createEtchedBorder());
        vat.setHorizontalAlignment(JLabel.CENTER);
        JLabel total = makeLabel(0, 140, 75, 70, "Total");
        total.setBorder(BorderFactory.createEtchedBorder());
        total.setHorizontalAlignment(JLabel.CENTER);

        subTotalPrice = makeLabel(400, 0, 100, 70, euro+"0,00");
        subTotalPrice.setFont(new Font("Serif", Font.PLAIN, 30));
        vatPrice = makeLabel(400, 70, 100, 70, euro+"0,00");
        vatPrice.setFont(new Font("Serif", Font.PLAIN, 30));
        totalPrice = makeLabel(400, 140, 100, 70, euro+"0,00");
        totalPrice.setFont(new Font("Serif", Font.PLAIN, 30));

        pricingPanel.add(subTotal);
        pricingPanel.add(vat);
        pricingPanel.add(total);
        pricingPanel.add(subTotalPrice);
        pricingPanel.add(vatPrice);
        pricingPanel.add(totalPrice);



        JPanel displayPrice = new JPanel();
        displayPrice.setBounds(500,20,500,150);
        displayPrice.setLayout(null);
        displayPrice.setBorder(BorderFactory.createEtchedBorder());

        price = makeTextField(20, 20, 420, 110);
        price.setText("0,00");
        price.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        price.setEditable(false);
        price.setFont(new Font("Serif", Font.BOLD, 75));
        displayPrice.add(price);



        JPanel numbersPanel = new JPanel();
        numbersPanel.setBounds(500,150,500,400);
        numbersPanel.setLayout(null);
        numbersPanel.setBorder(BorderFactory.createEtchedBorder());

        number1 = makeButton(115, 40, 80, 80, "1");
        number1.setFont(new Font("Serif", Font.PLAIN, 50));
        number2 = makeButton(205, 40, 80, 80, "2");
        number2.setFont(new Font("Serif", Font.PLAIN, 50));
        number3 = makeButton(295, 40, 80, 80, "3");
        number3.setFont(new Font("Serif", Font.PLAIN, 50));
        number4 = makeButton(115, 130, 80, 80, "4");
        number4.setFont(new Font("Serif", Font.PLAIN, 50));
        number5 = makeButton(205, 130, 80, 80, "5");
        number5.setFont(new Font("Serif", Font.PLAIN, 50));
        number6 = makeButton(295, 130, 80, 80, "6");
        number6.setFont(new Font("Serif", Font.PLAIN, 50));
        number7 = makeButton(115, 220, 80, 80, "7");
        number7.setFont(new Font("Serif", Font.PLAIN, 50));
        number8 = makeButton(205, 220, 80, 80, "8");
        number8.setFont(new Font("Serif", Font.PLAIN, 50));
        number9 = makeButton(295, 220, 80, 80, "9");
        number9.setFont(new Font("Serif", Font.PLAIN, 50));
        clear = makeButton(115, 310, 80, 80, "Clear");
        clear.setFont(new Font("Serif", Font.PLAIN, 30));
        number0 = makeButton(205, 310, 80, 80, "0");
        number0.setFont(new Font("Serif", Font.PLAIN, 50));
        delete = makeButton(295, 310, 80, 80, "X");
        delete.setFont(new Font("Serif", Font.PLAIN, 50));

        numbersPanel.add(number1);
        numbersPanel.add(number2);
        numbersPanel.add(number3);
        numbersPanel.add(number4);
        numbersPanel.add(number5);
        numbersPanel.add(number6);
        numbersPanel.add(number7);
        numbersPanel.add(number8);
        numbersPanel.add(number9);
        numbersPanel.add(clear);
        numbersPanel.add(delete);
        numbersPanel.add(number0);



        JPanel paymentOptionsPanel = new JPanel();
        paymentOptionsPanel.setBounds(500,500,500,250);
        paymentOptionsPanel.setLayout(null);
        paymentOptionsPanel.setBorder(BorderFactory.createEtchedBorder());

        card = makeButton(0, 50, 250, 200, "Card");
        card.setFont(new Font("Dialog", Font.PLAIN, 80));
        cash = makeButton(250, 50, 250, 200, "Cash");
        cash.setFont(new Font("Dialog", Font.PLAIN, 80));

        paymentOptionsPanel.add(card);
        paymentOptionsPanel.add(cash);



        close = makeButton(0, 0, 20, 20, "X");

        this.setResizable(false);
        this.setSize(1000,820);
        this.setLayout(null);
        this.add(close);
        this.add(productIDPanel);
        this.add(productsListPanel);
        this.add(pricingPanel);
        this.add(displayPrice);
        this.add(numbersPanel);
        this.add(paymentOptionsPanel);
        this.add(groceryList);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==productIDEnter){
            String id = productIDText.getText();
            productIDText.setText("");
            int y = Integer.parseInt(id);
            for(Product x: product){
                if(x.getId()==y){
                    Integer productPrice = x.getPrice_in_cents();
                    double productVAT = (x.getVat_rate())*100;
                    Integer productVAT2 = (int)productVAT;
                    CentInttoString(productPrice, productVAT2);
                    if(hashMap.containsKey(y)){
                        hashMap.put(y, hashMap.get(y) + 1);
                    } else {
                        hashMap.put(y, 1);
                    }
                    groceryList.removeAll();
                    updateList(hashMap);
                    
                }
            }

        }
        if(e.getSource()==productNameEnter){
            String productName = productNameText.getText();
            productNameText.setText("");
            for(Product x: product){
                if(x.getName().toLowerCase().equals(productName.toLowerCase())){
                    Integer productPrice = x.getPrice_in_cents();
                    double productVAT = (x.getVat_rate())*100;
                    Integer productVAT2 = (int)productVAT;
                    CentInttoString(productPrice, productVAT2);
                    if(hashMap.containsKey(x.getId())){
                        hashMap.put(x.getId(), hashMap.get(x.getId()) + 1);
                    } else {
                        hashMap.put(x.getId(), 1);
                    }
                    groceryList.removeAll();
                    updateList(hashMap);
                    
                }
            }
            for(Product x: product){
                if(x.getName().toLowerCase().equals(productName.toLowerCase())){
                    Integer productPrice = x.getPrice_in_cents();
                    double productVAT = (x.getVat_rate())*100;
                    Integer productVAT2 = (int)productVAT;
                    CentInttoString(productPrice, productVAT2);
                }
            }

        }
        if(e.getSource()==card){
            totalPrice.setText(euro + "0,00");
            vatPrice.setText(euro + "0,00");
            subTotalPrice.setText(euro + "0,00");
            price.setText( "0,00");
            productNameText.setText("");
            productIDText.setText("");
            groceryList.removeAll();
            groceryList.revalidate();
            groceryList.repaint();
            hashMap.clear();

        }
        if(e.getSource()==cash){
            String centTotalString =  totalPrice.getText().substring(1,totalPrice.getText().length()-3)+totalPrice.getText().substring(totalPrice.getText().length()-2,totalPrice.getText().length());
            String centPaymentString =  price.getText().substring(0,price.getText().length()-3)+price.getText().substring(price.getText().length()-2,price.getText().length());
            int x = Integer.parseInt(centTotalString);
            int y = Integer.parseInt(centPaymentString);
            if (y>=x){
                totalPrice.setText(euro + "0,00");
                vatPrice.setText(euro + "0,00");
                subTotalPrice.setText(euro + "0,00");
                price.setText( "0,00");
                productNameText.setText("");
                productIDText.setText("");
                groceryList.removeAll();
                groceryList.revalidate();
                groceryList.repaint();
                hashMap.clear();
            }
        }
        if(e.getSource()==number1){
            priceCheck('1');
        }
        if(e.getSource()==number2){
            priceCheck('2');
        }
        if(e.getSource()==number3){
            priceCheck('3');
        }
        if(e.getSource()==number4){
            priceCheck('4');
        }
        if(e.getSource()==number5){
            priceCheck('5');
        }
        if(e.getSource()==number6){
            priceCheck('6');
        }
        if(e.getSource()==number7){
            priceCheck('7');
        }
        if(e.getSource()==number8){
            priceCheck('8');
        }
        if(e.getSource()==number9){
            priceCheck('9');
        }
        if(e.getSource()==number0){
            if(price.getText().substring(0, 3).equals("0,00")){

            } else if ( price.getText().substring(0, 2).equals("0,0")){
                price.setText("0," + price.getText().charAt(3) +'0');
            } else if (price.getText().charAt(0) == '0'){
                price.setText(price.getText().charAt(2)+","+price.getText().charAt(3)+'0');
            } else {
                price.setText(price.getText().substring(0, price.getText().length()-3)+price.getText().charAt(price.getText().length()-2)+","+price.getText().charAt(price.getText().length()-1)+'0');
            }
        }
        if(e.getSource()==clear){
            price.setText("0,00");
        }
        if(e.getSource()==delete){
            if(price.getText().substring(0, 3).equals("0,00") ||
            price.getText().substring(0, 2).equals("0,0")
            ){
                price.setText("0,00");
            } else if (price.getText().charAt(0)=='0'){
                price.setText("0,0" + price.getText().charAt(2));
            } else if (price.getText().length()==4){
                price.setText("0," + price.getText().charAt(0)+price.getText().charAt(2));
            } else { 
                price.setText(price.getText().substring(0, price.getText().length()-4)+","+price.getText().charAt(price.getText().length()-4)+price.getText().charAt(price.getText().length()-2));            }
        }
        if(e.getSource()==close){
            new CashierOptions();
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

    public void priceCheck(char x){
        if(price.getText().charAt(0) == '0' ||
        price.getText().substring(0, 2).equals("0,0") ||
        price.getText().substring(0, 3).equals("0,00")
        ){
            price.setText(price.getText().charAt(2)+","+price.getText().charAt(3)+x);
        } else {
        price.setText(price.getText().substring(0, price.getText().length()-3)+price.getText().charAt(price.getText().length()-2)+","+price.getText().charAt(price.getText().length()-1)+x);
        }
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
    
    public void CentInttoString(int x, int y){
        String centTotalString =  totalPrice.getText().substring(1,totalPrice.getText().length()-3)+totalPrice.getText().substring(totalPrice.getText().length()-2,totalPrice.getText().length());
        int centInt = Integer.parseInt(centTotalString);
        Integer  newTotal = x + centInt;
        String newTotalPriceString = newTotal.toString();
        if(newTotalPriceString.length()>=3){
            totalPrice.setText(euro + newTotalPriceString.substring(0,newTotalPriceString.length()-2)+","+newTotalPriceString.substring(newTotalPriceString.length()-2,newTotalPriceString.length()));
        } else if(newTotalPriceString.length()==2){
            totalPrice.setText(euro + "0," + newTotalPriceString);
        } else {
            totalPrice.setText(euro + "0,0" + newTotalPriceString);
        }
        
        String centVATString =  vatPrice.getText().substring(1,vatPrice.getText().length()-3)+vatPrice.getText().substring(vatPrice.getText().length()-2,vatPrice.getText().length());
        int vatInt = Integer.parseInt(centVATString);
        Integer newVAT = y + vatInt;
        String newVATString = newVAT.toString();
        if(newVATString.length()>=3){
            vatPrice.setText(euro + newVATString.substring(0,newVATString.length()-2)+","+newVATString.substring(newVATString.length()-2,newVATString.length()));
        } else if(newVATString.length()==2){
            vatPrice.setText(euro + "0," + newVATString);
        } else {
            vatPrice.setText(euro + "0,0" + newVATString);
        }

        Integer newSubTotal = newTotal - newVAT;
        String newSubTotalString = newSubTotal.toString();
        if(newSubTotalString.length()>=3){
            subTotalPrice.setText(euro + newSubTotalString.substring(0,newSubTotalString.length()-2)+","+newSubTotalString.substring(newSubTotalString.length()-2,newSubTotalString.length()));
        } else if(newSubTotalString.length()==2){
            subTotalPrice.setText(euro + "0," + newSubTotalString);
        } else {
            subTotalPrice.setText(euro + "0,0" + newSubTotalString);
        }
        
        
    }
    
    public void updateList(LinkedHashMap <Integer, Integer> map){
        Set<Integer> ids = map.keySet();
        for(Integer id: ids){
            for(Product x: product){
                if(x.getId()==id){
                    //JLabel quantityLabel =  makeLabel(0,0,100,100,map.get(id).toString());
                    //JLabel nameLabel =  makeLabel(0,0,100,100,x.getName());
                    //JLabel eachLabel =  makeLabel(0,0,100,100,x.getName());
                    //JLabel totalLabel =  makeLabel(0,0,100,100,x.getName());
                    
                    JLabel quantityLabel2 = new JLabel();
                    quantityLabel2.setPreferredSize(new Dimension(60,30));
                    //quantityLabel2.setSize(75, 30);
                    
                    quantityLabel2.setText(map.get(id).toString());
                    
                    JLabel nameLabel2 = new JLabel();
                    nameLabel2.setPreferredSize(new Dimension(320,30));
                    //nameLabel2.setSize(325, 30);
                    nameLabel2.setText(x.getName());
                    
                    JLabel eachLabel2 = new JLabel();
                    eachLabel2.setPreferredSize(new Dimension(45, 30));
                    Integer x2 = x.getPrice_in_cents();
                    String priceString = x2.toString();
                    String nameLabel;
                    if(priceString.length()>=3){
                        nameLabel = (euro + priceString.substring(0,priceString.length()-2)+","+priceString.substring(priceString.length()-2,priceString.length()));
                    } else if(priceString.length()==2){
                        nameLabel = (euro + "0," + priceString);
                    } else {
                        nameLabel = (euro + "0,0" + priceString);
                    }
                    eachLabel2.setText(nameLabel);
                    
                    JLabel totalLabel2 = new JLabel();
                    Integer totalPriceString = map.get(id)*x2;
                    String totalPriceString2 = (totalPriceString).toString();
                    String totalLabel;
                    if(totalPriceString2.length()>=3){
                        totalLabel = (euro + totalPriceString2.substring(0,totalPriceString2.length()-2)+","+totalPriceString2.substring(totalPriceString2.length()-2,totalPriceString2.length()));
                    } else if(totalPriceString2.length()==2){
                        totalLabel = (euro + "0," + totalPriceString2);
                    } else {
                        totalLabel = (euro + "0,0" + totalPriceString2);
                    }
                    totalLabel2.setText(totalLabel);
                    totalLabel2.setPreferredSize(new Dimension(45, 30));
                    
                    System.out.println("id: "+ id + " , quantity: " + map.get(id).toString());
                    //scroll.add(quantityLabel);
                    groceryList.add(quantityLabel2);
                    groceryList.add(nameLabel2);
                    groceryList.add(eachLabel2);
                    groceryList.add(totalLabel2);
                    groceryList.revalidate();
                    groceryList.repaint();
                }
            }
        }
    }
    
}
