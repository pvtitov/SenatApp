package ru.github.pvtitov.senatapp.main;

import ru.github.pvtitov.senatapp.MvpContract;
import ru.github.pvtitov.senatapp.pojos.Meetings;

public interface MainModel extends MvpContract.Model {
    Meetings downloadMeeting();
    void setMeetingListener(MeetingListener listener);

    interface MeetingListener {
        void onSuccess(Meetings meetings);
        void onError(String message);
    }
}
