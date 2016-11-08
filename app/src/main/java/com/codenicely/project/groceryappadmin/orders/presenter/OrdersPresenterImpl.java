package com.codenicely.project.groceryappadmin.orders.presenter;

import com.codenicely.project.groceryappadmin.orders.model.OrdersProvider;
import com.codenicely.project.groceryappadmin.orders.OnOrdersListReceived;
import com.codenicely.project.groceryappadmin.orders.model.data.OrdersListData;
import com.codenicely.project.groceryappadmin.orders.view.OrderListView;

/**
 * Created by iket on 19/10/16.
 */
public class OrdersPresenterImpl implements OrdersPresenter {
    private OrderListView orderListView;
    private OrdersProvider orderProvider;

    public OrdersPresenterImpl(OrderListView orderListView, OrdersProvider orderProvider) {
        this.orderListView = orderListView;
        this.orderProvider = orderProvider;
    }

    @Override
    public void getOrders(String access_token,int order_type) {

        orderListView.showProgressbar(true);

        orderProvider.getOrders(access_token,order_type, new OnOrdersListReceived() {
            @Override
            public void onFailure() {
                orderListView.showProgressbar(false);
                orderListView.showMessage("Error..try again");
            }

            @Override
            public void onSuccess(OrdersListData ordersListData) {
                if (ordersListData.isSuccess()) {
                    orderListView.showProgressbar(false);
                    orderListView.onDataReceived(ordersListData.getOrder_list());

                } else {
                    orderListView.showProgressbar(false);
                    orderListView.showMessage(ordersListData.getMessage());

                }
            }

        });
    }
}
