package ru.github.pvtitov.senatapp.login;

import android.support.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.github.pvtitov.senatapp.App;
import ru.github.pvtitov.senatapp.http_service.ErrorResponseParser;
import ru.github.pvtitov.senatapp.http_service.HttpResponseListener;
import ru.github.pvtitov.senatapp.http_service.LoginService;
import ru.github.pvtitov.senatapp.pojos.AuthRequest;

public class LoginModelImpl implements LoginModel {

    private HttpResponseListener<Void> httpResponseListener;

    @Override
    public void authorize(String login, String password) {

        LoginService loginService = App.getRetrofit().create(LoginService.class);

        AuthRequest authRequest = new AuthRequest();
        authRequest.setUsername(login);
        authRequest.setPassword(password);

        loginService.authorize(authRequest).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    httpResponseListener.onSuccess(response);
                }
                else {
                    ErrorResponseParser parser = new ErrorResponseParser();
                    parser.extractMessages(response, httpResponseListener);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, Throwable t) {
                httpResponseListener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void setHttpResponseListener(HttpResponseListener<Void> httpResponseListener) {
        this.httpResponseListener = httpResponseListener;
    }
}
