package com.ldcc.mynetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    private OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okHttpClient = new OkHttpClient();
    }

    public void getSync(View view) {
        Request request = new Request.Builder().url("https://www.httpbin.org/get?a=1&b=2").build();
    }

    public void getAsync(View view) {
    }

    public void postSync(View view) {
    }

    public void postAsync(View view) {
    }
}