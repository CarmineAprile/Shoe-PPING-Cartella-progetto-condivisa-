package com.example.shoepping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.shoepping.loginpage.LoginActivity;

public class MainActivity extends AppCompatActivity {

    //used for delay
    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //The next two lines hide title on top of the screen
        //The next three lines before setContentView
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //getSupportActionBar().hide(); //This line hides the action bar

        setContentView(R.layout.activity_main);

        //connect MainActivity with HomeActivity, with a delay of 2sec
        h.postDelayed(() -> {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        }, 2000);

    }
}