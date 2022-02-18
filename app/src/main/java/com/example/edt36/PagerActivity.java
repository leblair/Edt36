package com.example.edt36;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.List;

public class PagerActivity extends AppCompatActivity {
    ViewPager viewPager;
    List<String > images;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        viewPager = findViewById(R.id.viewPager);
        images = getIntent().getStringArrayListExtra("images");
        ImageAdapter imageAdapter = new ImageAdapter(getApplicationContext(),images);
        viewPager.setAdapter(imageAdapter);
    }
}