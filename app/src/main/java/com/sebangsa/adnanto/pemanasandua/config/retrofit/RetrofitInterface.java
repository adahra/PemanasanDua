package com.sebangsa.adnanto.pemanasandua.config.retrofit;

import com.sebangsa.adnanto.pemanasandua.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by adnanto on 8/30/16.
 */
public interface RetrofitInterface {
    @GET("sdp-latihan/following.php")
    Call<Data> getFollowing();

    @GET("sdp-latihan/grouplist.php")
    Call<Data> getDataGroup();

    @GET("sdp-latihan/follower.php")
    Call<Data> getFollower();
}
