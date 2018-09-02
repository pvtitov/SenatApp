package ru.github.pvtitov.senatapp.login;

import ru.github.pvtitov.senatapp.MvpContract;

public class LoginPresenter extends MvpContract.BasicPresenter<LoginView, LoginModel> implements LoginModel.AuthListener {

    private static LoginPresenter instance;

    public static LoginPresenter getInstance() {
        if (instance == null) instance = new LoginPresenter();
        return instance;
    }

    private LoginPresenter() {
    }

    public void authorize(String login, String password) {
        LoginModel model = getModel();
        if (model != null) {
            model.setAuthListener(this);
            model.authorize(login, password);
        }
    }

    @Override
    public void onSuccess() {
        LoginView view = getView();
        if (view != null) {
            view.saveAuthorizedState(true);
            view.shutDown();
        }
    }

    @Override
    public void onError(String message) {
        getView().showMessage(message);
    }
}
