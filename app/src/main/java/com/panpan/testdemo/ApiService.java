package com.panpan.testdemo;

import com.panpan.testdemo.bean.HomeBean;
import com.panpan.testdemo.bean.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/11/24.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("index.php?controller=wzapi")
    Call<LoginResponse> login(@Field("action") String action,
                              @Field("userinfo") String userinfo,
                              @Field("pwd") String pwd);


    @GET("index.php?controller=wzapi&action=index")
    Call<HomeBean> getHomeData();

    @FormUrlEncoded
    @POST("index.php?controller=wzapi")
    Call<LoginResponse> login2(@FieldMap Map<String, String> params);
}
