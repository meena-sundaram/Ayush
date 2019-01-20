package com.meena.newapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity{
        private static int SPLASH_TIME_OUT = 4000;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent home = new Intent(Splash.this, MainActivity.class);
                    startActivity(home);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
    }