package com.codenicely.project.groceryappadmin.login.models;


import com.codenicely.project.groceryappadmin.login.LoginCallback;

/**
 * Created by aman on 15/10/16.
 */
public interface LoginProvider {

    void requestLogin(String mobile, String password,String fcm, LoginCallback loginUsCallback);

}
