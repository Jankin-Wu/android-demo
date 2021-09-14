package com.ldcc.mypopupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint({"InflateParams", "UseCompatLoadingForDrawables"})
    public void onClick(View view) {
        // 实例化 popup_view
        View popupView = getLayoutInflater().inflate(R.layout.popup_view, null);

        Button btn1 = popupView.findViewById(R.id.btn1);
        Button btn2 = popupView.findViewById(R.id.btn2);
        // ViewGroup.LayoutParams.WRAP_CONTENT 相当于 xml 中 wrap_content
        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.android_1));
//        设置 popupWindow 固定尺寸
//        popupWindow.showAsDropDown(view, 100, 100);
//        动态设置 popupWindow 尺寸
//        popupWindow.showAsDropDown(view, view.getWidth(), -view.getHeight());
        popupWindow.showAsDropDown(view);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn1.setOnClickListener(view2 -> {Log.e(TAG, "onClick: 你是住在上海吗");
        popupWindow.dismiss();});

        btn2.setOnClickListener(view1 -> Log.e(TAG, "onClick: 你是住在北京吗"));

    }
}