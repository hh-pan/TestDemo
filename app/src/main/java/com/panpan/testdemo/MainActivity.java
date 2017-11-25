package com.panpan.testdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.panpan.testdemo.bean.HomeBean;
import com.panpan.testdemo.bean.LoginResponse;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResult = (TextView) findViewById(R.id.result_txt);

    }

    public void login(View view) {

        ApiService service = RetrofitManager.getInstance().createReq(ApiService.class);

        Call<LoginResponse> call = service.login("login", "yh3776", "123456");
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse bean = response.body();
                mResult.setText(bean.toString());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    public void login2(View view) {

        ApiService service = RetrofitManager.getInstance().createReq(ApiService.class);

        Map<String, String> param = new HashMap<>();
        param.put("action", "login");
        param.put("userinfo", "yh3776");
        param.put("pwd", "123456");

        Call<LoginResponse> call = service.login2(param);
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
        ApiService service = RetrofitManager.getInstance().createReq(ApiService.class);
        Call<HomeBean> homeData = service.getHomeData();
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
        // 1.普通使用
        /*ApiService login = mRetrofit.create(ApiService.class);
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
        });*/

        /**
         * Observable 被观察者  Observer 观察者  subscribe 订阅
         * Scheduler 线程控制
         */


        // 2. rxjava使用
        ApiService service = RetrofitManager.getInstance().createReq(ApiService.class);
        service.getHomeData2("index")  //获取Observable对象
                .subscribeOn(Schedulers.newThread())//请求在新的线程中执行，事件产生的线程
                .observeOn(Schedulers.io())  //请求完成后在io线程中执行，事件消费的线程
                .doOnNext(new Action1<HomeBean>() {

                    @Override
                    public void call(HomeBean homeBean) {
                        Log.e("response", homeBean.toString());
                    }
                }).observeOn(AndroidSchedulers.mainThread()) //最后在主线程中执行
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("response", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("response", "onError");
                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        Log.e("response", "onNext");
                    }
                });
    }
}
