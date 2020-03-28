package com.example.zqq.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import java.util.List;

/**
 * Created by ZQQ on 2020/3/27.
 */

public class adapter extends RecyclerView.Adapter<adapter.myviewholder>{

    private List<user>list;
    private Context context;
    private LayoutInflater mInflater;


    public adapter( Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = mInflater.inflate(R.layout.item, null);
        return new myviewholder(layout);
    }

    @Override
    public void onBindViewHolder(adapter.myviewholder myviewholder, int position) {
        myviewholder.textView.setText(list.get(position).getName());
        myviewholder.img.setImageResource(list.get(position).getIcon());
       if (position % 3 == 0) {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams
                    (ViewGroup.LayoutParams.WRAP_CONTENT, 240);
           myviewholder.img.setLayoutParams(lp);
       } else {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams
                    (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            myviewholder.img.setLayoutParams(lp);
       }
  }

    @Override
    public int getItemCount() {
        return null == list ? 0 : list.size();
    }

    class myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;
        ImageView img;

        public myviewholder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textView);
            img = (ImageView)itemView.findViewById(R.id.img);
//            在Adapter里面直接对控件做点击事件
            itemView.setOnClickListener( this);
        }
        @Override
        public void onClick(View v) {
            //获取当前这个item的位置
            int position = getLayoutPosition();
            list.remove(position);
            notifyItemRemoved(position);
        }
    }
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public List<user> getList() {
        return list;
    }

    public void setList(List<user> list) {
        this.list = list;
    }
}
