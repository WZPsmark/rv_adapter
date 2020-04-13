package com.smark.skadapterdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sk.rvadapter.adapter.SkAdapter;
import com.sk.rvadapter.holder.SViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    List<String> mStringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        mRecyclerView = findViewById(R.id.recycle_view);
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, mStringList, R.layout.item);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
        mRecyclerView.setAdapter(adapter);


//        mRecyclerView.setAdapter(new SkAdapter(this, mStringList, R.layout.item) {
//            @Override
//            public void convert(SViewHolder holder, Object data) {
//
//            }
//        });
    }


    private void getData() {
        mStringList = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            mStringList.add(""+i);
        }

    }
}
