package ru.github.pvtitov.senatapp.login;

import ru.github.pvtitov.senatapp.MvpContract;

public interface LoginModel extends MvpContract.Model{
    void authorize(String login, String password);
    void setAuthListener(AuthListener authListener);

    interface AuthListener {
        void onSuccess();
        void onError(String message);
    }
}
