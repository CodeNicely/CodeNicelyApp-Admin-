package com.codenicely.project.groceryappadmin.orders.presenter;

/**
 * Created by meghal on 9/11/16.
 */

public interface OrderStatusChangePresenter {

    void requestOrderStatusChange(String access_token,String order_id,boolean cancle);

}
