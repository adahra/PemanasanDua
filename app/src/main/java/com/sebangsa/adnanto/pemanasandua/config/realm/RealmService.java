package com.sebangsa.adnanto.pemanasandua.config.realm;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by adnanto on 9/7/16.
 */
public class RealmService {
    private Context context;
    private Realm realm;
    private RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(context)
            .name("Sebangsa")
            .schemaVersion(0)
            .build();

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Realm getRealm() {
        return realm;
    }

    public void setRealm(Realm realm) {
        this.realm = realm;
    }

    public RealmConfiguration getRealmConfiguration() {
        return realmConfiguration;
    }

    public void setRealmConfiguration(RealmConfiguration realmConfiguration) {
        this.realmConfiguration = realmConfiguration;
    }
}
