package ru.github.pvtitov.senatapp.login;

import android.content.SharedPreferences;

import ru.github.pvtitov.senatapp.App;
import ru.github.pvtitov.senatapp.MvpContract;

public class LoginPresenterImpl extends MvpContract.BasicPresenter<LoginView, LoginModel> implements LoginModel.AuthListener {

    private static LoginPresenterImpl instance;

    public static LoginPresenterImpl getInstance() {
        if (instance == null) instance = new LoginPresenterImpl();
        return instance;
    }

    private LoginPresenterImpl() {
    }


    public void authorize(String login, String password) {
        LoginModel model = getModel();
        if (model != null) {
            model.setAuthListener(this);
            model.authorize(login, password);
        }
    }

    public void logout() {
        LoginModel model = getModel();
        if (model != null) {
            model.setAuthListener(this);
            model.logout();
        }
        SharedPreferences prefs = App.getSharedPreferences();
        if (prefs != null) prefs.edit().remove(App.COOKIES).apply();
    }

    @Override
    public void onLogin() {
        LoginView view = getView();
        if (view != null) {
            view.shutDown();
        }
    }

    @Override
    public void onLogout() {

    }

    @Override
    public void onError(String message) {
        getView().showMessage(message);
    }
}
