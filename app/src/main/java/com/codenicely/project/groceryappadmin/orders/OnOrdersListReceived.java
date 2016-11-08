package com.codenicely.project.groceryappadmin.orders;

import com.codenicely.project.groceryappadmin.orders.model.data.OrdersListData;

/**
 * Created by iket on 19/10/16.
 */
public interface OnOrdersListReceived {
    void onFailure();

    void onSuccess(OrdersListData ordersList);
}
