package com.codenicely.project.groceryappadmin.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.codenicely.project.groceryappadmin.R;
import com.codenicely.project.groceryappadmin.helper.SharedPrefs;
import com.codenicely.project.groceryappadmin.home.HomeActivity;
import com.codenicely.project.groceryappadmin.home.HomePage;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {

    private SharedPrefs sharedPrefs;
    @BindView(R.id.codeNicelyLogo)
    ImageView code_nicely_logo;

    @BindView(R.id.vegword_logo)
    ImageView veg_word_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        sharedPrefs = new SharedPrefs(this);
        Glide.with(this).load(R.drawable.code_nicely_logo_small_colored).into(code_nicely_logo);
        Glide.with(this).load(R.drawable.veg_world_logo).into(veg_word_logo);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (sharedPrefs.isLoggedIn()) {
                    Intent intent = new Intent(SplashScreen.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashScreen.this, HomePage.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, 1000);


    }
}
