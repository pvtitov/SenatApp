package ru.github.pvtitov.senatapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.github.pvtitov.senatapp.login.LoginActivity;

import static ru.github.pvtitov.senatapp.login.LoginActivity.IS_AUTHORIZED;

public class MainActivity extends AppCompatActivity {

    boolean isAuthorized;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        isAuthorized = preferences.getBoolean(IS_AUTHORIZED, false);
        if (!isAuthorized) {
            openLoginScreen();
        }

    }

    private void openLoginScreen() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}
