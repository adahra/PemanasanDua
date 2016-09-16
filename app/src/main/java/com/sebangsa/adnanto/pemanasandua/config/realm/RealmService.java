package com.sebangsa.adnanto.pemanasandua.config.realm;

import android.content.Context;

import com.sebangsa.adnanto.pemanasandua.model.Friend;

import java.util.List;

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

    public void saveUser(final Friend friend) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realmm) {
                realmm.copyToRealmOrUpdate(friend);
            }
        });
    }

    public void updateUser(final Friend friend) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realmm) {
                if (friend.getAction().isFollow()) {
                    friend.getAction().setFollow(false);
                } else {
                    friend.getAction().setFollow(true);
                }

                realmm.copyToRealmOrUpdate(friend);
            }
        });
    }

    public RealmResults<Friend> getUsers() {
        return realm.where(Friend.class).findAll();
    }

    public void saveUser(final List<Friend> dataFriend) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm rRealm) {
                rRealm.copyToRealmOrUpdate(dataFriend);
            }
        });
    }
}
