package com.ldcc.myfragmentmanagers;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ldcc.myfragmentmanagers.service.IFragmentCallBack;

public class BlankFragment1 extends Fragment {

    private static final String TAG = "tag";
    private View rootView;

    public BlankFragment1() {
        // Required empty public constructor
    }

    private IFragmentCallBack fragmentCallBack;
    public void setFragmentCallBack(IFragmentCallBack callBack) {
        fragmentCallBack = callBack;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 在创建时候接收 activity 信息
        Bundle bundle = this.getArguments();
        assert bundle != null;
        String string = bundle.getString("message");
        Log.d(TAG, "onCreate: " + string);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_blank1, container, false);
        }
        Button btn = rootView.findViewById(R.id.btn3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentCallBack.sendMsgToActivity("Hello, I'm from fragment.");
                String msg = fragmentCallBack.getMsgFromActivity("null");
                Toast.makeText(BlankFragment1.this.getContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}