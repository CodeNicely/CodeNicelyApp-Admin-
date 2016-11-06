package com.example.iket.groceryappadmin.orders.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.iket.groceryappadmin.R;
import com.example.iket.groceryappadmin.helper.image_loader.GlideImageLoader;
import com.example.iket.groceryappadmin.helper.image_loader.ImageLoader;
import com.example.iket.groceryappadmin.orders.model.data.OrderDetails;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by iket on 19/10/16.
 */
public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.MyViewHolder> {
    private List<OrderDetails> OrderLists = new ArrayList<>();
    private Context context;
    private OrderView orderView;
    private LayoutInflater layoutInflater;
    private OrdersFragment ordersFragment;
    private ImageLoader imageLoader;

    public OrdersAdapter(Context context, OrdersFragment ordersFragment) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        orderView = new OrdersFragment();
        this.ordersFragment = ordersFragment;
        imageLoader = new GlideImageLoader(context);
    }

    public void setData(List<OrderDetails> cityScreenDetailsList) {
       OrderLists = cityScreenDetailsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.orders_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final OrderDetails orderDetails = OrderLists.get(position);
        holder.action.setText(orderDetails.getAction());
        holder.address.setText(orderDetails.getAddress());
        holder.cost.setText(orderDetails.getCost());
        holder.id.setText("Order Id:"+orderDetails.getId());
        holder.username.setText(orderDetails.getName());
        holder.date.setText(orderDetails.getDate());

    }


    @Override
    public int getItemCount() {
        return OrderLists.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {



        private EditText cost;

        private TextView address,date,id,username;

        private Button cancel,action;

        private MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            cost=(EditText)itemView.findViewById(R.id.order_cost);
            address=(TextView)itemView.findViewById(R.id.order_address);
            date=(TextView)itemView.findViewById(R.id.order_date);
            id=(TextView)itemView.findViewById(R.id.order_id);
            username=(TextView)itemView.findViewById(R.id.order_username);
            cancel=(Button) itemView.findViewById(R.id.cancel);
            action=(Button) itemView.findViewById(R.id.action);

        }

    }

}
