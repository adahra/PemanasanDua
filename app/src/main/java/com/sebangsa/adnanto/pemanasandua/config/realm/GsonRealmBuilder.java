package com.sebangsa.adnanto.pemanasandua.config.realm;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.realm.RealmObject;

/**
 * Created by adnanto on 9/7/16.
 */
public class GsonRealmBuilder {

    public GsonRealmBuilder() {

    }

    public static GsonBuilder getGsonBuilder() {
        return new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getDeclaredClass().equals(RealmObject.class);
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        });
    }

    public static Gson getGson() {
        return getGsonBuilder().create();
    }
}
