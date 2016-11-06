package com.example.iket.groceryappadmin.products.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.example.iket.groceryappadmin.products.model.MockDataProducts;
import com.example.iket.groceryappadmin.products.model.data.ProductDetails;
import com.example.iket.groceryappadmin.products.presenter.ProductPresenter;
import com.example.iket.groceryappadmin.products.presenter.ProductPresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProductFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductFragment extends Fragment implements ProductView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ProductPresenter productPresenter;
    private ProductAdapter productAdapter;
    private LinearLayoutManager linearLayoutManager;
    private String token;
    private SharedPrefs sharedPrefs;
    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    public ProductFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductFragment newInstance(String param1, String param2) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public static void changePrice(int product_id,String name,String quantity,String cost)
    {

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

        View view = inflater.inflate(R.layout.fragment_product, container, false);
        ButterKnife.bind(this,view);
         recyclerView= (RecyclerView) view.findViewById(R.id.product_recycler);
        progressBar=(ProgressBar)view.findViewById(R.id.product_progressbar);
        initialize();
        token=sharedPrefs.getAccessToken();
        if(token==null)
            token="test";
        Log.d("respo","1");
        productPresenter.getProduct(token);
        Log.d("Respo","2");

        return view;

    }

   public void initialize() {
//        productPresenter = new ProductPresenterImpl(this, new RetrofitProductProvider());
        productPresenter=new ProductPresenterImpl(this,new MockDataProducts());
        productAdapter = new ProductAdapter(getContext(), this);
        sharedPrefs = new SharedPrefs(getContext());

        linearLayoutManager=new LinearLayoutManager(this.getContext());
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
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
        } else {
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void onDataReceived(List<ProductDetails> productDatas) {
        productAdapter.setData(productDatas);
        productAdapter.notifyDataSetChanged();
    }





    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
