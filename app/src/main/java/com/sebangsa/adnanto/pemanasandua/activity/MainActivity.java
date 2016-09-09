package com.sebangsa.adnanto.pemanasandua.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.sebangsa.adnanto.pemanasandua.R;
import com.sebangsa.adnanto.pemanasandua.adapter.RecyclerAdapter;
import com.sebangsa.adnanto.pemanasandua.config.retrofit.RetrofitInterface;
import com.sebangsa.adnanto.pemanasandua.config.retrofit.RetrofitService;
import com.sebangsa.adnanto.pemanasandua.model.Data;
import com.sebangsa.adnanto.pemanasandua.model.Friend;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Friend> dataUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        layoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.rv_tampil_data);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (drawer != null) {
            drawer.setDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<Data> call = retrofitInterface.getFollowing();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                List<Friend> dataFriend;
                dataFriend = response.body().getFriends();

                /*
                for (int i = 0; i < dataFriend.size(); i++) {
                    dataFriend.get(i).setUsername(dataFriend.get(i).getUsername().trim());
                    dataFriend.get(i).setName(dataFriend.get(i).getName().trim());
                    dataFriend.get(i).setBio(dataFriend.get(i).getBio().trim());
                } */

                recyclerAdapter = new RecyclerAdapter(dataFriend, MainActivity.this);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_following:
                startActivity(new Intent(MainActivity.this, ProfilActivity.class));
                break;
            case R.id.nav_followers:
                startActivity(new Intent(MainActivity.this, ProfilActivity.class));
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }
}
