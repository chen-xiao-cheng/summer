package com.example.test233.bean;

import org.json.JSONArray;

import java.util.List;

public class ZhBean {
        /**
         * images : ["https://pic3.zhimg.com/v2-fba132c789e7fd09bf58af3011e63afe.jpg"]
         * type : 0
         * id : 9713451
         * ga_prefix : 071709
         * title : 苹果取消了 12 寸 MacBook 产品线，可能的原因有哪些？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private String images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }
    }
