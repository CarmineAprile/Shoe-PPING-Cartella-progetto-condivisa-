package com.example.shoepping.registrationpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoepping.loginpage.LoginActivity;
import com.example.shoepping.R;
import com.example.shoepping.registrationpage.controller.IRegistrationController;
import com.example.shoepping.registrationpage.controller.RegistrationController;
import com.example.shoepping.registrationpage.view.IRegistrationView;
import com.google.android.material.button.MaterialButton;

public class RegistrationActivity extends AppCompatActivity implements IRegistrationView {

    TextView username;
    TextView pass;
    TextView repass;
    MaterialButton createbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //The next two lines hide title on top of the screen
        //The next three lines before setContentView
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_registration);

        username = (TextView) findViewById(R.id.username);
        pass = (TextView) findViewById(R.id.password);
        repass = (TextView) findViewById(R.id.repassword);
        createbtn = (MaterialButton) findViewById(R.id.createbtn);

        IRegistrationController registrationPresenter = new RegistrationController(this);

        createbtn.setOnClickListener(view ->
                registrationPresenter.onRegistration(username.getText().toString().trim(), pass.getText().toString().trim(), repass.getText().toString().trim()));

    }

    @Override
    public void onRegistrationSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        Intent i = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(i);
    }

    @Override
    public void onRegistrationError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}