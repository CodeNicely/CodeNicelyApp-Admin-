package com.codenicely.project.groceryappadmin.orders.model;

import com.codenicely.project.groceryappadmin.helper.Urls;
import com.codenicely.project.groceryappadmin.orders.OrderDetailsListCallback;
import com.codenicely.project.groceryappadmin.orders.api.RequestOrderDetailsList;
import com.codenicely.project.groceryappadmin.orders.model.data.OrderData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ramya on 6/11/16.
 */

public class RetrofitOrderDetailsProvider implements OrderDetailsProvider {
    @Override
    public void getOrderDetails(String access_token, final String order_id, final OrderDetailsListCallback orderDetailsListCallback) {
        Retrofit retrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(Urls.BASE_URL).build();
        final RequestOrderDetailsList requestOrderDetailsList = retrofit.create(RequestOrderDetailsList.class);
       Call<OrderData> call =requestOrderDetailsList.getOrderDetailsList(access_token,order_id);
        call.enqueue(new Callback<OrderData>() {
            @Override
            public void onResponse(Call<OrderData> call, Response<OrderData> response) {
                orderDetailsListCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<OrderData> call, Throwable t) {
                orderDetailsListCallback.onFailure(t.getMessage());

            }
        });

    }
}
