package com.codenicely.project.groceryappadmin.orders.presenter;

import com.codenicely.project.groceryappadmin.orders.OnOrderStatusChanged;
import com.codenicely.project.groceryappadmin.orders.model.OrderStatusChangeHelper;
import com.codenicely.project.groceryappadmin.orders.model.data.ChangeStatusData;
import com.codenicely.project.groceryappadmin.orders.view.OrderStatusChangeView;

/**
 * Created by meghal on 9/11/16.
 */

public class OrderStatusChangePresenterImpl implements OrderStatusChangePresenter {


    private OrderStatusChangeView orderStatusChangeView;
    private OrderStatusChangeHelper orderStatusChangeHelper;

    public OrderStatusChangePresenterImpl(OrderStatusChangeView orderStatusChangeView, OrderStatusChangeHelper orderStatusChangeHelper) {
        this.orderStatusChangeView = orderStatusChangeView;
        this.orderStatusChangeHelper = orderStatusChangeHelper;
    }

    @Override
    public void requestOrderStatusChange(String access_token, String order_id, boolean cancle) {

        if (cancle) {
            orderStatusChangeView.showDialogLoader("Canceling", true);
        } else {
            orderStatusChangeView.showDialogLoader("Changing Status", true);
        }

        orderStatusChangeHelper.changeOrderStatus(access_token, order_id, cancle, new OnOrderStatusChanged() {
            @Override
            public void onSuccess(ChangeStatusData changeStatusData) {

                if(changeStatusData.isSuccess()){

                    orderStatusChangeView.showDialogLoader("Canceling", false);
                    orderStatusChangeView.onStatusChanged(changeStatusData);

                }
            }

            @Override
            public void onFailed() {

                orderStatusChangeView.showMessage("Unable to connect to servers ! Please check your internet connection");
            }
        });


    }
}
