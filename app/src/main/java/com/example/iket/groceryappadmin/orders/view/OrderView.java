package com.example.iket.groceryappadmin.orders.view;

import com.example.iket.groceryappadmin.orders.model.data.OrderDetails;

import java.util.List;

/**
 * Created by iket on 19/10/16.
 */
public interface OrderView {
    void showMessage(String message);

    void showProgressbar(boolean show);

    void onDataReceived(List<OrderDetails> orderDatas);

}
