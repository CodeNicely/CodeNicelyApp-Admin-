package com.codenicely.project.groceryappadmin.orders.view;

import com.codenicely.project.groceryappadmin.orders.model.data.OrderDetails;

import java.util.List;

/**
 * Created by iket on 19/10/16.
 */
public interface OrderView {
    void showMessage(String message);

    void showProgressbar(boolean show);

    void onDataReceived(List<OrderDetails> orderDatas);

}
