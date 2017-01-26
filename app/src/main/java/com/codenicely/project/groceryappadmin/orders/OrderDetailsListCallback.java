package com.codenicely.project.groceryappadmin.orders;


import com.codenicely.project.groceryappadmin.orders.model.data.OrderData;

/**
 * Created by ramya on 6/11/16.
 */

public interface OrderDetailsListCallback {
    void onSuccess(OrderData orderData);
    void onFailure(String message);
}
