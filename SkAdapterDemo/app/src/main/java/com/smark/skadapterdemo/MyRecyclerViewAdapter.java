package com.smark.skadapterdemo;

import android.content.Context;


import com.sk.rvadapter.adapter.SkAdapter;
import com.sk.rvadapter.holder.SViewHolder;

import java.util.List;

/**
 * Created by smark on 2020/4/11.
 * 邮箱：smarkwzp@163.com
 */
public class MyRecyclerViewAdapter extends SkAdapter<String> {
    private static final String TAG = "MyRecyclerViewAdapter";

    public MyRecyclerViewAdapter(Context context, List<String> list, int layoutId) {
        super(context,list,layoutId);
    }

    @Override
    public void convert(SViewHolder holder, String data) {
    }

}
