package com.codenicely.project.groceryappadmin.orders.model.data;

/**
 * Created by ramya on 6/11/16.
 */

public class OrdersDetails {
    private String image;
    private String name;
    private int quantity;
    private int price;
    private int discounted_price;
    private String unit;
    private int size;

    public OrdersDetails(String image, String name, String unit, int size, int
            quantity, int price, int discounted_price) {
        this.image = image;
        this.name = name;
        this.unit = unit;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.discounted_price = discounted_price;
    }


    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public int getSize() {
        return size;
    }

    public int getDiscounted_price() {
        return discounted_price;
    }

    public int getPrice() {
        return price;
    }
}
