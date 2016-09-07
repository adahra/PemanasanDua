package com.sebangsa.adnanto.pemanasandua.model;

import io.realm.RealmObject;

/**
 * Created by adnanto on 8/31/16.
 */
public class RoomList extends RealmObject {
    private int postCount;
    private String roomName;
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
