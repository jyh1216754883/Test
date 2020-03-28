package com.example.zqq.myrecyclerview;

/**
 * Created by ZQQ on 2020/3/28.
 */


 import android.graphics.Rect;
 import android.support.v7.widget.RecyclerView;
 import android.view.View;

public class SpaceItemDecration extends RecyclerView.ItemDecoration {
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //获取当前item的下标
        int pos = parent.getChildLayoutPosition(view);
        if (pos < 3) {
            outRect.top = 0;
        } else {
            outRect.top = 10;
        }
        outRect.left = 5;
        outRect.right = 5;
    }
}
