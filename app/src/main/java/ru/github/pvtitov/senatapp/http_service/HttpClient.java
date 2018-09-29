package ru.github.pvtitov.senatapp.http_service;

import java.util.List;

import ru.github.pvtitov.senatapp.pojos.Item;
import ru.github.pvtitov.senatapp.pojos.Meeting;
import ru.github.pvtitov.senatapp.pojos.Meetings;

public interface HttpClient {

    void requestMeetingsList();
    void requestMeeting(String id);

    interface HttpResponseListener {
        void onSuccess(Meetings meetings);
        void onSuccess(Meeting meeting);
        void onError(String message);
    }
}
