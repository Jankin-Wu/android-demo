package com.ldcc.myviewpager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder> {

    private List<String> titles = new ArrayList<>();

    public ViewPagerAdapter() {
        titles.add("1");
        titles.add("2");
        titles.add("3");
        titles.add("4");
        titles.add("5");
        titles.add("6");
        titles.add("7");
        titles.add("8");
        titles.add("9");
        titles.add("10");
    }


    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPagerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pager, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        holder.mTextView.setText(titles.get(position));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewPagerViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;
        RelativeLayout mContainer;
        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);
            mContainer = itemView.findViewById(R.id.container);
            mTextView = itemView.findViewById(R.id.tv);
        }
    }
}
