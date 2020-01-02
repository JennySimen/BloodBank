package com.example.cressence.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



    public class SplashActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.splash);
            startActivity(new Intent(SplashActivity.this, BloodBankActivity.class));

            // close splash activity
            finish();
        }
    }

