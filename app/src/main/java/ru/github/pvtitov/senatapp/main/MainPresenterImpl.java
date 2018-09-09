package ru.github.pvtitov.senatapp.main;

import android.content.SharedPreferences;

import java.util.HashSet;

import ru.github.pvtitov.senatapp.App;
import ru.github.pvtitov.senatapp.MvpContract;
import ru.github.pvtitov.senatapp.pojos.Meetings;

public class MainPresenterImpl extends MvpContract.BasicPresenter<MainView, MainModel> implements MainModel.MeetingListener {
    private static MainPresenterImpl instance;

    public static MainPresenterImpl getInstance() {
        if (instance == null) instance = new MainPresenterImpl();
        return instance;
    }

    private MainPresenterImpl() {
    }

    private Meetings meetings;
    private MeetingAdapter adapter;

    public void authStatusCheck() {
        SharedPreferences prefs = App.getSharedPreferences();
        if (prefs.getStringSet(App.COOKIES, new HashSet<>()).size() == 0) {
            MainView view = getView();
            if (view != null) view.openLoginScreen();
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
    public void onSuccess(Meetings meetings) {
        this.meetings = meetings;
        adapter.setMeetings(meetings);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String message) {

    }

    public void openLoginScreeen() {
        MainView view = getView();
        if (view != null) {
            view.openLoginScreen();
        }
    }

    public MeetingAdapter getMeetingAdapter() {
        adapter = new MeetingAdapter(meetings);
        return adapter;
    }
}