package ru.github.pvtitov.senatapp.login;

import ru.github.pvtitov.senatapp.MvpContract;

public interface LoginView extends MvpContract.View {
    void saveAuthorizedState(boolean isAuthorized);
    void shutDown();
}
