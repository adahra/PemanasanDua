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
import com.sebangsa.adnanto.pemanasandua.config.realm.RealmService;
import com.sebangsa.adnanto.pemanasandua.config.retrofit.RetrofitInterface;
import com.sebangsa.adnanto.pemanasandua.config.retrofit.RetrofitService;
import com.sebangsa.adnanto.pemanasandua.model.Data;
import com.sebangsa.adnanto.pemanasandua.model.Friend;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String STRING_TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private List<Friend> dataUser;
    private RealmService realmService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dataUser = new ArrayList<>();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.rv_tampil_data);
        recyclerView.setLayoutManager(layoutManager);

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

        realmService = RealmService.getRealmService(this);
        // EventBus.getDefault().register(this);

        if (dataUser.size() > 0) {
            recyclerAdapter = new RecyclerAdapter(dataUser, MainActivity.this);
            recyclerView.setAdapter(recyclerAdapter);
        } else {
            RealmResults<Friend> friendResults = realmService.getUsers();
            if (friendResults.size() > 0) {
                dataUser = new ArrayList<>();
                for (Friend realmFriend : friendResults) {
                    dataUser.add(realmFriend);
                }

                recyclerAdapter = new RecyclerAdapter(dataUser, MainActivity.this);
                recyclerView.setAdapter(recyclerAdapter);
            } else {
                RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
                Call<Data> call = retrofitInterface.getFollowing();
                call.enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        if (response.isSuccessful()) {
                            dataUser = response.body().getFriends();
                            realmService.saveUser(dataUser);
                            recyclerAdapter = new RecyclerAdapter(dataUser, MainActivity.this);
                            recyclerView.setAdapter(recyclerAdapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {

                    }
                });
            }
        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
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
    protected void onDestroy() {
        super.onDestroy();
        //EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //EventBus.getDefault().register(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}
