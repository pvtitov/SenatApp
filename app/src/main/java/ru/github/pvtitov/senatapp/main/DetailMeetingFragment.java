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

public class DetailMeetingFragment extends Fragment {

    public static final String TAG = "ru.github.pvtitov.senatapp.main.DetailMeetingFragment";
    public static final String DETAILS_ID = "DETAILS_ID";

    private MainPresenterImpl presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = MainPresenterImpl.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meeting_details, container, false);

        TextView idTextView = view.findViewById(R.id.details_id);
        idTextView.setText(savedInstanceState.getString(DETAILS_ID));

        return view;
    }
}
