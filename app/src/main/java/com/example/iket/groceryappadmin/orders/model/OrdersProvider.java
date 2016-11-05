package com.example.iket.groceryappadmin.orders.model;


import com.example.iket.groceryappadmin.orders.view.OnOrdersReceived;

/**
 * Created by iket on 19/10/16.
 */
public interface OrdersProvider {
    void getOrders(String access_token, OnOrdersReceived onOrdersReceived);

}
