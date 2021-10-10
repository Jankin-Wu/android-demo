package com.ldcc.myfragmentmanagers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ldcc.myfragmentmanagers.service.IFragmentCallBack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.btn1);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                // 将信息传递给 BlankFragment1
                Bundle bundle = new Bundle();
                bundle.putString("message", "我喜欢学 Android");
                BlankFragment1 bf = new BlankFragment1();
                bf.setArguments(bundle);
                bf.setFragmentCallBack(new IFragmentCallBack() {
                    @Override
                    public void sendMsgToActivity(String msg) {
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public String getMsgFromActivity(String msg) {
                        return "Hello, I am from activity.";
                    }
                });
                replaceFragment(bf);
                break;
            case R.id.btn2:
                replaceFragment(new ItemFragment());
                break;
        }
    }

    /**
     * 动态切换 fragment
     * @param fragment
     */
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 创建 replace 事件
        transaction.replace(R.id.frameLayout, fragment);
        // 将 fragment 入栈
        transaction.addToBackStack(null);
        // 事件提交
        transaction.commit();
    }
}