package com.a99zan.qhcourse.bean;

/**
 * Created by 99zan on 2018/4/19.
 */

public class LoginBean {

    /**
     * code : 200
     * msg : 成功
     * data : {"user_token":"43733e4feba2c4bf6f1e3c8f920b3ffe","user_head":"http://bm.99zan.vip/uploads/user/head_img-11.jpeg","user_name":"未了吧修改","user_id":"11","user_autograph":"巴巴吧呃呃呃呃"}
     */

    private String code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_token : 43733e4feba2c4bf6f1e3c8f920b3ffe
         * user_head : http://bm.99zan.vip/uploads/user/head_img-11.jpeg
         * user_name : 未了吧修改
         * user_id : 11
         * user_autograph : 巴巴吧呃呃呃呃
         */

        private String user_token;
        private String user_head;
        private String user_name;
        private String user_id;
        private String user_autograph;

        public String getUser_token() {
            return user_token;
        }

        public void setUser_token(String user_token) {
            this.user_token = user_token;
        }

        public String getUser_head() {
            return user_head;
        }

        public void setUser_head(String user_head) {
            this.user_head = user_head;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_autograph() {
            return user_autograph;
        }

        public void setUser_autograph(String user_autograph) {
            this.user_autograph = user_autograph;
        }
    }
}
