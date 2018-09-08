package ru.github.pvtitov.senatapp.http_service;

import android.util.Log;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;
import ru.github.pvtitov.senatapp.App;

public class ReceivedCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        Log.d("happy", "Reading cookies");
        if (!response.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>(response.headers("Set-Cookie"));
            App.getSharedPreferences().edit()
                    .putStringSet(App.COOKIES, cookies)
                    .apply();
            Log.d("happy", "After putting cookies to prefs");
        }

        return response;
    }
}