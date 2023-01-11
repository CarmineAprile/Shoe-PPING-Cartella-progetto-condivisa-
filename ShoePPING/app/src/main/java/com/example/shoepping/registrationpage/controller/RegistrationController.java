package com.example.shoepping.registrationpage.controller;

import com.example.shoepping.registrationpage.model.Account;
import com.example.shoepping.registrationpage.view.IRegistrationView;

public class RegistrationController implements IRegistrationController{

    IRegistrationView registrationView;
    public RegistrationController(IRegistrationView registrationView) {
        this.registrationView = registrationView;
    }
    @Override
    public void onRegistration(String username, String pass, String repass) {
        Account account = new Account(username,pass,repass);
        int registrationCode = account.isValid();

        if(registrationCode == 0)
        {
            registrationView.onRegistrationError("Please enter an Username");
        }else  if (registrationCode == 1){
            registrationView.onRegistrationError("Please enter a Password");
        } else  if(registrationCode == 2){
            registrationView.onRegistrationError("Please enter a Repassword");
        } else  if (registrationCode == 3){
            registrationView.onRegistrationError("Please enter a Password greater than 6 characters");
        } else  if (registrationCode == 4){
            registrationView.onRegistrationError("Error: Passwords mismatching");
        }
        else {
            registrationView.onRegistrationSuccess("Registration successful!");
        }
    }
}
