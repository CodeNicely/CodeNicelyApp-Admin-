package com.codenicely.project.groceryappadmin.login.view;

/**
 * Created by aman on 15/10/16.
 */
public interface LoginScreenView {


    void showLoading(boolean show);

    void showMessage(String message);

    void onLoginVerified(String access_token);



}

