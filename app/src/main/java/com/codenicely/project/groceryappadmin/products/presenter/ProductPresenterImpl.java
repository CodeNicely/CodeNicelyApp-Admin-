package com.codenicely.project.groceryappadmin.products.presenter;

import com.codenicely.project.groceryappadmin.products.model.ProductProvider;
import com.codenicely.project.groceryappadmin.products.model.data.PriceData;
import com.codenicely.project.groceryappadmin.products.model.data.ProductList;
import com.codenicely.project.groceryappadmin.products.view.OnPriceChanged;
import com.codenicely.project.groceryappadmin.products.view.OnProductReceived;
import com.codenicely.project.groceryappadmin.products.view.ProductView;

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


        productView.showProgressbar(true);


        productProvider.getOrders(access_token, new OnProductReceived() {
            @Override
            public void onFailure() {
                productView.showProgressbar(false);
                productView.showMessage("Error..try again");
            }

            @Override
            public void onSuccess(ProductList productList) {
                if (productList.isSuccess()) {
                    productView.showProgressbar(false);
                    productView.onDataReceived(productList.getProductDetailses());

                } else {
                    productView.showProgressbar(false);
//                    productView.onDataReceived(categoriesList.getCategoryDatas());

                }
            }

        });
    }

    @Override
    public void changePrice(String token, int id, String name, String quantity, String cost) {
        productView.showProgressbar(true);
        productProvider.changePrice(token,id,name,quantity,cost, new OnPriceChanged() {
            @Override
            public void onFailure() {

            }

            @Override
            public void onSuccess(PriceData priceData) {

            }
        });
    }


}
