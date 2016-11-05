package com.example.iket.groceryappadmin.products.api;



import com.example.iket.groceryappadmin.helper.Urls;
import com.example.iket.groceryappadmin.products.model.data.ProductList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by iket on 19/10/16.
 */
public interface RequestProduct {
    @GET(Urls.CATEGORIES)
    Call<ProductList> getProduct(@Query("access_token") String access_token);
}
