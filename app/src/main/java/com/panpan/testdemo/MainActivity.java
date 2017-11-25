package com.panpan.testdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.panpan.testdemo.bean.HomeBean;
import com.panpan.testdemo.bean.LoginResponse;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
//                Timber.tag("OkHttp").d(message);
//                Logger.e("okhttp",message);
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
                .client(mOkHttpClient)
                .build();

    }

    public void login(View view) {

        ApiService service = mRetrofit.create(ApiService.class);
        Call<LoginResponse> call = service.login("login", "yh3776", "123456");
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                Log.e("response", response.body().toString());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    public void login2(View view) {

        ApiService login = mRetrofit.create(ApiService.class);

        Map<String, String> param = new HashMap<>();
        param.put("action", "login");
        param.put("userinfo", "yh3776");
        param.put("pwd", "123456");

        Call<LoginResponse> call = login.login2(param);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.e("response", response.body().toString());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    public void home(View view) {
        ApiService login = mRetrofit.create(ApiService.class);
        Call<HomeBean> homeData = login.getHomeData();
        homeData.enqueue(new Callback<HomeBean>() {
            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                HomeBean bean = response.body();
                Log.e("response", bean.toString());
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {

            }
        });
    }

    public void home1(View view) {
        ApiService login = mRetrofit.create(ApiService.class);
        Call<HomeBean> homeData = login.getHomeData("index");
        homeData.enqueue(new Callback<HomeBean>() {
            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                HomeBean bean = response.body();
                Log.e("response", bean.toString());
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {

            }
        });
    }
}
