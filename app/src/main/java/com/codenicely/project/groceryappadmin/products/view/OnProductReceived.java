package com.codenicely.project.groceryappadmin.products.view;

import com.codenicely.project.groceryappadmin.products.model.data.ProductList;

/**
 * Created by iket on 19/10/16.
 */
public interface OnProductReceived {
    void onFailure();

    void onSuccess(ProductList productList);
}
