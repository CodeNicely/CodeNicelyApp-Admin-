package com.codenicely.project.groceryappadmin.orders.model;

import com.codenicely.project.groceryappadmin.helper.Urls;
import com.codenicely.project.groceryappadmin.orders.OnOrderStatusChanged;
import com.codenicely.project.groceryappadmin.orders.api.OrderStatusChangeApi;
import com.codenicely.project.groceryappadmin.orders.model.data.ChangeStatusData;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by meghal on 9/11/16.
 */

public class RetrofitOrderStatusChangeHelper implements OrderStatusChangeHelper {

    private OrderStatusChangeApi orderStatusChangeApi;

    public RetrofitOrderStatusChangeHelper() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES).addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        orderStatusChangeApi = retrofit.create(OrderStatusChangeApi.class);


    }

    @Override
    public void changeOrderStatus(String access_token, String order_id, boolean cancle, final OnOrderStatusChanged onOrderStatusChanged) {


        Call<ChangeStatusData> changeStatusDataCall =
                orderStatusChangeApi.requestOrderStatusChange(access_token, order_id, cancle);

        changeStatusDataCall.enqueue(new Callback<ChangeStatusData>() {
            @Override
            public void onResponse(Call<ChangeStatusData> call, Response<ChangeStatusData> response) {

                onOrderStatusChanged.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ChangeStatusData> call, Throwable t) {

                onOrderStatusChanged.onFailed();
                t.printStackTrace();
            }
        });


    }
}
