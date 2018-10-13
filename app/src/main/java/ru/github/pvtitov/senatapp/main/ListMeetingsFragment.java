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

import javax.inject.Inject;

import ru.github.pvtitov.senatapp.App;
import ru.github.pvtitov.senatapp.R;

public class ListMeetingsFragment extends Fragment {

    @Inject MainPresenterImpl presenter;
    public static final String TAG = "ru.github.pvtitov.senatapp.main.ListMeetingsFragment";
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = App.getComponent().mainPresenter();
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
