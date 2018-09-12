package ru.github.pvtitov.senatapp.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    private Meeting meeting;
    private TextView dateTextView;
    private TextView statusTextView;
    private TextView collegialBodyTextView;

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
        collegialBodyTextView = view.findViewById(R.id.details_coolegial_body_value);

        dateTextView.setText(meeting.getDate());
        statusTextView.setText(meeting.getStatus());
        collegialBodyTextView.setText(meeting.getCollegialBody().getName());

        return view;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }
}
