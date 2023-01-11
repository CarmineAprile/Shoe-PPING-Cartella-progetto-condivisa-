package com.example.shoepping.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoepping.loginpage.controller.ILoginController;
import com.example.shoepping.loginpage.controller.LoginController;
import com.example.shoepping.R;
import com.example.shoepping.registrationpage.RegistrationActivity;
import com.example.shoepping.loginpage.view.ILoginView;
import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //The next two lines hide title on top of the screen
        //The next three lines before setContentView
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);

        TextView username = findViewById(R.id.username);
        TextView pass = findViewById(R.id.password);

        MaterialButton loginbtn = findViewById(R.id.loginbtn);
        TextView forgotpassword = findViewById(R.id.forgotpassword);
        TextView signupstr = findViewById(R.id.signupstr);
        ImageButton logingoogle = findViewById(R.id.loginGoogle);

        ILoginController loginPresenter = new LoginController(this);

        loginbtn.setOnClickListener(view ->
                loginPresenter.onLogin(username.getText().toString().trim(), pass.getText().toString().trim()));

        signupstr.setOnClickListener(view -> {
            Intent intent = new Intent (LoginActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });

        logingoogle.setOnClickListener(view -> Toast.makeText(this,"Work in progress...",Toast.LENGTH_SHORT).show());

        forgotpassword.setOnClickListener(view -> Toast.makeText(this,"TODO",Toast.LENGTH_SHORT).show());
    }

    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}