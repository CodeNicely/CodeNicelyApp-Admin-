package com.example.iket.groceryappadmin.orders.view;

import com.example.iket.groceryappadmin.orders.model.data.OrderList;

/**
 * Created by iket on 19/10/16.
 */
public interface OnOrdersReceived {
    void onFailure();

    void onSuccess(OrderList ordersList);
}
