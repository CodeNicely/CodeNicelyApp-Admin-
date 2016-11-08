package com.codenicely.project.groceryappadmin.home;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.codenicely.project.groceryappadmin.R;
import com.codenicely.project.groceryappadmin.helper.SharedPrefs;
import com.codenicely.project.groceryappadmin.login.view.LogInFragment;
import com.codenicely.project.groceryappadmin.orders.view.CategoryOrder;
import com.codenicely.project.groceryappadmin.products.view.ProductFragment;

public class HomePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SharedPrefs sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sharedPrefs = new SharedPrefs(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (sharedPrefs.isLoggedIn()) {
            setFragment(new CategoryOrder(), "Orders");
            getSupportActionBar().hide();
        } else {
            addFragment(new LogInFragment(), "LogIn");
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            if (sharedPrefs.isLoggedIn()) {
                setFragment(new HomeFragment(), "Home");
            } else {
                setFragment(new LogInFragment(), "LogIn");
                Toast.makeText(HomePage.this, "LogIn First", Toast.LENGTH_SHORT).show();
            }

        } else if (id == R.id.nav_place_order) {
            if (sharedPrefs.isLoggedIn()) {

            } else {
                setFragment(new LogInFragment(), "LogIn");
                Toast.makeText(HomePage.this, "LogIn First", Toast.LENGTH_SHORT).show();
            }


        } else if (id == R.id.nav_orders) {
//            Intent in=new Intent(HomePage.this, Order_Categories.class);
//            startActivity(in);
            if (sharedPrefs.isLoggedIn()) {
                setFragment(new CategoryOrder(), "Orders");
                getSupportActionBar().hide();
            } else {
                setFragment(new LogInFragment(), "LogIn");
                Toast.makeText(HomePage.this, "LogIn First", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.nav_products) {
            if (sharedPrefs.isLoggedIn())
                setFragment(new ProductFragment(), "Products");
            else {
                setFragment(new LogInFragment(), "LogIn");
                Toast.makeText(HomePage.this, "LogIn First", Toast.LENGTH_SHORT).show();
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setFragment(Fragment fragment, String title) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.home_layout, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);
        }
    }

    public void addFragment(Fragment fragment, String title) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.home_layout, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);
        }
    }

    public void setHome() {
        addFragment(new HomeFragment(), "Home");
    }
}
