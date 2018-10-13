package ru.github.pvtitov.senatapp.main;

import android.content.SharedPreferences;

import java.util.HashSet;

import javax.inject.Inject;

import ru.github.pvtitov.senatapp.App;
import ru.github.pvtitov.senatapp.http_service.HttpClientRetrofitImpl;
import ru.github.pvtitov.senatapp.mvp.BasicPresenter;
import ru.github.pvtitov.senatapp.http_service.HttpClient;
import ru.github.pvtitov.senatapp.pojos.Meeting;
import ru.github.pvtitov.senatapp.pojos.Meetings;

import static ru.github.pvtitov.senatapp.mvp.MainMvpContract.*;

public class MainPresenterImpl extends BasicPresenter<MainView, MainModel> implements MainPresenter, HttpClient.HttpResponseListener {

    private Meetings meetings;
    private MeetingAdapter adapter;
    @Inject MainModelImpl model;

    public MainPresenterImpl() {
        model = App.getComponent().mainModel();
        model.setHttpResponseListener(this);
    }


    @Override
    public void authStatusCheck() {
        SharedPreferences prefs = App.getSharedPreferences();
        if (prefs.getStringSet(App.COOKIES, new HashSet<>()).size() == 0) {
            if (getView() != null) getView().openLoginScreen();
        }
    }

    @Override
    public void downloadMeeting() {
        model.downloadMeetings();
        if (getView() != null) getView().showProgressBar();
    }

    @Override
    public void onSuccess(Meetings meetings) {
        if (getView() != null) getView().hideProgressBar();
        this.meetings = meetings;
        adapter.setMeetings(meetings);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess(Meeting meeting) {
        if (getView() != null) {
            getView().hideProgressBar();
            getView().showMeetingDetails(meeting);
        }
    }

    @Override
    public void onError(String message) {
        if (getView() != null) {
            getView().hideProgressBar();
            getView().showMessage(message);
        }
    }

    @Override
    public void openLoginScreeen() {
        if (getView() != null) getView().openLoginScreen();
    }

    @Override
    public MeetingAdapter getMeetingAdapter() {
        adapter = new MeetingAdapter(meetings);
        return adapter;
    }

    @Override
    public void itemClicked(String id) {
        model.downloadSingleMeeting(id);
        if (getView() != null) getView().showProgressBar();
    }
}