package com.engeto;

import java.time.LocalDate;
import java.util.ArrayList;

public class Restaurant {


    ArrayList<Order> orderList = new ArrayList<>();


    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();

        Item item1 = new Item("Halusky", 99);
        Item item2 = new Item("Rizek", 150);
        Item item3 = new Item("Pivko", 35);


        Order order1 = new Order(1,TableNumber.TABLE_5, LocalDate.now(), Payment.CASH);
        order1.items.add(item1);
        order1.items.add(item1);
        order1.items.add(item3);
        order1.items.add(item3);
        order1.items.add(item3);
        order1.items.add(item3);
        order1.items.add(item3);
        order1.items.add(item3);

        Order order2 = new Order(1, TableNumber.TABLE_1, LocalDate.now(),Payment.CARD);
        order2.items.add(item2);
        order2.items.add(item3);
        order2.items.add(item3);
        order2.items.add(item3);
        order2.items.add(item3);


        restaurant.orderList.add(order1);
        restaurant.orderList.add(order2);

        System.out.println("Pocet objedavek: " + restaurant.numberOfOrders());
        System.out.println("Clekovy vydelek restaurace: " + restaurant.totalSpent());
        System.out.println("Prodanych pivek: " + restaurant.sellItems("Pivko"));
        System.out.println("Utrata stolu 5: " + restaurant.tableSpent(TableNumber.TABLE_5));
        System.out.println("Utrata stolu 1: " + restaurant.tableSpent(TableNumber.TABLE_1));

    }

    int numberOfOrders(){
        return this.orderList.size();
    }

    int totalSpent(){
        int spent = 0;
        for (Order order : this.orderList){
            for (Item item : order.items ){
                spent += item.price;
            }
        }
        return spent;
    }


    int sellItems(String name){
        int spent = 0;
        for (Order order : this.orderList){
            for (Item item : order.items){
                if (name.equals(item.name)){
                    spent += item.quantity;
                }
            }
        }
        return spent;
    }

    int tableSpent (TableNumber tableNumber){
        int spent = 0;
        for (Order order : this.orderList){
            if (order.tableNumber == tableNumber){
                for (Item item : order.items){
                    spent += item.price;
                }
            }
        }

        return spent;
    }

}
