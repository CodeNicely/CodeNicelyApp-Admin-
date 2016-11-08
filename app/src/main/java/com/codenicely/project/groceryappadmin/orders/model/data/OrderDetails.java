package com.codenicely.project.groceryappadmin.orders.model.data;

/**
 * Created by iket on 19/10/16.
 */
public class OrderDetails {
    private String name,address,date,cost,action;
    private int id;

    public OrderDetails(String name, String address, int id, String date, String cost, String action) {
        this.name = name;
        this.address = address;
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getCost() {
        return cost;
    }

    public String getAction() {
        return action;
    }
}
