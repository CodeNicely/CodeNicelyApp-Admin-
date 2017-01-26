package com.codenicely.project.groceryappadmin.orders.model.data;

import java.util.List;

/**
 * Created by ramya on 6/11/16.
 */

public class OrdersListData {
    private String message;
    private boolean success;
    private List<OrdersListDetails> order_list;
    public OrdersListData(String message, boolean success, List<OrdersListDetails> order_list)
    {
        this.message=message;
        this.success=success;
        this.order_list = order_list;
    }


    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<OrdersListDetails> getOrder_list() {
        return order_list;
    }
}
