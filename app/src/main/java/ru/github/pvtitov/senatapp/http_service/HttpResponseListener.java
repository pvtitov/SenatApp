package ru.github.pvtitov.senatapp.http_service;

import retrofit2.Response;

public interface HttpResponseListener<T> {

    void onSuccess(Response<T> response);
    void onError(String message);
}
