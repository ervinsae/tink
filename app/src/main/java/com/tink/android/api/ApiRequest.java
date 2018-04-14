package com.tink.android.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tink.android.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ervin on 2018/4/14.
 */

public class ApiRequest {

    private static ApiService mApiService;
    private static Retrofit mRetrofit;
    private static OkHttpClient mOkHttpClient;

    private ApiRequest(){}

    static {
        //静态代码块可以做些初始化操作
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        //设置超时
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);


        mOkHttpClient = builder.build();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        mRetrofit = new Retrofit.Builder()
                .baseUrl("base_url")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mOkHttpClient)
                .build();

    }

    public static ApiService getApiService(){
        synchronized (new Object()){
            if(mApiService == null){
                mApiService = mRetrofit.create(ApiService.class);
            }
            return mApiService;
        }
    }

}
