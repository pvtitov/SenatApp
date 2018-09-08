package ru.github.pvtitov.senatapp.main;

import java.util.List;

import ru.github.pvtitov.senatapp.MvpContract;
import ru.github.pvtitov.senatapp.pojos.Meeting;

public interface MainModel extends MvpContract.Model {
    Meeting downloadMeeting();
    void setMeetingListener(MeetingListener listener);

    interface MeetingListener {
        void onSuccess(Meeting meeting);
        void onError(String message);
    }
}
