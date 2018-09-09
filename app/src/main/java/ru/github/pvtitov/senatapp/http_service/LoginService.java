package ru.github.pvtitov.senatapp.http_service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.github.pvtitov.senatapp.pojos.AuthRequest;

public interface LoginService {
    @POST("api/Account/Login?api-version=1")
    Call<Void> authorize(@Body AuthRequest authRequest);

    @POST("api/Account/Logout?api-version=1")
    Call<Void> logout();
}
