package com.codenicely.project.groceryappadmin.orders.api;

import com.codenicely.project.groceryappadmin.helper.Urls;
import com.codenicely.project.groceryappadmin.orders.model.data.ChangeStatusData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by meghal on 9/11/16.
 */

public interface OrderStatusChangeApi {

    @FormUrlEncoded
    @POST(Urls.SUB_URL_ADMIN_CHANGE_STATUS)
    Call<ChangeStatusData> requestOrderStatusChange(@Field("access_token") String access_token, @Field("order_id") String order_id
            , @Field("cancel") boolean type);

}
