package ru.github.pvtitov.senatapp;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import ru.github.pvtitov.senatapp.dagger.AppComponent;
import ru.github.pvtitov.senatapp.dagger.DaggerAppComponent;
import ru.github.pvtitov.senatapp.dagger.LoginModule;
import ru.github.pvtitov.senatapp.dagger.MainModule;
import ru.github.pvtitov.senatapp.dagger.NetworkModule;

public class App extends Application {

    public static final String COOKIES = "ru.github.pvtitov.senatapp.COOKIES";

    private static SharedPreferences sharedPreferences;
    private static AppComponent component;

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

        component = DaggerAppComponent
                .builder()
                .loginModule(new LoginModule())
                .mainModule(new MainModule())
                .networkModule(new NetworkModule("https://senat.azurewebsites.net/"))
                .build();
    }
}
