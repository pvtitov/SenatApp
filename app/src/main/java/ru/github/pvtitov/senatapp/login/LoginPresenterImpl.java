package ru.github.pvtitov.senatapp.login;

import retrofit2.Response;
import ru.github.pvtitov.senatapp.MvpContract;
import ru.github.pvtitov.senatapp.http_service.HttpResponseListener;

public class LoginPresenterImpl extends MvpContract.BasicPresenter<LoginView, LoginModel> implements HttpResponseListener<Void> {

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
            model.setHttpResponseListener(this);
            model.authorize(login, password);
        }
    }

    @Override
    public void onSuccess(Response<Void> response) {
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
