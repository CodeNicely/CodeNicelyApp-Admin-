package com.codenicely.project.groceryappadmin.products.model.data;

/**
 * Created by iket on 6/11/16.
 */
public class PriceData {
    private String message;
    private boolean success;

    public PriceData(String message, boolean success) {
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
