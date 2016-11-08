package com.codenicely.project.groceryappadmin.products.view;

import com.codenicely.project.groceryappadmin.products.model.data.PriceData;

/**
 * Created by iket on 19/10/16.
 */
public interface OnPriceChanged {
    void onFailure();

    void onSuccess(PriceData priceData);
}
