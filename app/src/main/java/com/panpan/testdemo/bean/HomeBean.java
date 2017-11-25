package com.panpan.testdemo.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/11/24.
 */

public class HomeBean {

    public boolean flag;
    public int code;
    public String msg;
    public DataBean data;

    public static class DataBean {
        public List<BannerBean> banner;
        public List<CategoryBean> category;
        public List<GoodshotBean> goodshot;
        public List<ActionBean> action;
        public List<AcBannerBean> ac_banner;
        public List<?> goodsaction;
        public List<?> recommend;

        public static class BannerBean {
            public String name;
            public String url;
            public String img;

            @Override
            public String toString() {
                return "BannerBean{" +
                        "name='" + name + '\'' +
                        ", url='" + url + '\'' +
                        ", img='" + img + '\'' +
                        '}';
            }
        }

        public static class CategoryBean {
            public String id;
            public String name;
            public String appimg;

            @Override
            public String toString() {
                return "CategoryBean{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", appimg='" + appimg + '\'' +
                        '}';
            }
        }

        public static class GoodshotBean {
            public String id;
            public String name;
            public String img;
            public String sell_price;
            public String market_price;
            public String sale_jia;
            public String discount;

            @Override
            public String toString() {
                return "GoodshotBean{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", img='" + img + '\'' +
                        ", sell_price='" + sell_price + '\'' +
                        ", market_price='" + market_price + '\'' +
                        ", sale_jia='" + sale_jia + '\'' +
                        ", discount='" + discount + '\'' +
                        '}';
            }
        }

        public static class ActionBean {
            public String id;
            public String name;
            public String appimg;
        }

        public static class AcBannerBean {
            public String id;
            public String category_id;
            public String name;
            public String link;
            public String img;
            public String time;
        }
    }

    @Override
    public String toString() {
        return "HomeBean{" +
                "flag=" + flag +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
