package com.example.iket.groceryappadmin.login.view;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.example.iket.groceryappadmin.R;
import com.example.iket.groceryappadmin.helper.SharedPrefs;
import com.example.iket.groceryappadmin.login.models.RetrofitLoginScreenProvider;
import com.example.iket.groceryappadmin.login.presenter.LoginScreenPresenter;
import com.example.iket.groceryappadmin.login.presenter.LoginScreenPresenterImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.ButterKnife;

/**
 * Created by aman on 15/10/16.
 */
public class LoginScreenActivity extends Activity implements LoginScreenView {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    String email1;
    String name1;
    EditText name;
    Button login_button;
    EditText mobile;
    String mobile1;
    EditText email;
    private SharedPrefs sharedPrefs;
    private ProgressBar progressbar;
    private RetrofitLoginScreenProvider retrofitLoginScreenProvider;
    private LoginScreenPresenter loginScreenPresenter;

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);
        Log.d("Response", "1");
        sharedPrefs = new SharedPrefs(this);
        progressbar = (ProgressBar) findViewById(R.id.progressBar);
        Log.d("Response", "2");

        login_button = (Button) findViewById(R.id.button);
        name = (EditText) findViewById(R.id.editText);
        mobile = (EditText) findViewById(R.id.editText2);
        Log.d("Response", "3");
        email = (EditText) findViewById(R.id.editText3);

        ButterKnife.bind(this);
        Log.d("Response", "4");

        loginScreenPresenter = new LoginScreenPresenterImpl(this, new RetrofitLoginScreenProvider());

        Log.d("Response", "5");
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name1 = name.getText().toString();
                mobile1 = mobile.getText().toString();
                email1 = email.getText().toString();
                Log.d("Response", "b1");
                if (name1.equals("") || name1.equals(null)) {
                    name.setError("Please fill name");
                    name.requestFocus();
                } else if (mobile1.equals("") || mobile1.equals(null)) {
                    mobile.setError("Please fill mobile");
                    mobile.requestFocus();

                } else if (email1.equals("") || email1.equals("")) {
                    email.setError("Please fill email id ");
                    email.requestFocus();
                } else if (mobile1.length() != 10) {
                    mobile.setError("Invalid Mobile No.");
                    mobile.requestFocus();
                } else if (!validate(email1)) {
                    email.setError("Invalid Email Address");
                    email.requestFocus();


                }

                if ((name1.equals("") || name1.equals(null)) ||
                        ((mobile1.equals("") || mobile1.equals(null)) || mobile1.length() != 10) ||
                        (email1.equals("") || email1.equals("")
                                || !validate(email1))

                        )

                {


                } else {
                    loginScreenPresenter.requestLogin(name1, mobile1, email1);
                }


                Log.d("Response", "b2");
            }
        });
        Log.d("Response", "6");


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

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginVerified() {
        sharedPrefs = new SharedPrefs(this);
        sharedPrefs.setLogin(true);
//        Intent in = new Intent(LoginScreenActivity.this, OtpViewImpl.class);
//        in.putExtra("mobile", mobile1);
//        startActivity(in);
        finish();

    }

    @Override
    public void onBackPressed() {
        //    super.onBackPressed();
//        Intent intent = new Intent(LoginScreenActivity.this, WelcomeScreenActivity.class);
//        startActivity(intent);
        finish();

    }
}