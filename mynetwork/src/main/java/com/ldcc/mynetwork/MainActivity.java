package com.ldcc.mynetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "test";
    private OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okHttpClient = new OkHttpClient();
    }

    public void getSync(View view) {
        new Thread(){
            @Override
            public void run() {
                Request request = new Request.Builder().url("https://www.httpbin.org/get?a=1&b=2").build();
                // 请求的 Call 对象
                Call call = okHttpClient.newCall(request);
                try {
                    Response response = call.execute();
                    Log.e(TAG, "getSync: " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void getAsync(View view) {
    }

    public void postSync(View view) {
    }

    public void postAsync(View view) {
    }
}