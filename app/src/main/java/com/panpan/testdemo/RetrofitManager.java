package com.panpan.testdemo;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2017/11/25.
 */

public class RetrofitManager {

    private static RetrofitManager instance;
    private final OkHttpClient mOkHttpClient;
    private final Retrofit mRetrofit;

    private RetrofitManager(){
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("okhttp", message);
            }
        });
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logInterceptor).build();


        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://api.wnaaa.cn:8801/")
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(mOkHttpClient)
                .build();
    }

    public static RetrofitManager getInstance(){
        if (instance == null) {
            synchronized (RetrofitManager.class) {
                if (instance == null) {
                    instance = new RetrofitManager();
                }
            }
        }
        return instance;
    }

    public <T> T createReq(Class<T> reqServer){
        return mRetrofit.create(reqServer);
    }
}
