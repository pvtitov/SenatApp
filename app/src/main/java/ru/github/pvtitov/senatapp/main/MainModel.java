package ru.github.pvtitov.senatapp.main;

import java.util.List;

import ru.github.pvtitov.senatapp.MvpContract;
import ru.github.pvtitov.senatapp.pojos.Meeting;

public interface MainModel extends MvpContract.Model {
    List<Meeting> downloadMeetings();
    Meeting downloadMeeting(String id);
    void setDownloadListener(DownloadListener downloadListener);

    interface DownloadListener<T> {
        void onSuccess(T content);
        void onError(String message);
    }
}
