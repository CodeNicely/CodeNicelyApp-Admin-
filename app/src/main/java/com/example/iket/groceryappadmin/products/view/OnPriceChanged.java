package com.example.iket.groceryappadmin.products.view;

import com.example.iket.groceryappadmin.products.model.data.PriceData;
import com.example.iket.groceryappadmin.products.model.data.ProductList;

/**
 * Created by iket on 19/10/16.
 */
public interface OnPriceChanged {
    void onFailure();

    void onSuccess(PriceData priceData);
}
