package ru.github.pvtitov.senatapp.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import ru.github.pvtitov.senatapp.R;
import ru.github.pvtitov.senatapp.pojos.Agenda;
import ru.github.pvtitov.senatapp.pojos.Meeting;
import ru.github.pvtitov.senatapp.pojos.Participant;
import ru.github.pvtitov.senatapp.pojos.Secretary;

public class DetailMeetingFragment extends Fragment {

    public static final String TAG = "ru.github.pvtitov.senatapp.main.DetailMeetingFragment";

    private MainPresenterImpl presenter;
    private Meeting meeting;
    private TextView dateTextView;
    private TextView statusTextView;
    private TextView collegialBodyTextView;
    private TextView addressTextView;
    private TextView headTextView;
    private TextView secretaryTextView;
    private TextView agendaTextView;
    private TextView participantsTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = MainPresenterImpl.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meeting_details, container, false);

        dateTextView = view.findViewById(R.id.details_date_value);
        statusTextView = view.findViewById(R.id.details_status_value);
        collegialBodyTextView = view.findViewById(R.id.details_collegial_body_value);
        addressTextView = view.findViewById(R.id.details_address_value);
        headTextView = view.findViewById(R.id.details_head_value);
        secretaryTextView = view.findViewById(R.id.details_secretary_value);
        agendaTextView = view.findViewById(R.id.details_agenda_value);
        participantsTextView = view.findViewById(R.id.details_participants_value);

        try {
            if (meeting.getDate() != null) {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date millis = format.parse(meeting.getDate());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(millis);
                String[] months = {"января", "февраля", "марта", "апреля", "мая", "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря"};
                StringBuilder dataText = new StringBuilder()
                        .append(calendar.get(Calendar.DAY_OF_MONTH))
                        .append(" ")
                        .append(months[calendar.get(Calendar.MONTH)])
                        .append(" ")
                        .append(calendar.get(Calendar.YEAR));
                dateTextView.setText(dataText);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        statusTextView.setText(meeting.getStatus());
        collegialBodyTextView.setText(meeting.getCollegialBody().getName());
        //if (meeting.getAddress() != null)
        //    addressTextView.setText(meeting.getAddress());
        if (meeting.getHead() != null) {
            String headName = meeting.getHead().getFirstName() + meeting.getHead().getLastName();
            headTextView.setText(headName);
        }
        if (meeting.getSecretary() != null) {
            String secretaryName = meeting.getSecretary().getFirstName() + meeting.getSecretary().getLastName();
            secretaryTextView.setText(secretaryName);
        }

        if (meeting.getAgenda() != null) {
            StringBuilder agenda = new StringBuilder();
            for (Agenda a: meeting.getAgenda()) {
                agenda.append(a.getAuthor().getFirstName())
                        .append(" ")
                        .append(a.getAuthor().getLastName())
                        .append("\n")
                        .append(a.getTitle())
                        .append("\n")
                        .append(a.getDescription())
                        .append("\n");
            }
            agendaTextView.setText(agenda);
        }

        if (meeting.getParticipants() != null) {
            StringBuilder participants = new StringBuilder();
            for (Participant p: meeting.getParticipants()) {
                participants.append(p.getFirstName())
                        .append(" ")
                        .append(p.getLastName());
            }
            participantsTextView.setText(participants);
        }

        return view;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }
}
