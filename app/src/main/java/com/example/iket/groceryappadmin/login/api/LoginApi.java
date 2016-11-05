package com.example.iket.groceryappadmin.login.api;



import com.example.iket.groceryappadmin.helper.Urls;
import com.example.iket.groceryappadmin.login.models.data.LoginData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by aman on 15/10/16.
 */
public interface LoginApi {

    @FormUrlEncoded
    @POST(Urls.SEND_OTP)
    Call<LoginData> requestLogin(@Field("name") String name, @Field("mobile") String mobile,
                                 @Field("email") String email);


}


