package com.codenicely.project.groceryappadmin.orders.view;


import com.codenicely.project.groceryappadmin.orders.model.data.OrdersDetails;

import java.util.List;

/**
 * Created by ramya on 6/11/16.
 */

public interface OrderDetails {
    void showProgressBar(boolean show);
    void setOrdersList(List<OrdersDetails> ordersListDataDetails);
    void showMessage(String error);
}
