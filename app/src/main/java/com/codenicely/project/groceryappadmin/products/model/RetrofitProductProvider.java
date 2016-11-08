package com.codenicely.project.groceryappadmin.products.model;


import com.codenicely.project.groceryappadmin.helper.Urls;
import com.codenicely.project.groceryappadmin.products.api.RequestProduct;
import com.codenicely.project.groceryappadmin.products.model.data.PriceData;
import com.codenicely.project.groceryappadmin.products.model.data.ProductList;
import com.codenicely.project.groceryappadmin.products.view.OnPriceChanged;
import com.codenicely.project.groceryappadmin.products.view.OnProductReceived;
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
public class RetrofitProductProvider implements ProductProvider {
    private RequestProduct requestProduct;

    public RetrofitProductProvider() {
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
        requestProduct = retrofit.create(RequestProduct.class);

    }

    @Override
    public void getOrders(String access_token, final OnProductReceived onProductReceived) {
        Call<ProductList> call = requestProduct.getProduct(access_token);
        call.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                onProductReceived.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                onProductReceived.onFailure();
                t.printStackTrace();
            }
        });

    }

    @Override
    public void changePrice(String token, int id, String name, String quantity, String cost, final OnPriceChanged onPriceChanged) {
        Call<PriceData> call=requestProduct.changePrice(token,id,name,quantity,cost);
        call.enqueue(new Callback<PriceData>() {
            @Override
            public void onResponse(Call<PriceData> call, Response<PriceData> response) {
                onPriceChanged.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<PriceData> call, Throwable t) {
                t.printStackTrace();
                onPriceChanged.onFailure();

            }
        });

    }
}
