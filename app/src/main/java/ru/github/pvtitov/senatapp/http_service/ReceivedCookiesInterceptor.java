package ru.github.pvtitov.senatapp.http_service;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;
import ru.github.pvtitov.senatapp.App;

public class ReceivedCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Response response = chain.proceed(chain.request());

        if (response.isSuccessful()) {
            HashSet<String> cookies = new HashSet<>(response.headers("Set-Cookie"));
            App.getSharedPreferences().edit()
                    .putStringSet(App.COOKIES, cookies)
                    .apply();
        }

        return response;
    }
}