package com.codenicely.project.groceryappadmin.orders.model;


import com.codenicely.project.groceryappadmin.orders.OrderDetailsListCallback;

/**
 * Created by ramya on 6/11/16.
 */

public interface OrderDetailsProvider {
    void getOrderDetails(String access_token, String order_id, OrderDetailsListCallback orderDetailsListCallback);
}
