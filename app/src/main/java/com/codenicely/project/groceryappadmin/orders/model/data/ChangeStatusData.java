package com.codenicely.project.groceryappadmin.orders.model.data;

/**
 * Created by meghal on 9/11/16.
 */

public class ChangeStatusData {

    private boolean success;
    private String message;

    public ChangeStatusData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
