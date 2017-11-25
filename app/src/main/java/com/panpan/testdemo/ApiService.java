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
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/11/24.
 */

public interface ApiService {

    //1.post
    @FormUrlEncoded
    @POST("index.php?controller=wzapi")
    Call<LoginResponse> login(@Field("action") String action,
                              @Field("userinfo") String userinfo,
                              @Field("pwd") String pwd);

    //2.post map提交参数
    @FormUrlEncoded
    @POST("index.php?controller=wzapi")
    Call<LoginResponse> login2(@FieldMap Map<String, String> params);

    //1.get请求空参
    @GET("index.php?controller=wzapi&action=index")
    Call<HomeBean> getHomeData();

    //2.get请求有参
    @GET("index.php?controller=wzapi")
    Call<HomeBean> getHomeData(@Query("action") String action);

    //3.get请求有参，使用rxjava
    @GET("index.php?controller=wzapi")
    Observable<HomeBean> getHomeData2(@Query("action") String action);

}
