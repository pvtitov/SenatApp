package ru.github.pvtitov.senatapp.main;

import java.util.List;

import ru.github.pvtitov.senatapp.MvpContract;
import ru.github.pvtitov.senatapp.http_service.HttpResponseListener;
import ru.github.pvtitov.senatapp.pojos.Meeting;

public interface MainModel extends MvpContract.Model {
    List<Meeting> downloadMeetings();
    Meeting downloadMeeting(String id);
    void setMeetingsListener(HttpResponseListener<List<Meeting>> listener);
    void setMeetingListener(HttpResponseListener<Meeting> listener);
}
