package com.codenicely.project.groceryappadmin.orders.presenter;


import com.codenicely.project.groceryappadmin.orders.OrderDetailsListCallback;
import com.codenicely.project.groceryappadmin.orders.model.OrderDetailsProvider;
import com.codenicely.project.groceryappadmin.orders.model.data.OrderData;
import com.codenicely.project.groceryappadmin.orders.view.OrderDetails;

/**
 * Created by ramya on 6/11/16.
 */

public class OrderDetailsPresenterImp implements OrderDetailsPresenter {
    private OrderDetails orderDetails;
    private OrderDetailsProvider orderDetailsProvider;
    public OrderDetailsPresenterImp(OrderDetails orderDetails,OrderDetailsProvider orderDetailsProvider)
    {
        this.orderDetailsProvider = orderDetailsProvider;
        this.orderDetails=orderDetails;
    }
    @Override
    public void getOrderDataDetails(String access_token, final String order_id) {
        orderDetails.showProgressBar(true);
            orderDetailsProvider.getOrderDetails(access_token, order_id, new OrderDetailsListCallback() {
                @Override
                public void onSuccess(OrderData orderData) {
                    orderDetails.showProgressBar(false);
                    if(orderData.isSuccess())
                    {
                        orderDetails.setOrdersList(orderData.getOrder_items_list());
                    }
                    else
                    {
                        orderDetails.showMessage(orderData.getMessage());
                    }

                }

                @Override
                public void onFailure(String message) {
                    orderDetails.showMessage(message);

                }
            });
    }
}
