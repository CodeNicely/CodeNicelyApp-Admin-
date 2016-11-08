package com.codenicely.project.groceryappadmin.orders.model;


import com.codenicely.project.groceryappadmin.helper.Urls;
import com.codenicely.project.groceryappadmin.orders.api.RequestOrders;
import com.codenicely.project.groceryappadmin.orders.OnOrdersListReceived;
import com.codenicely.project.groceryappadmin.orders.model.data.OrdersListData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by iket on 19/10/16.
 */
public class RetrofitOrdersProvider implements OrdersProvider {
    private RequestOrders requestOrders;

    public RetrofitOrdersProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .build();


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        requestOrders = retrofit.create(RequestOrders.class);

    }

    @Override
    public void getOrders(String access_token,int order_type, final OnOrdersListReceived onOrdersListReceived) {
        Call<OrdersListData> call = requestOrders.getOrders(access_token,order_type);
        call.enqueue(new Callback<OrdersListData>() {
            @Override
            public void onResponse(Call<OrdersListData> call, Response<OrdersListData> response) {
                onOrdersListReceived.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<OrdersListData> call, Throwable t) {
                onOrdersListReceived.onFailure();
                t.printStackTrace();
            }
        });

    }
}
