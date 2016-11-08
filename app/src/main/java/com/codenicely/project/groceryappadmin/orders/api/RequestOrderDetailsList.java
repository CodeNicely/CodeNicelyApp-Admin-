package com.codenicely.project.groceryappadmin.orders.api;

import com.codenicely.project.groceryappadmin.helper.Urls;
import com.codenicely.project.groceryappadmin.orders.model.data.OrderData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ramya on 6/11/16.
 */

public interface RequestOrderDetailsList {
    @GET(Urls.SUB_URL_ORDERS_DETAILS)
    Call<OrderData> getOrderDetailsList(@Query("access_token") String access_token, @Query("order_id") String order_id);
}
