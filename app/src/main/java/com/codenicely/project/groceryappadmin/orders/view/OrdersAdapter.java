package com.codenicely.project.groceryappadmin.orders.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.codenicely.project.groceryappadmin.R;
import com.codenicely.project.groceryappadmin.home.HomeActivity;
import com.codenicely.project.groceryappadmin.home.HomePage;
import com.codenicely.project.groceryappadmin.orders.model.data.OrdersListDetails;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ramya on 6/11/16.
 */

public class OrdersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<OrdersListDetails> ordersDataList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;
    private OrdersListDetails ordersListDetails;
    private OrdersListFragment ordersListFragment;

    public OrdersAdapter(Context context, OrdersListFragment ordersListFragment) {
        this.context = context;
        this.ordersListFragment = ordersListFragment;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.orders_list_item, parent, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ordersListDetails = ordersDataList.get(position);
        final ViewHolder1 viewHolder = (ViewHolder1) holder;

        viewHolder.order_status.setText(ordersListDetails.getStatus());

                viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                if (context instanceof HomeActivity) {
                    OrderDetailsFragment orderDetailsFragment = new OrderDetailsFragment();
                    Bundle args = new Bundle();
                    args.putString("order_id", ordersDataList.get(position).getOrder_id());
                    Log.d("order_id",ordersDataList.get(position).getOrder_id());
                    orderDetailsFragment.setArguments(args);
                    ((HomeActivity) context).addFragment(orderDetailsFragment, "Order Details");
                }
            }
        });
        viewHolder.order_status_time.setText("Order Placed On " + ordersListDetails.getCreated_time());
        viewHolder.order_id.setText(String.valueOf(ordersListDetails.getOrder_id()));
        viewHolder.total_amount.setText("Rs. " + ordersListDetails.getTotal_bill());
        viewHolder.subtotal_amount.setText("Rs. " + ordersListDetails.getTotal_discounted());
        viewHolder.delivery_slot_time.setText(ordersListDetails.getDelivery_slot());
        viewHolder.delivery_charges_amount.setText("Rs. " + ordersListDetails.getDelivery_charges());

        viewHolder.name.setText("Name " + ordersListDetails.getName());
        viewHolder.address.setText(ordersListDetails.getHouse_no() + " , " + ordersListDetails.getLocality());
        viewHolder.city.setText(ordersListDetails.getCity());
        viewHolder.mobile.setText(ordersListDetails.getMobile());

        viewHolder.change_status_button.setText(ordersListDetails.getStatus_next());

        viewHolder.cancle_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ordersListFragment.changeStatus(ordersDataList.get(position).getOrder_id(), true);
            }
        });

        switch (ordersDataList.get(position).getStatus_id()) {

            case 0:
                viewHolder.change_status_button.setText("Confirmed");
                viewHolder.change_status_button.setVisibility(View.VISIBLE);
                viewHolder.change_status_button.setEnabled(true);
                viewHolder.cancle_button.setVisibility(View.VISIBLE);
                viewHolder.cancle_button.setEnabled(true);
                break;
            case 1:
                viewHolder.change_status_button.setText("Dispatched");
                viewHolder.change_status_button.setVisibility(View.VISIBLE);
                viewHolder.change_status_button.setEnabled(true);

                viewHolder.cancle_button.setVisibility(View.VISIBLE);
                viewHolder.cancle_button.setEnabled(true);

                break;
            case 2:
                viewHolder.change_status_button.setText("Delivered");
                viewHolder.change_status_button.setVisibility(View.VISIBLE);
                viewHolder.change_status_button.setEnabled(true);

                viewHolder.cancle_button.setVisibility(View.VISIBLE);
                viewHolder.cancle_button.setEnabled(true);
                break;
            case 3:

                viewHolder.change_status_button.setVisibility(View.GONE);
                viewHolder.change_status_button.setEnabled(false);
                viewHolder.cancle_button.setVisibility(View.GONE);
                viewHolder.cancle_button.setEnabled(false);
                break;
            case -1:
                viewHolder.change_status_button.setVisibility(View.GONE);
                viewHolder.change_status_button.setEnabled(false);
                viewHolder.cancle_button.setVisibility(View.GONE);
                viewHolder.cancle_button.setEnabled(false);
                break;


        }

        viewHolder.change_status_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ordersListFragment.changeStatus(ordersDataList.get(position).getOrder_id(), false);
            }
        });

    }

    public void setData(List<OrdersListDetails> ordersListDetails) {
        this.ordersDataList = ordersListDetails;

    }

    @Override
    public int getItemCount() {
        return ordersDataList.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.layout_relative)
        RelativeLayout relativeLayout;
        @BindView(R.id.order_status)
        TextView order_status;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.delivery_slot_time)
        TextView delivery_slot_time;
        @BindView(R.id.subtotal_amount)
        TextView subtotal_amount;
        @BindView(R.id.delivery_charges_amount)
        TextView delivery_charges_amount;
        @BindView(R.id.total_bill)
        TextView total_amount;
        @BindView(R.id.order_status_icon)
        ImageView order_status_icon;
        @BindView(R.id.order_status_time)
        TextView order_status_time;
        @BindView(R.id.order_id)
        TextView order_id;

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.address)
        TextView address;

        @BindView(R.id.mobile)
        TextView mobile;

        @BindView(R.id.city)
        TextView city;

        @BindView(R.id.cancle_button)
        Button cancle_button;

        @BindView(R.id.change_status_button)
        Button change_status_button;

        public ViewHolder1(View itemView) {

            super(itemView);

            ButterKnife.bind(this, itemView);


        }
    }
}
