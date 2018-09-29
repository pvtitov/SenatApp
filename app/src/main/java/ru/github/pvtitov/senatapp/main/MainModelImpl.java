package ru.github.pvtitov.senatapp.main;

import ru.github.pvtitov.senatapp.http_service.HttpClient;
import ru.github.pvtitov.senatapp.http_service.HttpClientRetrofitImpl;

import static ru.github.pvtitov.senatapp.mvp.MainMvpContract.*;

public class MainModelImpl implements MainModel {

    private HttpClient httpClient;

    public MainModelImpl(HttpClient client) {
        this.httpClient = client;
    }

    @Override
    public void downloadMeetings() {
        httpClient.requestMeetingsList();
    }

    @Override
    public void downloadSingleMeeting(String id) {
        httpClient.requestMeeting(id);
    }
}