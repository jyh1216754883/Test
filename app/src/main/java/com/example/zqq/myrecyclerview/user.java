package com.example.zqq.myrecyclerview;

/**
 * Created by ZQQ on 2020/3/28.
 */

public class user {
        private int img;
        private String textView;

        public int getIcon() {
            return img;
        }

        public void setIcon(int img) {
            this.img = img;
        }

        public String getName() {
            return textView;
        }

        public void setName(String textView) {
            this.textView = textView;
        }

        public user(int img, String textView) {
            this.img = img;
            this.textView = textView;
        }
}
