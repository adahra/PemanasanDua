package com.sebangsa.adnanto.pemanasandua.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by adnanto on 8/31/16.
 */
public class Statistic extends RealmObject {
    @Expose
    @SerializedName(value = "following")
    private int following;
    @Expose
    @SerializedName(value = "followers")
    private int followers;
    @Expose
    @SerializedName(value = "user")
    private int user;

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
