package com.ldcc.mypopupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("InflateParams")
    public void onClick(View view) {
        // 实例化 popup_view
        View popupView = getLayoutInflater().inflate(R.layout.popup_view, null);
        // ViewGroup.LayoutParams.WRAP_CONTENT 相当于 xml 中 wrap_content
        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        popupWindow.showAsDropDown(view);
//        popupWindow.showAsDropDown(view, 100, 100);
        popupWindow.showAsDropDown(view, view.getWidth(), -view.getHeight());
    }
}