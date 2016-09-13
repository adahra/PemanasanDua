package com.sebangsa.adnanto.pemanasandua.config.realm;

import android.content.Context;

import com.sebangsa.adnanto.pemanasandua.model.realm.RealmFriend;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by adnanto on 9/13/16.
 */
public class RealmService {
    private static RealmService realmService;
    private static final String TAG = RealmService.class.getSimpleName();
    private Realm realm;

    public RealmService() {
        realm = Realm.getDefaultInstance();
    }

    public static RealmService getRealmService(Context context) {
        RealmConfiguration realmConfig = new RealmConfiguration
                .Builder(context)
                .deleteRealmIfMigrationNeeded()
                .name("PemanasanDua")
                .inMemory()
                .build();
        Realm.setDefaultConfiguration(realmConfig);

        if (realmService == null) {
            realmService = new RealmService();
        }

        return realmService;
    }

    public void saveUser(final RealmFriend friend) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realmm) {
                realmm.copyToRealmOrUpdate(friend);
            }
        });
    }

    public void updateUser(final RealmFriend friend) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realmm) {
                if (friend.isFollow()) {
                    friend.setFollow(false);
                } else {
                    friend.setFollow(true);
                }

                realmm.copyToRealmOrUpdate(friend);
            }
        });
    }

    public RealmResults<RealmFriend> getUsers() {
        return realm.where(RealmFriend.class).findAll();
    }
}
