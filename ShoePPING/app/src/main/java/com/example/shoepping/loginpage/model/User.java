package com.example.shoepping.loginpage.model;

import android.text.TextUtils;

public class User implements IUser{

    private final String username; //check if it will be final always
    private final String pass;     //check if it will be final always

    public User(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public String getPassword() {
        return pass;
    }
    @Override
    public int isValid() {
        // 0. Check for Username Empty
        // 1. Check for Password Empty
        // 2. Check for Password > 6
        if(TextUtils.isEmpty(getUsername()))
            return  0;
        else if(TextUtils.isEmpty(getPassword()))
            return 1;
        else if(getPassword().length()<=6)
            return 2;
        else
            return -1;
    }

}
