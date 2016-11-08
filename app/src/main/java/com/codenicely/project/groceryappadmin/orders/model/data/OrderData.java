package com.codenicely.project.groceryappadmin.orders.model.data;

import java.util.List;

/**
 * Created by ramya on 6/11/16.
 */

public class OrderData {
    private boolean success;
    private String message;
    private List<OrdersDetails> order_items_list;

    public OrderData(boolean success, String message, List<OrdersDetails> order_items_list)
    {
        this.success=success;
        this.message=message;
        this.order_items_list = order_items_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<OrdersDetails> getOrder_items_list() {
        return order_items_list;
    }
}
