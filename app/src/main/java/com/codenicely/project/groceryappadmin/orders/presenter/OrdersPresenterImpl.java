package com.codenicely.project.groceryappadmin.orders.presenter;

import com.codenicely.project.groceryappadmin.orders.model.OrdersProvider;
import com.codenicely.project.groceryappadmin.orders.model.data.OrderList;
import com.codenicely.project.groceryappadmin.orders.view.OnOrdersReceived;
import com.codenicely.project.groceryappadmin.orders.view.OrderView;

/**
 * Created by iket on 19/10/16.
 */
public class OrdersPresenterImpl implements OrdersPresenter {
    private OrderView orderView;
    private OrdersProvider orderProvider;

    public OrdersPresenterImpl(OrderView orderView, OrdersProvider orderProvider) {
        this.orderView = orderView;
        this.orderProvider = orderProvider;
    }

    @Override
    public void getOrders(String access_token) {

        orderView.showProgressbar(true);

        orderProvider.getOrders(access_token, new OnOrdersReceived() {
            @Override
            public void onFailure() {
                orderView.showProgressbar(false);
                orderView.showMessage("Error..try again");
            }

            @Override
            public void onSuccess(OrderList orderList) {
                if (orderList.isSuccess()) {
                    orderView.showProgressbar(false);
                    orderView.onDataReceived(orderList.getOrderDetailses());

                } else {
                    orderView.showProgressbar(false);
                    orderView.showMessage(orderList.getMessage());

                }
            }

        });
    }
}
