package com.example.shoepping.registrationpage.model;

import android.text.TextUtils;

public class Account implements IAccount{

    private final String username;
    private final String password;
    private final String repassword;

    public Account(String username, String password, String repassword) {
        this.username = username;
        this.password = password;
        this.repassword = repassword;
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getRepassword() {
        return repassword;
    }

    @Override
    public int isValid() {
        // 0. Check for Username Empty
        // 1. Check for Password Empty
        // 2. Check for Repassword Empty
        // 3. Check for Password > 6
        // 4. Check for Password = Repassword
        if(TextUtils.isEmpty(getUsername()))
            return  0;
        else if(TextUtils.isEmpty(getPassword()))
            return 1;
        else if(TextUtils.isEmpty(getRepassword()))
            return 2;
        else if(getPassword().length()<=6)
            return 3;
        else if(!getPassword().equals(getRepassword()))
            return 4;
        else
            return -1;
    }
}
