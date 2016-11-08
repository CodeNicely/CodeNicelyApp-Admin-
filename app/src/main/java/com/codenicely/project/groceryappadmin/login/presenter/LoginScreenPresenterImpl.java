package com.codenicely.project.groceryappadmin.login.presenter;

import android.util.Log;

import com.codenicely.project.groceryappadmin.login.LoginCallback;
import com.codenicely.project.groceryappadmin.login.models.LoginProvider;
import com.codenicely.project.groceryappadmin.login.models.data.LoginData;
import com.codenicely.project.groceryappadmin.login.view.LoginScreenView;


/**
 * Created by aman on 15/10/16.
 */
public class LoginScreenPresenterImpl implements LoginScreenPresenter {

    private LoginScreenView loginView;
    private LoginProvider loginProvider;

    public LoginScreenPresenterImpl(LoginScreenView loginView, LoginProvider loginProvider) {
        this.loginView = loginView;
        this.loginProvider = loginProvider;
    }

    @Override
    public void requestLogin(String mobile, String password,String fcm) {

        loginView.showLoading(true);
        Log.d("Resp", "1");
        loginProvider.requestLogin(mobile,password,fcm, new LoginCallback() {
            @Override
            public void onSuccess(LoginData loginData) {
                if (loginData.isSuccess()) {
                    loginView.showLoading(false);
                    loginView.onLoginVerified(loginData.getAccess_token());
                } else {
                    loginView.showLoading(false);
                    loginView.showMessage(loginData.getMessage());
                }

            }

            public void onFailure(String error) {
                loginView.showLoading(false);
                loginView.showMessage("No Internet Connection");

            }
        });


    }
}

