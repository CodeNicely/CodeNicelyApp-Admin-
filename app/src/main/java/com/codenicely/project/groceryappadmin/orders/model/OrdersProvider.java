package com.codenicely.project.groceryappadmin.orders.model;


import com.codenicely.project.groceryappadmin.orders.OnOrdersListReceived;

/**
 * Created by iket on 19/10/16.
 */
public interface OrdersProvider {
    void getOrders(String access_token,int order_type, OnOrdersListReceived onOrdersListReceived);

}
