package com.sebangsa.adnanto.pemanasandua.model.realm;

import io.realm.RealmObject;

/**
 * Created by adnanto on 9/13/16.
 */
public class RealmFriend extends RealmObject {
    private String username;
    private String bio;
    private String name;
    private String small;
    private boolean isFollow;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public boolean isFollow() {
        return isFollow;
    }

    public void setFollow(boolean follow) {
        isFollow = follow;
    }
}
