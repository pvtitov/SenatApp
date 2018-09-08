package ru.github.pvtitov.senatapp.login;

import android.support.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.github.pvtitov.senatapp.App;
import ru.github.pvtitov.senatapp.http_service.ErrorResponseParser;
import ru.github.pvtitov.senatapp.http_service.LoginService;
import ru.github.pvtitov.senatapp.pojos.AuthRequest;

public class LoginModelImpl implements LoginModel {

    private AuthListener authListener;

    @Override
    public void authorize(String login, String password) {

        LoginService loginService = App.getRetrofit().create(LoginService.class);

        AuthRequest authRequest = new AuthRequest();
        authRequest.setUsername(login);
        authRequest.setPassword(password);
        authRequest.setRememberMe(true);

        loginService.authorize(authRequest).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    authListener.onSuccess();
                }
                else {
                    ErrorResponseParser parser = new ErrorResponseParser();
                    List<String> errorMessages = parser.parse(response);
                    for(String message: errorMessages) authListener.onError(message);
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
