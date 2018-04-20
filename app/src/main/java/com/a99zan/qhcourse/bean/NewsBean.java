package com.a99zan.qhcourse.bean;

import java.util.List;

/**
 * Created by 99zan on 2018/4/18.
 */

public class NewsBean {

    /**
     * code : 200
     * msg : 成功
     * data : [{"news_id":"23","news_title":"企航弟子总会商业圈丨行业大梁会议成功召开","news_show_img":"http://bm.99zan.vip/uploads/news/20180410090542735896.jpg","news_time":"2018-04-10 09:05:42","news_content":"<section><section><section><section><p style=\"marg"},{"news_id":"24","news_title":"房地产行业的\u201c杨门女将\u201d","news_show_img":"http://bm.99zan.vip/uploads/news/20180410093506512503.jpg","news_time":"2018-04-10 09:11:41","news_content":"<section><section><section><section><section><sect"},{"news_id":"26","news_title":"《2018企航师资部学习圈会议》圆满落幕","news_show_img":"http://bm.99zan.vip/uploads/news/20180410103116435648.jpg","news_time":"2018-04-10 10:31:16","news_content":"<p style=\"margin-top: 0px; margin-bottom: 0px; whi"},{"news_id":"25","news_title":"小小快餐店月营业额可高达200多万","news_show_img":"http://bm.99zan.vip/uploads/news/20180410092000839260.jpg","news_time":"2018-04-10 09:20:00","news_content":"<section><section><section><section><section><sect"},{"news_id":"27","news_title":"绝处逢生 农资行业开启模式新篇章","news_show_img":"http://bm.99zan.vip/uploads/news/20180410104626692880.jpg","news_time":"2018-04-10 10:46:26","news_content":"<section><section><section><section><section><p st"},{"news_id":"28","news_title":"一个被企航唤醒的富二代","news_show_img":"http://bm.99zan.vip/uploads/news/20180410105835267331.jpg","news_time":"2018-04-10 10:58:35","news_content":"<section><section><p style=\"margin-top: 0px; margi"},{"news_id":"29","news_title":"中小企业之九大规划丨为企业家打造成功的桥梁","news_show_img":"http://bm.99zan.vip/uploads/news/20180410110341593857.jpg","news_time":"2018-04-10 11:03:41","news_content":"<section><section><section><section><section><sect"},{"news_id":"30","news_title":"《2018企航弟子总会会长级会议》盛大召开","news_show_img":"http://bm.99zan.vip/uploads/news/20180410110712791434.jpg","news_time":"2018-04-10 11:07:12","news_content":"<section><section><section><section><section><sect"},{"news_id":"31","news_title":"8字箴言助她的企业在建材行业崛起","news_show_img":"http://bm.99zan.vip/uploads/news/20180410112614292083.jpg","news_time":"2018-04-10 11:26:14","news_content":"<p style=\"margin-top: 0px; margin-bottom: 0px; whi"}]
     */

    private String code;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * news_id : 23
         * news_title : 企航弟子总会商业圈丨行业大梁会议成功召开
         * news_show_img : http://bm.99zan.vip/uploads/news/20180410090542735896.jpg
         * news_time : 2018-04-10 09:05:42
         * news_content : <section><section><section><section><p style="marg
         */

        private String news_id;
        private String news_title;
        private String news_show_img;
        private String news_time;
        private String news_content;

        public String getNews_id() {
            return news_id;
        }

        public void setNews_id(String news_id) {
            this.news_id = news_id;
        }

        public String getNews_title() {
            return news_title;
        }

        public void setNews_title(String news_title) {
            this.news_title = news_title;
        }

        public String getNews_show_img() {
            return news_show_img;
        }

        public void setNews_show_img(String news_show_img) {
            this.news_show_img = news_show_img;
        }

        public String getNews_time() {
            return news_time;
        }

        public void setNews_time(String news_time) {
            this.news_time = news_time;
        }

        public String getNews_content() {
            return news_content;
        }

        public void setNews_content(String news_content) {
            this.news_content = news_content;
        }
    }
}
