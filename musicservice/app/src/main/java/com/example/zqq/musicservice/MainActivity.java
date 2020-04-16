package com.example.zqq.musicservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_play;
    private Button btn_preview;
    private Button btn_stop;
    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        初始化
        btn_preview = (Button)findViewById(R.id.btn_preview);
        btn_play = (Button)findViewById(R.id.btn_play);
        btn_stop = (Button)findViewById(R.id.btn_stop);
        btn_next = (Button)findViewById(R.id.btn_next);
//        设置监听
        btn_preview.setOnClickListener(this);
        btn_next.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_play.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent =new Intent(this,MusicService.class);
        if(btn_play == v){
            intent.putExtra("action","play");
            startService(intent);
        }else if(btn_preview == v){
            intent.putExtra("action","preview");
            startService(intent);
        }else if(btn_stop == v){
            intent.putExtra("action","stop");
            startService(intent);
        }else if(btn_next == v){
            intent.putExtra("action","next");
            startService(intent);
        }
    }


}
