package com.example.admin.coffeeordering;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantityE = 0;
    int quantityC = 0;
    int quantityCL = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //this methods handles the expresso quantity
    public void expQuantity(View view)
    {
        quantityE = quantityE + 1;
        displayExpoQ(quantityE);
    }
    public void expQuantityCan(View view)
    {
        if(quantityE!=0)
        {
            quantityE = quantityE - 1;
        }
        displayExpoQ(quantityE);
    }
    //this methods handles the cappuccino quantity
    public void cappQuantity(View view)
    {
        quantityC = quantityC + 1;
        displayCappQ(quantityC);
    }
    public void cappQuantityCan(View view)
    {
        if(quantityC!=0)
        {
            quantityC = quantityC - 1;
        }
       displayCappQ(quantityC);
    }
    //this methods handles the caffe latte quantity
    public void caffQuantity(View view)
    {
        quantityCL = quantityCL + 1;
        displayCaffQ(quantityCL);
    }
    public void caffQuantityCan(View view)
    {
        if(quantityCL!=0)
        {
            quantityCL = quantityCL - 1;
        }
        displayCaffQ(quantityCL);
    }
    //this method will calculate the total of your quantity
    public void calculateQuantity()
    {
        TextView quantity = (TextView)findViewById(R.id.quantity_view);
        quantity.setText("" + (quantityC + quantityE + quantityCL));
    }
    //method to display the price order and some message
    public void displayMessage(String message)
    {
        TextView priceview = (TextView)findViewById(R.id.price_view);
        priceview.setText(message);
    }
    //view the total quantity
    public void display(int number)
    {
        TextView expresoview = (TextView)findViewById(R.id.quantity_view);
        expresoview.setText(""+number);
    }
    //view cafe latte quantity
    public void displayCaffQ(int number)
    {
        TextView caffquantity = (TextView)findViewById(R.id.caffe_quantity);
        caffquantity.setText(""+number);
    }
    //view cappuccino quantity
    public void displayCappQ(int number)
    {
        TextView cappquantity = (TextView)findViewById(R.id.cap_quantity);
        cappquantity.setText(""+number);
    }
    //view expresso quantity
    public void displayExpoQ(int number)
    {
        TextView expquantity = (TextView)findViewById(R.id.exp_quantity);
        expquantity.setText(""+number);
    }
    //this method will be called to display your order details
    public void submitOrder(View view)
    {

        calculateQuantity();
        calculatePrice(quantityE,quantityC,quantityCL);
        calculatePrices(priceExp,priceCapp,priceCaff);


    }
    //this method will calculate the total price of your order
    int priceExp = 0;
    int priceCaff = 0;
    int priceCapp = 0;
    public int calculatePrice(int q1,int q2,int q3)
    {
       if(q1>0){priceExp = q1 * 5;}
        if(q2>0){priceCapp = q2 * 10;}
        if(q3>0){priceCaff = q3 * 15;}

        int total = priceExp + priceCaff + priceCapp;
        return total;
    }
    public void calculatePrices(int p1,int p2,int p3)
    {
        TextView pricetextview = (TextView)findViewById(R.id.price_view);
        pricetextview.setText(NumberFormat.getCurrencyInstance().format(p1 + p2 + p3));
    }
}
