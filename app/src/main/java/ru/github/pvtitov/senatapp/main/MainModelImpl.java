package ru.github.pvtitov.senatapp.main;

import ru.github.pvtitov.senatapp.http_service.HttpClient;
import ru.github.pvtitov.senatapp.http_service.HttpClientRetrofitImpl;

import static ru.github.pvtitov.senatapp.main.MainMvpContract.*;

public class MainModelImpl implements MainModel {

    public MainModelImpl(HttpClient.HttpResponseListener listener) {
        this.responseListener = listener;
        httpClient = new HttpClientRetrofitImpl(responseListener);
    }

    private HttpClient.HttpResponseListener responseListener;
    private HttpClient httpClient;

    @Override
    public void downloadMeetings() {
        httpClient.requestMeetingsList();
    }

    @Override
    public void downloadSingleMeeting(String id) {
        httpClient.requestMeeting(id);
    }
}