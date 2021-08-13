package com.example.market.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {

    public static String toString(Object object) {
        return getGsonInstance().toJson(object);
    }

    public static Gson getGsonInstance() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();
    }

}
