/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rethink.JobChoices.Cashier;


/**
 *
 * @author chris
 */
public class Product{
    private int id;
    private String name;
    private double vat_rate;
    private int price_in_cents;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getPrice_in_cents() {
        return price_in_cents;
    }
    public void setPrice_in_cents(int price_in_cents) {
        this.price_in_cents = price_in_cents;
    }

    public double getVat_rate() {
        return vat_rate;
    }
    public void setVat_rate(double vat_rate) {
        this.vat_rate = vat_rate;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
