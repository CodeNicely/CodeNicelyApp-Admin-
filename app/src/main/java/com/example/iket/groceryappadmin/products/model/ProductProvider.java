package com.example.iket.groceryappadmin.products.model;


import com.example.iket.groceryappadmin.products.view.OnPriceChanged;
import com.example.iket.groceryappadmin.products.view.OnProductReceived;

/**
 * Created by iket on 19/10/16.
 */
public interface ProductProvider {
    void getOrders(String access_token, OnProductReceived onProductReceived);

    void changePrice(String token, int id, String name, String quantity, String cost, OnPriceChanged onPriceChanged);

}
