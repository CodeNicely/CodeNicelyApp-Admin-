package com.codenicely.project.groceryappadmin.login.models.data;


public class LoginData {

    private String message;
    private boolean success;
    private String access_token;


    public LoginData(String message, boolean success,String access_token) {
        this.message = message;
        this.success = success;
        this.access_token=access_token;
    }


    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getAccess_token() {
        return access_token;
    }
}
