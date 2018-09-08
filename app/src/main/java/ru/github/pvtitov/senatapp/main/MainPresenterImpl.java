package ru.github.pvtitov.senatapp.main;

import retrofit2.Response;
import ru.github.pvtitov.senatapp.MvpContract;
import ru.github.pvtitov.senatapp.http_service.HttpResponseListener;

public class MainPresenterImpl extends MvpContract.BasicPresenter<MainView, MainModel> implements HttpResponseListener {
    private static MainPresenterImpl instance;

    public static MainPresenterImpl getInstance() {
        if (instance == null) instance = new MainPresenterImpl();
        return instance;
    }

    private MainPresenterImpl() {
    }

    public void authStatusCheck() {
        MainView view = getView();
        if (view != null) {
            if (!view.isAuthorized()) view.openLoginScreen();
        }
    }

    @Override
    public void onSuccess(Response response) {

    }

    @Override
    public void onError(String message) {

    }
}