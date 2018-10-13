package ru.github.pvtitov.senatapp.http_service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.github.pvtitov.senatapp.pojos.CollegialBody;

public class RetrofitManager {

    public static Retrofit createRetrofitForListAndDetails() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AddCookiesInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://senat.azurewebsites.net/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static Retrofit createRetrofitForLogin() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new ReceivedCookiesInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://senat.azurewebsites.net/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
