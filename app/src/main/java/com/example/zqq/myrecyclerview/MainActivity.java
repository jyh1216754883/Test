package com.example.zqq.myrecyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private  adapter adapter;
    private List<user>list;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        recyclerview = (RecyclerView)findViewById(R.id.recyclerview);

        list = new ArrayList<>();
        for (int i=0;i<11;i++){
            list.add(new user(R.mipmap.img,"测试"+i));
        }
//        瀑布流
        recyclerview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
//        分割线
        recyclerview.addItemDecoration(new SpaceItemDecration());

        adapter = new adapter(this);
        adapter.setList(list);
        recyclerview.setAdapter(adapter);


    }
}
