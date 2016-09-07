package com.sebangsa.adnanto.pemanasandua.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by adnanto on 8/31/16.
 */
public class Data extends RealmObject {
    @Expose
    @SerializedName(value = "status")
    private int status;
    @Expose
    @SerializedName(value = "timestamp")
    private int timestamp;
    @Expose
    @SerializedName(value = "friends")
    private RealmList<Friend> friends;
    @Expose
    @SerializedName(value = "status_lang")
    private String statusLang;
    @Expose
    @SerializedName("groups")
    private RealmList<Group> groups;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public RealmList<Friend> getFriends() {
        return friends;
    }

    public void setFriends(RealmList<Friend> friends) {
        this.friends = friends;
    }

    public String getStatusLang() {
        return statusLang;
    }

    public void setStatusLang(String statusLang) {
        this.statusLang = statusLang;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(RealmList<Group> groups) {
        this.groups = groups;
    }
}
