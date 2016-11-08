package com.codenicely.project.groceryappadmin.products.api;



import com.codenicely.project.groceryappadmin.helper.Urls;
import com.codenicely.project.groceryappadmin.products.model.data.PriceData;
import com.codenicely.project.groceryappadmin.products.model.data.ProductList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by iket on 19/10/16.
 */
public interface RequestProduct {
    @GET(Urls.CATEGORIES)
    Call<ProductList> getProduct(@Query("access_token") String access_token);

    @GET(Urls.CATEGORIES)
    Call<PriceData>changePrice(@Query("access")String token,@Query("product_id")int id,@Query("name")String name,@Query("quantity")String quantity,@Query("cost")String cost);

}
