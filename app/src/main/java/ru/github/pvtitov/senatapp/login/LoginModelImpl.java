package ru.github.pvtitov.senatapp.login;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.github.pvtitov.senatapp.http_service.LoginService;
import ru.github.pvtitov.senatapp.pojos.AuthError;
import ru.github.pvtitov.senatapp.pojos.AuthRequest;

public class LoginModelImpl implements LoginModel {

    private AuthListener authListener;

    @Override
    public void authorize(String login, String password) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://senat.azurewebsites.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginService loginService = retrofit.create(LoginService.class);

        AuthRequest authRequest = new AuthRequest();
        authRequest.setUsername(login);
        authRequest.setPassword(password);

        loginService.authorize(authRequest).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    authListener.onSuccess();
                }
                else {
                    Converter<ResponseBody, AuthError> errorConverter = retrofit.responseBodyConverter(AuthError.class, new Annotation[0]);
                    AuthError error;
                    try {
                        if (response.errorBody() != null) {
                            error = errorConverter.convert(response.errorBody());
                            for(AuthError e: error.getErrors()) authListener.onError(e.getMessage());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, Throwable t) {
                authListener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void setAuthListener(AuthListener authListener) {
        this.authListener = authListener;
    }
}
