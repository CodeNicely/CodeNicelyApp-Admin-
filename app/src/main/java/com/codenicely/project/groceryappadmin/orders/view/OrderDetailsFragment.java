package com.codenicely.project.groceryappadmin.orders.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codenicely.project.groceryappadmin.R;
import com.codenicely.project.groceryappadmin.helper.SharedPrefs;
import com.codenicely.project.groceryappadmin.home.HomePage;
import com.codenicely.project.groceryappadmin.orders.model.RetrofitOrderDetailsProvider;
import com.codenicely.project.groceryappadmin.orders.model.data.OrdersDetails;
import com.codenicely.project.groceryappadmin.orders.presenter.OrderDetailsPresenter;
import com.codenicely.project.groceryappadmin.orders.presenter.OrderDetailsPresenterImp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OrderDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OrderDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderDetailsFragment extends Fragment implements OrderDetails {
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private SharedPrefs sharedPrefs;
    private OrderDetailsAdapter orderDetailsAdapter;
    private OrderDetailsPresenter orderDetailsPresenter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String order_id;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public OrderDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderDetailsFragment newInstance(String param1, String param2) {
        OrderDetailsFragment fragment = new OrderDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        order_id = getArguments().getString("order_id");
        View view = inflater.inflate(R.layout.fragment_order_details, container, false);

        ButterKnife.bind(this, view);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        initialise();

        if (getActivity() instanceof HomePage) {

            ((HomePage) getContext()).getSupportActionBar().hide();

        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(orderDetailsAdapter);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void initialise() {
        orderDetailsAdapter = new OrderDetailsAdapter(getContext(), this);
        sharedPrefs = new SharedPrefs(getContext());
        orderDetailsPresenter = new OrderDetailsPresenterImp(this, new RetrofitOrderDetailsProvider());
        orderDetailsPresenter.getOrderDataDetails(sharedPrefs.getAccessToken(), order_id);
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
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void setOrdersList(List<OrdersDetails> ordersListDataDetails) {
        orderDetailsAdapter.setData(ordersListDataDetails);
        orderDetailsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();


    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
