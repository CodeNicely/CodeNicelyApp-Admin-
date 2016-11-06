package com.example.iket.groceryappadmin.login.models;


import com.example.iket.groceryappadmin.login.LoginCallback;

/**
 * Created by aman on 15/10/16.
 */
public interface LoginProvider {

    void requestLogin(String mobile, String password, LoginCallback loginUsCallback);

}
