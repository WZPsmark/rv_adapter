package com.sk.rvadapter.callback;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by smark on 2020/4/13.
 * 邮箱：smarkwzp@163.com
 * recycleView 点击事件回调
 */
public interface OnItemClickListener<T> {

    void onItemClick(ViewGroup var1, View var2, T var3, int var4);

    boolean onItemLongClick(ViewGroup var1, View var2, T var3, int var4);
}
