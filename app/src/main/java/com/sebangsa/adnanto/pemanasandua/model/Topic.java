package com.sebangsa.adnanto.pemanasandua.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by adnanto on 8/31/16.
 */
public class Topic extends RealmObject {
    @Expose
    @SerializedName(value = "id")
    private int id;
    @Expose
    @SerializedName(value = "label")
    private String label;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
