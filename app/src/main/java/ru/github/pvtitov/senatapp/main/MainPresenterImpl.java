package ru.github.pvtitov.senatapp.main;

import android.content.SharedPreferences;

import java.util.HashSet;

import ru.github.pvtitov.senatapp.App;
import ru.github.pvtitov.senatapp.MvpContract;
import ru.github.pvtitov.senatapp.pojos.Item;
import ru.github.pvtitov.senatapp.pojos.Meeting;
import ru.github.pvtitov.senatapp.pojos.Meetings;

public class MainPresenterImpl extends MvpContract.BasicPresenter<MainView, MainModel> implements MainModel.MeetingsListener, MainModel.SingleMeetingListener {

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
        getModel().setMeetingsListener(this);
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

    }

    public void openLoginScreeen() {
        getView().openLoginScreen();
    }

    public MeetingAdapter getMeetingAdapter() {
        adapter = new MeetingAdapter(meetings);
        return adapter;
    }

    public void itemClicked(Item item) {
        getModel().setSingleMeetingListener(this);
        getModel().downloadSingleMeeting(item);
        getView().showProgressBar();
    }
}