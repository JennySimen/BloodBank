package com.example.cressence.bloodbank;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.CirclePageIndicator;
import com.synnapps.carouselview.ImageListener;


public class BloodBankActivity extends AppCompatActivity {

    private Button mRegisterBtn;
    private Button mLoginBtn;

    private CarouselView carouselView;

    //array of images
    Integer[] images = {R.mipmap.blood1, R.mipmap.blood2, R.mipmap.doc1, R.mipmap.blood3};
    String[] name = {"img1", "img2", "img3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank);

    //define register btn
        mRegisterBtn = (Button) findViewById(R.id.btn1);
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(BloodBankActivity.this, RegisterActivity.class);
                startActivity(intent1);
            }
        });
        //defining the carousel
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(imageListener);

        //define login btn
        mLoginBtn = (Button) findViewById(R.id.btn2);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(BloodBankActivity.this, LoginActivity.class);
                startActivity(intent2);
            }
        });
    }
    //getting the image listener
        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(images[position]);
            }
        };


    }
