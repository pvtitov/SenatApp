package ru.github.pvtitov.senatapp.main;

import ru.github.pvtitov.senatapp.MvpContract;
import ru.github.pvtitov.senatapp.pojos.Meeting;

public interface MainView extends MvpContract.View {
    void openLoginScreen();
    void showMeetingDetails(Meeting meeting);
}
