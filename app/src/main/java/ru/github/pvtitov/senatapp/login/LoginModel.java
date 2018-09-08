package ru.github.pvtitov.senatapp.login;

import ru.github.pvtitov.senatapp.MvpContract;
import ru.github.pvtitov.senatapp.http_service.HttpResponseListener;

public interface LoginModel extends MvpContract.Model{
    void authorize(String login, String password);
    void setHttpResponseListener(HttpResponseListener httpResponseListener);
}
