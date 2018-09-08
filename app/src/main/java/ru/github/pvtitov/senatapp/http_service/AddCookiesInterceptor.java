package ru.github.pvtitov.senatapp.http_service;

import android.util.Log;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import ru.github.pvtitov.senatapp.App;

import static ru.github.pvtitov.senatapp.App.COOKIES;

public class AddCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        addCookies(builder);
        Log.d("happy", "Before adding cookies");
        return chain.proceed(builder.build());
    }

    private void addCookies(Request.Builder builder) {
        if (App.getSharedPreferences() != null) {
            HashSet<String> cookies = (HashSet<String>) App.getSharedPreferences().getStringSet(COOKIES, new HashSet<>());
            for (String cookie : cookies) {
                builder.addHeader("Cookie", cookie);
                Log.d("happy", "Cookie: " + cookie);
            }
        }
    }
}