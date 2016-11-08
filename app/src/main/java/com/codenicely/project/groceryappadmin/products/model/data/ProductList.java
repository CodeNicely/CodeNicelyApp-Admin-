package com.codenicely.project.groceryappadmin.products.model.data;

import java.util.List;

/**
 * Created by iket on 19/10/16.
 */
public class ProductList {
    private List<ProductDetails> productDetailses;
    private String message;
    private boolean success;

    public ProductList(List<ProductDetails> productDetailses, String message, boolean success) {
        this.productDetailses = productDetailses;
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<ProductDetails> getProductDetailses() {
        return productDetailses;
    }

}
