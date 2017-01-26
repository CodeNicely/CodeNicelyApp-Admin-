package com.codenicely.project.groceryappadmin.products.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.codenicely.project.groceryappadmin.R;
import com.codenicely.project.groceryappadmin.helper.image_loader.GlideImageLoader;
import com.codenicely.project.groceryappadmin.helper.image_loader.ImageLoader;
import com.codenicely.project.groceryappadmin.products.model.data.ProductDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iket on 19/10/16.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private List<ProductDetails> productDetailses = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;

    public ProductAdapter(Context context, ProductFragment productFragment) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        imageLoader = new GlideImageLoader(context);
    }

    public void setData(List<ProductDetails> cityScreenDetailsList) {
        productDetailses = cityScreenDetailsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.product_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final ProductDetails productDetails = productDetailses.get(position);
        holder.name.setText(productDetails.getName());
        holder.size.setText(productDetails.getQuantity());
        holder.price.setText(productDetails.getPrice());
        holder.change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductFragment.changePrice(productDetails.getId(),holder.name.getText().toString(),holder.size.getText().toString(),holder.price.getText().toString());
            }
        });

//        imageLoader.loadImage(productDetails.getImage(), holder.image, holder.imageProgressBar);
    }


    @Override
    public int getItemCount() {
        return productDetailses.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {

      private  ImageView image;
        private Button change;

      private  EditText name,size,price;

        private MyViewHolder(View itemView) {
            super(itemView);

            image=(ImageView)itemView.findViewById(R.id.productImage);
            name=(EditText)itemView.findViewById(R.id.productName);
            size=(EditText)itemView.findViewById(R.id.productSize);
            price=(EditText)itemView.findViewById(R.id.productPrice);
            change=(Button)itemView.findViewById(R.id.change_price);

        }

    }

}
