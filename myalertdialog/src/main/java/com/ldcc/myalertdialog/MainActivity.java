package com.ldcc.myalertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("InflateParams")
    public void dialogClick(View view) {
        // 对xml布局文件进行实例化
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_view, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher)
                .setTitle("我是对话框")
                .setMessage("今天天气怎么样")
                .setView(dialogView)
                // 可以使用lambda表达式实现
                .setPositiveButton("确定", (dialogInterface, i) -> Log.e(TAG, "onClick: pressed positive button"))
                .setNegativeButton("取消", (dialogInterface, i) -> Log.e(TAG, "onClick: pressed negative button"))
                // 不使用lambda表达式实现
                .setNeutralButton("中间", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e(TAG, "onClick: pressed neutral button");
                    }
                })
                .create()
                .show();
    }
}