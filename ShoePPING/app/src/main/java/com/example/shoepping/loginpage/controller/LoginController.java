package com.example.shoepping.loginpage.controller;

import com.example.shoepping.loginpage.model.User;
import com.example.shoepping.loginpage.view.ILoginView;

public class LoginController implements ILoginController{

    ILoginView loginView;
    public LoginController(ILoginView loginView) {
        this.loginView = loginView;
    }
    @Override
    public void onLogin(String username, String pass) {
        User user = new User(username,pass);
        int loginCode = user.isValid();
        if(loginCode == 0)
        {
            loginView.onLoginError("Please enter an Username");
        }else  if (loginCode == 1){
            loginView.onLoginError("Please enter a Password");
        } else  if(loginCode == 2){
            loginView.onLoginError("Please enter a Password greater than 6 characters");
        }
        else {
            loginView.onLoginSuccess("Login successful!");
        }
    }


}
