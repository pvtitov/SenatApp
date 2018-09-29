package ru.github.pvtitov.senatapp.login;

import android.support.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import ru.github.pvtitov.senatapp.http_service.ErrorResponseParser;
import ru.github.pvtitov.senatapp.http_service.LoginService;
import ru.github.pvtitov.senatapp.http_service.RetrofitManager;
import ru.github.pvtitov.senatapp.pojos.AuthRequest;

import static ru.github.pvtitov.senatapp.mvp.LoginMvpContract.*;

public class LoginModelImpl implements LoginModel {

    private AuthListener authListener;

    @Override
    public void authorize(String login, String password) {

        LoginService loginService = initLoginService();

        AuthRequest authRequest = new AuthRequest();
        authRequest
                .setUsername(login)
                .setPassword(password)
                .setRememberMe(true);

        loginService.authorize(authRequest).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    authListener.onLogin();
                }
                else handleErrorServerResponse(response);
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, Throwable t) {
                authListener.onError(t.getMessage());
            }
        });
    }

    private LoginService initLoginService() {
        Retrofit retrofit = RetrofitManager.createRetrofitForLogin();
        return retrofit.create(LoginService.class);
    }

    @Override
    public void logout() {

        LoginService loginService = initLoginService();

        loginService.logout().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    authListener.onLogout();
                }
                else handleErrorServerResponse(response);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                authListener.onError(t.getMessage());
            }
        });

    }

    private void handleErrorServerResponse(Response response) {
        ErrorResponseParser parser = new ErrorResponseParser();
        List<String> errorMessages = parser.parse(response);
        for(String message: errorMessages) authListener.onError(message);
    }

    @Override
    public void setAuthListener(AuthListener authListener) {
        this.authListener = authListener;
    }
}
