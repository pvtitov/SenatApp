package ru.github.pvtitov.senatapp.main;

import ru.github.pvtitov.senatapp.MvpContract;
import ru.github.pvtitov.senatapp.pojos.Item;
import ru.github.pvtitov.senatapp.pojos.Meeting;
import ru.github.pvtitov.senatapp.pojos.Meetings;

public interface MainModel extends MvpContract.Model {
    void downloadMeetings();
    void setMeetingsListener(MeetingsListener listener);
    void downloadSingleMeeting(Item item);
    void setSingleMeetingListener(SingleMeetingListener listener);

    interface MeetingsListener {
        void onSuccess(Meetings meetings);
        void onError(String message);
    }

    interface SingleMeetingListener {
        void onSuccess(Meeting meeting);
        void onError(String message);
    }
}
