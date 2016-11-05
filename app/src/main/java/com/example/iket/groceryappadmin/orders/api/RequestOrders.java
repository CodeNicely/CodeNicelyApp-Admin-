package com.example.iket.groceryappadmin.orders.api;



import com.example.iket.groceryappadmin.helper.Urls;
import com.example.iket.groceryappadmin.orders.model.data.OrderList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by iket on 19/10/16.
 */
public interface RequestOrders {
    @GET(Urls.CATEGORIES)
    Call<OrderList> getOrders(@Query("access_token") String access_token);
}
