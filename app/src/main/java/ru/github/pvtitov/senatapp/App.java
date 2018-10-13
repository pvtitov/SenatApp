package ru.github.pvtitov.senatapp;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import retrofit2.Retrofit;
import ru.github.pvtitov.senatapp.dagger.AppComponent;
import ru.github.pvtitov.senatapp.dagger.DaggerAppComponent;
import ru.github.pvtitov.senatapp.dagger.LoginModule;
import ru.github.pvtitov.senatapp.dagger.MainModule;
import ru.github.pvtitov.senatapp.dagger.NetworkModule;
import ru.github.pvtitov.senatapp.http_service.RetrofitManager;

public class App extends Application {

    public static final String COOKIES = "ru.github.pvtitov.senatapp.COOKIES";

    private static Retrofit retrofit;
    private static SharedPreferences sharedPreferences;
    private static AppComponent component;

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static AppComponent getComponent() {
        return component;
    }

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        retrofit = RetrofitManager.createRetrofitForListAndDetails();

        component = DaggerAppComponent
                .builder()
                .loginModule(new LoginModule())
                .mainModule(new MainModule())
                .networkModule(new NetworkModule())
                .build();
    }
}
