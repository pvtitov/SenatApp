package ru.github.pvtitov.senatapp;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://senat.azurewebsites.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
