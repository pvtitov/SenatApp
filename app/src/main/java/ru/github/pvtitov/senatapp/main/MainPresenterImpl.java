package ru.github.pvtitov.senatapp.main;

import android.content.SharedPreferences;

import java.util.HashSet;

import ru.github.pvtitov.senatapp.App;
import ru.github.pvtitov.senatapp.mvp.BasicPresenter;
import ru.github.pvtitov.senatapp.http_service.HttpClient;
import ru.github.pvtitov.senatapp.pojos.Meeting;
import ru.github.pvtitov.senatapp.pojos.Meetings;

import static ru.github.pvtitov.senatapp.mvp.MainMvpContract.*;

public class MainPresenterImpl extends BasicPresenter<MainView, MainModel> implements MainPresenter, HttpClient.HttpResponseListener {

    private Meetings meetings;
    private MeetingAdapter adapter;

    private static MainPresenterImpl instance;

    public static MainPresenterImpl getInstance() {
        if (instance == null) instance = new MainPresenterImpl();
        return instance;
    }

    private MainPresenterImpl() {
    }

    @Override
    public void authStatusCheck() {
        SharedPreferences prefs = App.getSharedPreferences();
        if (prefs.getStringSet(App.COOKIES, new HashSet<>()).size() == 0) {
            MainView view = getView();
            if (view != null) view.openLoginScreen();
        }
    }

    @Override
    public void downloadMeeting() {
        getModel().downloadMeetings();
        getView().showProgressBar();
    }

    @Override
    public void onSuccess(Meetings meetings) {
        getView().hideProgressBar();
        this.meetings = meetings;
        adapter.setMeetings(meetings);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess(Meeting meeting) {
        getView().hideProgressBar();
        getView().showMeetingDetails(meeting);
    }

    @Override
    public void onError(String message) {
        getView().hideProgressBar();
        getView().showMessage(message);
    }

    @Override
    public void openLoginScreeen() {
        getView().openLoginScreen();
    }

    @Override
    public MeetingAdapter getMeetingAdapter() {
        adapter = new MeetingAdapter(meetings);
        return adapter;
    }

    @Override
    public void itemClicked(String id) {
        getModel().downloadSingleMeeting(id);
        getView().showProgressBar();
    }
}