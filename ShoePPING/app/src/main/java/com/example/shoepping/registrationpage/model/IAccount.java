package com.example.shoepping.registrationpage.model;

public interface IAccount {

    String getUsername();
    String getPassword();
    String getRepassword();
    int isValid();

}
