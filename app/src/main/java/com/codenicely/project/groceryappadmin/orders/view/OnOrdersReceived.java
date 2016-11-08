package com.codenicely.project.groceryappadmin.orders.view;

import com.codenicely.project.groceryappadmin.orders.model.data.OrderList;

/**
 * Created by iket on 19/10/16.
 */
public interface OnOrdersReceived {
    void onFailure();

    void onSuccess(OrderList ordersList);
}
