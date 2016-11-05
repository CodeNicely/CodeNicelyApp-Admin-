package com.example.iket.groceryappadmin.orders.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.example.iket.groceryappadmin.R;
import com.example.iket.groceryappadmin.helper.SharedPrefs;
import com.example.iket.groceryappadmin.orders.model.MockData;
import com.example.iket.groceryappadmin.orders.model.RetrofitOrdersProvider;
import com.example.iket.groceryappadmin.orders.model.data.OrderDetails;
import com.example.iket.groceryappadmin.orders.presenter.OrdersPresenter;
import com.example.iket.groceryappadmin.orders.presenter.OrdersPresenterImpl;
import com.example.iket.groceryappadmin.products.presenter.ProductPresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OrdersFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OrdersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrdersFragment extends Fragment implements OrderView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    /* @BindView(R.id.tabLayout)
     TabLayout tabLayout;
 */
   private RecyclerView recyclerView;
   private ProgressBar progressBar;
    // TODO: Rename and change types of parameters
    private int mParam1;
    private String mParam2;
    private OrdersPresenter orderPresenter;
    private OrdersAdapter ordersAdapter;
    private LinearLayoutManager linearLayoutManager;
    private String token;
    private SharedPrefs sharedPrefs;
    private OnFragmentInteractionListener mListener;

    public OrdersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrdersFragment newInstance(int param1) {
        Log.d("Res","sf");
        OrdersFragment fragment = new OrdersFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_orders, container, false);
        ButterKnife.bind(this, view);
        recyclerView=(RecyclerView)view.findViewById(R.id.order_recycler);
        progressBar=(ProgressBar)view.findViewById(R.id.order_progressbar);
        initialize();
        progressBar.setVisibility(View.INVISIBLE);
        Log.d("Response",mParam1+"");
        orderPresenter.getOrders(token);
        return view;

    }

    void initialize() {
//        orderPresenter = new OrdersPresenterImpl(this, new RetrofitOrdersProvider());
        orderPresenter=new OrdersPresenterImpl(this,new MockData());
        ordersAdapter = new OrdersAdapter(getContext(), this);
        sharedPrefs = new SharedPrefs(getContext());
        token = sharedPrefs.getAccessToken();
        linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(ordersAdapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressbar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onDataReceived(List<OrderDetails> orderDatas) {
        ordersAdapter.setData(orderDatas);
        ordersAdapter.notifyDataSetChanged();
    }
    


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



}
