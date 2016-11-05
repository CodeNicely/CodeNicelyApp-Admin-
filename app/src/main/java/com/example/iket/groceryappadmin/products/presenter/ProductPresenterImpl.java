package com.example.iket.groceryappadmin.products.presenter;

import android.util.Log;

import com.example.iket.groceryappadmin.products.model.ProductProvider;
import com.example.iket.groceryappadmin.products.model.data.ProductList;
import com.example.iket.groceryappadmin.products.view.OnProductReceived;
import com.example.iket.groceryappadmin.products.view.ProductView;

/**
 * Created by iket on 19/10/16.
 */
public class ProductPresenterImpl implements ProductPresenter {
    private ProductView productView;
    private ProductProvider productProvider;

    public ProductPresenterImpl(ProductView productView, ProductProvider productProvider) {
        this.productView = productView;
        this.productProvider = productProvider;
    }

    @Override
    public void getProduct(final String access_token) {

        Log.d("Respo","3");

        productView.showProgressbar(true);
        Log.d("Respo","4");


        productProvider.getOrders(access_token, new OnProductReceived() {
            @Override
            public void onFailure() {
                Log.d("Respo",""+access_token);
                productView.showProgressbar(false);
                productView.showMessage("Error..try again");
            }

            @Override
            public void onSuccess(ProductList productList) {
                if (productList.isSuccess()) {
                    Log.d("Respo","success");
                    productView.showProgressbar(false);
                    productView.onDataReceived(productList.getProductDetailses());

                } else {
                    productView.showProgressbar(false);
//                    productView.onDataReceived(categoriesList.getCategoryDatas());

                }
            }

        });
    }
}
