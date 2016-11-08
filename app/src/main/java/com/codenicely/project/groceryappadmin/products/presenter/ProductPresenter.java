package com.codenicely.project.groceryappadmin.products.presenter;

/**
 * Created by iket on 19/10/16.
 */
public interface ProductPresenter {
    void getProduct(String access_token);
    void changePrice(String token, int id, String name, String quantity, String cost);



}
