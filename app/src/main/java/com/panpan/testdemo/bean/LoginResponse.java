package com.panpan.testdemo.bean;

/**
 * Created by Administrator on 2017/11/24.
 */

public class LoginResponse {


    public boolean flag;
    public int code;
    public String msg;
    public DataBean data;

    public static class DataBean {
        public String id;
        public String tuij_id;
        public String oper_id;
        public String username;
        public String password;
        public Object email;
        public String phone;
        public String head_ico;
        public String status;
        public String pay_password;
        public String agent;
        public Object iccid;
        public Object iccid_2;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", tuij_id='" + tuij_id + '\'' +
                    ", oper_id='" + oper_id + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", email=" + email +
                    ", phone='" + phone + '\'' +
                    ", head_ico='" + head_ico + '\'' +
                    ", status='" + status + '\'' +
                    ", pay_password='" + pay_password + '\'' +
                    ", agent='" + agent + '\'' +
                    ", iccid=" + iccid +
                    ", iccid_2=" + iccid_2 +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "flag=" + flag +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
