package ru.github.pvtitov.senatapp.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.github.pvtitov.senatapp.R;
import ru.github.pvtitov.senatapp.pojos.Agenda;
import ru.github.pvtitov.senatapp.pojos.Meeting;
import ru.github.pvtitov.senatapp.pojos.Participant;

public class DetailMeetingFragment extends Fragment {

    public static final String TAG = "ru.github.pvtitov.senatapp.main.DetailMeetingFragment";

    private MainPresenterImpl presenter;
    private TextView idTextView;
    private Meeting meeting;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = MainPresenterImpl.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meeting_details, container, false);

        idTextView = view.findViewById(R.id.details_text);
        if (meeting != null) {
            String text = parseMeetingPojo(meeting);
            idTextView.setText(text);
        }

        return view;
    }

    private String parseMeetingPojo(Meeting meeting) {

        if (meeting == null) return "";

        StringBuilder text = new StringBuilder()
                .append(meeting.getId()).append("\n")
                .append(meeting.getStatus()).append("\n")
                .append(meeting.getDate()).append("\n")
                .append(meeting.getCollegialBody().getName()).append("\n")
                .append(meeting.getHead() == null ? "" : meeting.getHead().getFirstName()).append("\n")
                .append(meeting.getHead() == null ? "" : meeting.getHead().getLastName()).append("\n")
                .append(meeting.getSecretary() == null ? "" : meeting.getSecretary().getFirstName()).append("\n")
                .append(meeting.getSecretary() == null ? "" : meeting.getSecretary().getLastName()).append("\n");
        if (meeting.getAgenda() != null) {
            for (Agenda agenda: meeting.getAgenda()) {
                text.append(agenda.getTitle()).append("\n")
                        .append(agenda.getAuthor() == null ? "" : agenda.getAuthor().getFirstName()).append("\n")
                        .append(agenda.getAuthor() == null ? "" : agenda.getAuthor().getLastName()).append("\n");
            }
        }

        if (meeting.getParticipants() != null) {
            for (Participant participant: meeting.getParticipants()) {
                text
                        .append(participant.getFirstName()).append("\n")
                        .append(participant.getLastName()).append("\n");
            }
        }

        return text.toString();
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
        if (idTextView != null) idTextView.setText(meeting.getId());
    }
}
