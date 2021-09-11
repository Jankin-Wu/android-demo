package com.ldcc.myprogressbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.pb);
        progressBar2 = findViewById(R.id.pb2);
    }

    public void onClick(View view) {
        if (progressBar.getVisibility() == View.GONE){
            progressBar.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.GONE);
        }
    }

    /**
     * 每次点击进度条加10
     * @param view
     */
    public void load(View view) {
        int progress = progressBar2.getProgress();
        progress += 10;
        progressBar2.setProgress(progress);
    }
}