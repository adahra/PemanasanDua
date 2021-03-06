package com.sebangsa.adnanto.pemanasandua.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by adnanto on 8/31/16.
 */
public class Avatar extends RealmObject {
    @Expose
    @SerializedName(value = "small")
    private String small;
    @Expose
    @SerializedName(value = "large")
    private String large;
    @Expose
    @SerializedName(value = "medium")
    private String medium;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
