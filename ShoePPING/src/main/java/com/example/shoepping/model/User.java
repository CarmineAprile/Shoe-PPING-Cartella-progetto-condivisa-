package com.example.shoepping.model;

import static com.example.shoepping.ValidationEmail.valEmail;

public class User implements IUser {

    private final String username;
    private final String pass;
    private final String repass;
    private final String email;

    public User(String username, String pass, String repass, String email) {
        this.username = username;
        this.pass = pass;
        this.repass = repass;
        this.email = email;
    }

    public User(String username, String pass) {
        this.username = username;
        this.pass = pass;
        this.repass = "";
        this.email = "";
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
    public String getEmail() {
        return email;
    }

    @Override
    public int isValid() {
        // 0. Check for Username Empty
        // 1. Check for Password Empty
        // 2. Check for Password > 6
        // 3. Check for Repassword Empty
        // 4. Check for corrispondence of Password and Repassword
        // 5. Check for Email Empty
        // 6. Check for Email sintax

        if (username.isEmpty())
            return 0;
        else if (pass.isEmpty())
            return 1;
        else if (pass.length() <= 6)
            return 2;
        else if (repass.isEmpty())
            return 3;
        else if(!pass.equals(repass)){
            return 4;
        }
        else if (email.isEmpty())
            return 5;
        else if (!valEmail(email))
            return 6;
        else
            return -1;
    }
}
