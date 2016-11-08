package com.codenicely.project.groceryappadmin.login.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codenicely.project.groceryappadmin.R;
import com.codenicely.project.groceryappadmin.helper.MyApplication;
import com.codenicely.project.groceryappadmin.helper.SharedPrefs;
import com.codenicely.project.groceryappadmin.home.HomePage;
import com.codenicely.project.groceryappadmin.login.models.RetrofitLoginScreenProvider;
import com.codenicely.project.groceryappadmin.login.presenter.LoginScreenPresenter;
import com.codenicely.project.groceryappadmin.login.presenter.LoginScreenPresenterImpl;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LogInFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LogInFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogInFragment extends Fragment implements LoginScreenView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String password1;
    Button login_button;
    EditText mobile;
    String mobile1;
    EditText password;
    private SharedPrefs sharedPrefs;
    private ProgressBar progressbar;
    private LoginScreenPresenter loginScreenPresenter;

    private OnFragmentInteractionListener mListener;

    public LogInFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LogInFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LogInFragment newInstance(String param1, String param2) {
        LogInFragment fragment = new LogInFragment();
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
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);
        sharedPrefs = new SharedPrefs(getContext());
        if (sharedPrefs.isLoggedIn()) {
            ((HomePage) getActivity()).setHome();
        }
        progressbar = (ProgressBar) view.findViewById(R.id.progressBar);
        login_button = (Button) view.findViewById(R.id.button);
        mobile = (EditText) view.findViewById(R.id.login_mobile);
        password = (EditText) view.findViewById(R.id.login_password);
        loginScreenPresenter = new LoginScreenPresenterImpl(this, new RetrofitLoginScreenProvider());
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobile1 = mobile.getText().toString();
                password1 = password.getText().toString();
                if (mobile1.equals("") || mobile1.equals(null)) {
                    mobile.setError("Please fill mobile");
                    mobile.requestFocus();
                } else if (password1.equals("") || password1.equals("")) {
                    password.setError("Please fill password id ");
                    password.requestFocus();
                } else if (mobile1.length() != 10) {
                    mobile.setError("Invalid Mobile No.");
                    mobile.requestFocus();
                }

                if (((mobile1.equals("") || mobile1.equals(null)) || mobile1.length() != 10) ||
                        (password1.equals("") || password1.equals(null))
                        ) {


                } else {
                    loginScreenPresenter.requestLogin(mobile1, password1, MyApplication.getFcm());
                }

            }
        });

        return view;
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
    public void showLoading(boolean show) {
        if (show) {
            progressbar.setVisibility(View.VISIBLE);
        } else {
            progressbar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginVerified(String access_token) {
        sharedPrefs = new SharedPrefs(getContext());
        sharedPrefs.setLogin(true);
        sharedPrefs.setAccessToken(access_token);
        ((HomePage) getActivity()).setHome();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
