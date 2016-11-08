package com.codenicely.project.groceryappadmin.login;


import com.codenicely.project.groceryappadmin.login.models.data.LoginData;

/**
 * Created by aman on 15/10/16.
 */
public interface LoginCallback {
    void onSuccess(LoginData loginData);

    void onFailure(String error);

}
