package ru.github.pvtitov.senatapp;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import retrofit2.Retrofit;
import ru.github.pvtitov.senatapp.http_service.RetrofitManager;

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

        retrofit = RetrofitManager.createRetrofitForListAndDetails();
    }
}
