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
        void itemClicked(Item item);
        MeetingAdapter getMeetingAdapter();
    }

    interface MainModel extends MvpContract.Model {
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

    interface MainView extends MvpContract.View {
        void openLoginScreen();
        void showMeetingDetails(Meeting meeting);
    }
}
