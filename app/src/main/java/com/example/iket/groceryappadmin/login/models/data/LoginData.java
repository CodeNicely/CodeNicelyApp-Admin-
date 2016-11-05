package com.example.iket.groceryappadmin.login.models.data;


public class LoginData {

    private String message;
    private boolean success;


    public LoginData(String message, boolean success) {
        this.message = message;
        this.success = success;
    }


    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

}
