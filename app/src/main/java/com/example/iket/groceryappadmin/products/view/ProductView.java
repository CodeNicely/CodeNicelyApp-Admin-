package com.example.iket.groceryappadmin.products.view;

import com.example.iket.groceryappadmin.products.model.data.ProductDetails;

import java.util.List;

/**
 * Created by iket on 19/10/16.
 */
public interface ProductView {
    void showMessage(String message);

    void showProgressbar(boolean show);

    void onDataReceived(List<ProductDetails> detailsList);

}
