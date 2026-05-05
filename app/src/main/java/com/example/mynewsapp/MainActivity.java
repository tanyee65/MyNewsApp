package com.example.mynewsapp;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Point;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private TopicsFragment topicsFragment;
    private NewsFragment newsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        FrameLayout topicsFrame = findViewById(R.id.topics_frame);
        FrameLayout newsFrame = findViewById(R.id.news_frame);
        if (isLandscape){
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            newsFrame.setVisibility(View.VISIBLE);
            ConstraintLayout.MarginLayoutParams layoutParams = (ConstraintLayout.MarginLayoutParams) topicsFrame.getLayoutParams();
            layoutParams.width = size.x >> 1;
            topicsFrame.setLayoutParams(layoutParams);
            if (newsFragment == null) newsFragment = new NewsFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.news_frame, newsFragment);
            fragmentTransaction.commit();
        }
        if(topicsFragment == null) topicsFragment = new TopicsFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.topics_frame, topicsFragment);
        fragmentTransaction.commit();
    }
}