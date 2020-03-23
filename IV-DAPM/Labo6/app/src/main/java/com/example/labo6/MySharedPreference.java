package com.example.labo6;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreference {

    SharedPreferences settings;
    SharedPreferences.Editor editor;

    public MySharedPreference (Context context) {
        settings = context.getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = settings.edit();
    }

    public void save (String text) {
        editor.putString("key_name", text); // Storing string
        editor.commit();
    }

    public String getValue() {
        return settings.getString("key_name", null); // getting String
    }

    public void clearSharedPreferences() {
        editor.clear();
        editor.commit(); // commit charges
    }

}
