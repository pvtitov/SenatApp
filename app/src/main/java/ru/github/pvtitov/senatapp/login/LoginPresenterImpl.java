package ru.github.pvtitov.senatapp.login;

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
