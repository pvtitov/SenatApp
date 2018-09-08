package ru.github.pvtitov.senatapp.http_service;

public interface HttpResponseListener {

    void onSuccess();
    void onError(String message);
}
