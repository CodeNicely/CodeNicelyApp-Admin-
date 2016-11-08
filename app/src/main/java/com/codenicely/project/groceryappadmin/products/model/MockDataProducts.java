package com.codenicely.project.groceryappadmin.products.model;

import com.codenicely.project.groceryappadmin.products.model.data.ProductDetails;
import com.codenicely.project.groceryappadmin.products.model.data.ProductList;
import com.codenicely.project.groceryappadmin.products.view.OnPriceChanged;
import com.codenicely.project.groceryappadmin.products.view.OnProductReceived;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iket on 5/11/16.
 */
public class MockDataProducts implements ProductProvider {

    @Override
    public void getOrders(String access_token, OnProductReceived onProductReceived) {
        List<ProductDetails> list=new ArrayList<>();
        ProductDetails productDetails=new ProductDetails("Mango","dsfds","1 kg","Rs. 200",1);
        list.add(productDetails);
        list.add(productDetails);
        list.add(productDetails);
        list.add(productDetails);
        ProductList productList=new ProductList(list,"Hello",true);
        onProductReceived.onSuccess(productList);
    }

    @Override
    public void changePrice(String token, int id, String name, String quantity, String cost, OnPriceChanged onPriceChanged) {

    }
}
