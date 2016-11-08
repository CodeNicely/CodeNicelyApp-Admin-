package com.codenicely.project.groceryappadmin.orders.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.codenicely.project.groceryappadmin.R;
import com.codenicely.project.groceryappadmin.helper.image_loader.GlideImageLoader;
import com.codenicely.project.groceryappadmin.helper.image_loader.ImageLoader;
import com.codenicely.project.groceryappadmin.orders.model.data.OrdersDetails;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ramya on 6/11/16.
 */

public class OrderDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<OrdersDetails> ordersListDataDetailsList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;
    private OrdersDetails ordersDetails;
    private OrderDetailsFragment orderDetailsFragment;
    private ImageLoader imageLoader;

    public OrderDetailsAdapter(Context context, OrderDetailsFragment orderDetailsFragment) {
        this.context = context;
        this.orderDetailsFragment = orderDetailsFragment;
        this.layoutInflater = LayoutInflater.from(context);
        imageLoader = new GlideImageLoader(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.order_details_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ordersDetails = ordersListDataDetailsList.get(position);
        ProductViewHolder productViewHolder = (ProductViewHolder) holder;
        productViewHolder.product_size.setText(String.valueOf(ordersDetails.getSize()) + " " + ordersDetails.getUnit());
        productViewHolder.quantity.setText(String.valueOf(ordersDetails.getQuantity()));
        productViewHolder.quantity1.setText(String.valueOf(ordersDetails.getQuantity()));
        productViewHolder.product_total.setText(String.valueOf(ordersDetails.getSize() * ordersDetails.getQuantity()) + " " + ordersDetails.getUnit());

        productViewHolder.product_price.setText("Rs. " + String.valueOf(ordersDetails.getPrice()));
        productViewHolder.product_name.setText(ordersDetails.getName());
        productViewHolder.product_cost.setText("Rs. " + String.valueOf(ordersDetails.getPrice() * ordersDetails.getQuantity()));
        imageLoader.loadImage(ordersDetails.getImage(), productViewHolder.product_image, productViewHolder.image_progress_bar);
    }

    public void setData(List<OrdersDetails> orderListDataDetails) {
        this.ordersListDataDetailsList = orderListDataDetails;
    }

    @Override
    public int getItemCount() {
        return ordersListDataDetailsList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.productImage)
        ImageView product_image;
        @BindView(R.id.imageProgressBar)
        ProgressBar image_progress_bar;
        @BindView(R.id.product_name)
        TextView product_name;
        @BindView(R.id.product_amount)
        TextView product_size;
        @BindView(R.id.quantity)
        TextView quantity;
        @BindView(R.id.product_total)
        TextView product_total;
        @BindView(R.id.product_price)
        TextView product_price;
        @BindView(R.id.quantity1)
        TextView quantity1;
        @BindView(R.id.product_cost)
        TextView product_cost;

        public ProductViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }
    }
}
