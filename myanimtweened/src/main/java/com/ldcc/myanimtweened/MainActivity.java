package com.ldcc.myanimtweened;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.iv);

        imageView.setOnClickListener(view -> {
            // 透明渐变
//            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
            // 旋转渐变
//            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
            // 缩放渐变
//            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);
            // 位移渐变
            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate);

            imageView.startAnimation(animation);
        });
    }
}