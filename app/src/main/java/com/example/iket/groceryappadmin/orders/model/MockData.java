package com.example.iket.groceryappadmin.orders.model;

import com.example.iket.groceryappadmin.orders.model.data.OrderDetails;
import com.example.iket.groceryappadmin.orders.model.data.OrderList;
import com.example.iket.groceryappadmin.orders.view.OnOrdersReceived;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iket on 5/11/16.
 */
public class MockData implements OrdersProvider {
    @Override
    public void getOrders(String access_token, OnOrdersReceived onOrdersReceived) {
        List<OrderDetails> list=new ArrayList<>();
        OrderDetails orderDetails=new OrderDetails("Iket","NIT Raipur",1,"05/12/2012","Rs. 500","Packed");
        list.add(orderDetails);
        orderDetails=new OrderDetails("Ishu","NIT Raipur",2,"05/12/2015","Rs. 1500","Packed");
        list.add(orderDetails);

        OrderList orderList=new OrderList(list,"Hello",true);
        onOrdersReceived.onSuccess(orderList);


    }
}
