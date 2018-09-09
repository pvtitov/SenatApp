package ru.github.pvtitov.senatapp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.github.pvtitov.senatapp.http_service.AddCookiesInterceptor;
import ru.github.pvtitov.senatapp.http_service.ReceivedCookiesInterceptor;

public class App extends Application {

    public static final String COOKIES = "ru.github.pvtitov.senatapp.COOKIES";

    private static Retrofit retrofit;
    private static SharedPreferences sharedPreferences;

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AddCookiesInterceptor())
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://senat.azurewebsites.net/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
