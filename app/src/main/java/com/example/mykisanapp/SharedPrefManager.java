package com.example.mykisanapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mykisanapp.Model.Data;

public class SharedPrefManager {

    private static final String PREF_NAME = "session_pref";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    Context context;
    public SharedPrefManager(Context context){
        this.context=context;
    }

    public void saveUser(Data user){
        sharedPreferences=context.getSharedPreferences(PREF_NAME,context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.putInt("userId", user.getUserId());
        editor.putString("name",user.getName());
        editor.putString("village", user.getVillage());
        editor.putString("phone",user.getPhone());
        editor.putBoolean("logged",true);
        editor.apply();
    }

    public boolean isLoggedIn(){
        sharedPreferences=context.getSharedPreferences(PREF_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("logged",false);
    }

    public Data getUser(){
        sharedPreferences=context.getSharedPreferences(PREF_NAME,context.MODE_PRIVATE);
        return  new Data(sharedPreferences.getInt("userId",0),
                         sharedPreferences.getString("name",null),
                sharedPreferences.getString("village",null),
                sharedPreferences.getString("phone",null)
        );

    }

    public void logout(){
        sharedPreferences=context.getSharedPreferences(PREF_NAME,context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
