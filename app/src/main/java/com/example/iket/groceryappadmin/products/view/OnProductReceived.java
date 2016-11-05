package com.example.iket.groceryappadmin.products.view;

import com.example.iket.groceryappadmin.products.model.data.ProductList;

/**
 * Created by iket on 19/10/16.
 */
public interface OnProductReceived {
    void onFailure();

    void onSuccess(ProductList productList);
}
