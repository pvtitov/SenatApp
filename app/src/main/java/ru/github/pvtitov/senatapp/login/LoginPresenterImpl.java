package ru.github.pvtitov.senatapp.login;

import android.content.SharedPreferences;

import javax.inject.Inject;

import ru.github.pvtitov.senatapp.App;
import ru.github.pvtitov.senatapp.mvp.BasicPresenter;

import static ru.github.pvtitov.senatapp.mvp.LoginMvpContract.*;
import static ru.github.pvtitov.senatapp.mvp.LoginMvpContract.LoginModel.*;

public class LoginPresenterImpl extends BasicPresenter<LoginView, LoginModel> implements LoginPresenter, AuthListener {

    @Inject LoginModelImpl model = App.getComponent().loginModel();

    @Override
    public void authorize(String login, String password) {
        if (model != null) {
            model.setAuthListener(this);
            model.authorize(login, password);
        }
    }

    @Override
    public void logout() {
        if (model != null) {
            model.setAuthListener(this);
            model.logout();
        }
        SharedPreferences prefs = App.getSharedPreferences();
        if (prefs != null) prefs.edit().remove(App.COOKIES).apply();
    }

    @Override
    public void onLogin() {
        if (getView() != null) getView().shutDown();
    }

    @Override
    public void onLogout() {

    }

    @Override
    public void onError(String message) {
        if (getView() != null) getView().showMessage(message);
    }
}