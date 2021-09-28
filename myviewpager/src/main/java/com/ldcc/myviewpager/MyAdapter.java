package com.ldcc.myviewpager;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MyAdapter extends PagerAdapter {

    private List<View> mListView;

    public MyAdapter(List<View> mListView) {
        this.mListView = mListView;
    }

    /**
     *  1.将给定位置的view添加到ViewGroup(容器)中,创建并显示出来
     *  2.返回一个代表新增页面的Object(key),
     * @param container
     * @param position
     * @return
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mListView.get(position),0);
        return mListView.get(position);
    }

    /**
     * 获得 viewpager 中有多少个 view
     */
    @Override
    public int getCount() {
        return mListView.size();
    }

    /**
     * 判断instantiateItem(ViewGroup, int)函数所返回来的Key与一个页面视图是否是代表的同一个视图(即它俩是否
     * 是对应的，对应的表示同一个View),通常我们直接写 return view == object!
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    /**
     * 移除一个给定位置的页面。适配器有责任从容器中删除这个视图。
     * 这是为了确保在finishUpdate(viewGroup)返回时视图能够被移除。
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(mListView.get(position));
    }
}
