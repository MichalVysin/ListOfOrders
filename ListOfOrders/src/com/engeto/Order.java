package com.engeto;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {

    public int orderNumber;
    public TableNumber tableNumber;
    public LocalDate date;
    public Payment payment;
    public ArrayList<Item> items = new ArrayList<>();



    public Order(){

    }


    public Order(int orderNumber, TableNumber tableNumber, LocalDate date, Payment payment){
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.date = date;
        this.payment = payment;

    }







}

