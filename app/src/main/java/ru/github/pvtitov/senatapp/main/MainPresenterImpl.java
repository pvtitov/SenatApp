package ru.github.pvtitov.senatapp.main;

import ru.github.pvtitov.senatapp.MvpContract;

public class MainPresenterImpl extends MvpContract.BasicPresenter<MainView, MainModel> {
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
}