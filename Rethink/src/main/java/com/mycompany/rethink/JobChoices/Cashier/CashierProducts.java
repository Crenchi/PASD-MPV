package com.mycompany.rethink.JobChoices.Cashier;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chris
 */

public class CashierProducts {
    Product[] products;
    public Product[] CashierProducts() throws IOException {

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
      return products;
    }
   
}