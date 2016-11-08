package com.codenicely.project.groceryappadmin.orders.model;


import com.codenicely.project.groceryappadmin.orders.view.OnOrdersReceived;

/**
 * Created by iket on 19/10/16.
 */
public interface OrdersProvider {
    void getOrders(String access_token, OnOrdersReceived onOrdersReceived);

}
