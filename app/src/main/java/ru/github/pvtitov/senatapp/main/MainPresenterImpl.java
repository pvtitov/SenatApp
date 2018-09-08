package ru.github.pvtitov.senatapp.main;

import java.util.List;

import ru.github.pvtitov.senatapp.MvpContract;
import ru.github.pvtitov.senatapp.pojos.Meeting;

public class MainPresenterImpl extends MvpContract.BasicPresenter<MainView, MainModel> implements MainModel.MeetingListener {
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

    public void downloadMeeting() {
        MainModel model = getModel();
        if (model != null) {
            model.setMeetingListener(this);
            model.downloadMeeting();
        }
    }

    @Override
    public void onSuccess(Meeting meeting) {
        getView().showMessage("onSuccess()");
    }

    @Override
    public void onError(String message) {

    }
}