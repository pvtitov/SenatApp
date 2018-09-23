package ru.github.pvtitov.senatapp.main;

import ru.github.pvtitov.senatapp.MvpContract;
import ru.github.pvtitov.senatapp.pojos.Item;
import ru.github.pvtitov.senatapp.pojos.Meeting;
import ru.github.pvtitov.senatapp.pojos.Meetings;

public interface MainMvpContract {
    interface MainPresenter {
        void authStatusCheck();
        void downloadMeeting();
        void openLoginScreeen();
        void itemClicked(String id);
        MeetingAdapter getMeetingAdapter();
    }

    interface MainModel extends MvpContract.Model {
        void downloadMeetings();
        void downloadSingleMeeting(String id);
    }

    interface MainView extends MvpContract.View {
        void openLoginScreen();
        void showMeetingDetails(Meeting meeting);
    }
}
