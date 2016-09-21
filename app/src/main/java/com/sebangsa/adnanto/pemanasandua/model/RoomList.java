package com.sebangsa.adnanto.pemanasandua.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by adnanto on 8/31/16.
 */
public class RoomList extends RealmObject {
    @Expose
    @SerializedName(value = "post_count")
    private int postCount;
    @Expose
    @SerializedName(value = "room_name")
    private String roomName;
    @Expose
    @SerializedName(value = "room_id")
    private int roomId;

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
