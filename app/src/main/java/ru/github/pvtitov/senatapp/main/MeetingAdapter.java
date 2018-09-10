package ru.github.pvtitov.senatapp.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ru.github.pvtitov.senatapp.MvpContract;
import ru.github.pvtitov.senatapp.R;
import ru.github.pvtitov.senatapp.pojos.Item;
import ru.github.pvtitov.senatapp.pojos.Meeting;
import ru.github.pvtitov.senatapp.pojos.Meetings;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MeetingViewHolder> {

    private Meetings meetings;

    public MeetingAdapter(Meetings meetings) {
        this.meetings = meetings;
    }

    public void setMeetings(Meetings meetings) {
        this.meetings = meetings;
    }

    @NonNull
    @Override
    public MeetingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new MeetingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingViewHolder viewHolder, int i) {
        Item item = meetings.getItems().get(i);
        String date = "";
        if (item.getId() != null) date = item.getDate();
        if (item.getStartDate() != null) date = item.getStartDate();
        if (item.getEndDate() != null) date = date + " - " + item.getEndDate();
        viewHolder.date.setText(date);
        viewHolder.holdingName.setText(item.getHolding().getName());
        viewHolder.collegialBody.setText(item.getCollegialBody().getName());
        viewHolder.status.setText(item.getStatus());
        viewHolder.layout.setOnClickListener(view -> MainPresenterImpl.getInstance().itemClicked(item));
    }

    @Override
    public int getItemCount() {
        if (meetings == null) return 0;
        return meetings.getItems().size();
    }


    static class MeetingViewHolder extends RecyclerView.ViewHolder {

        LinearLayout layout;
        TextView date;
        TextView holdingName;
        TextView collegialBody;
        TextView status;

        MeetingViewHolder(View view) {
            super(view);
            this.date = view.findViewById(R.id.item_date);
            this.holdingName = view.findViewById(R.id.item_holding_name);
            this.collegialBody = view.findViewById(R.id.item_collegial_body);
            this.status = view.findViewById(R.id.item_status);
            this.layout = view.findViewById(R.id.item_container);
        }
    }
}
