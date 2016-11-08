package com.codenicely.project.groceryappadmin.orders.model.data;

import java.util.List;

/**
 * Created by iket on 19/10/16.
 */
public class OrderList {
    private List<OrderDetails> orderDetailses;
    private String message;
    private boolean success;

    public OrderList(List<OrderDetails> orderDetailses, String message, boolean success) {
        this.orderDetailses = orderDetailses;
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<OrderDetails> getOrderDetailses() {
        return orderDetailses;
    }
}
