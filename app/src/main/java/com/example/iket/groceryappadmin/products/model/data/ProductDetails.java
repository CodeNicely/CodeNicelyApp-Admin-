package com.example.iket.groceryappadmin.products.model.data;

/**
 * Created by iket on 19/10/16.
 */
public class ProductDetails {
    private String name, image,quantity,price;
    private int id;

    public ProductDetails(String name, String image, String quantity, String price, int id) {
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
