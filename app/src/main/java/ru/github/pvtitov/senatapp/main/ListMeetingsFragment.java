package ru.github.pvtitov.senatapp.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.github.pvtitov.senatapp.R;
import ru.github.pvtitov.senatapp.pojos.Item;

public class ListMeetingsFragment extends Fragment {

    public static final String TAG = "ru.github.pvtitov.senatapp.main.ListMeetingsFragment";
    private RecyclerView recyclerView;
    private MainPresenterImpl presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = MainPresenterImpl.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meetings_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MeetingAdapter adapter = presenter.getMeetingAdapter();
        recyclerView.setAdapter(adapter);

        return view;
    }
}
