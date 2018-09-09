package ru.github.pvtitov.senatapp.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.github.pvtitov.senatapp.R;
import ru.github.pvtitov.senatapp.pojos.Item;
import ru.github.pvtitov.senatapp.pojos.Meetings;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MeetingViewHolder> {

    private Meetings meetings;

    public MeetingAdapter(Meetings meetings) {
        this.meetings = meetings;
    }

    @NonNull
    @Override
    public MeetingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewGroup layout = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        MeetingViewHolder viewHolder = new MeetingViewHolder(layout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingViewHolder viewHolder, int i) {
        Item item = meetings.getItems().get(i);
        String date = "";
        if (item.getDate() != null) date = item.getDate();
        if (item.getStartDate() != null) date = item.getStartDate();
        if (item.getEndDate() != null) date = date + " - " + item.getEndDate();
        viewHolder.date.setText(date);
        viewHolder.holdingName.setText(item.getHolding().getName());
        viewHolder.collegialBody.setText(item.getCollegialBody().getName());
        viewHolder.status.setText(item.getStatus());
    }

    @Override
    public int getItemCount() {
        if (meetings == null) return 0;
        return meetings.getItems().size();
    }

    public void setMeetings(Meetings meetings) {
        this.meetings = meetings;
    }

    static class MeetingViewHolder extends RecyclerView.ViewHolder {

        TextView date;
        TextView holdingName;
        TextView collegialBody;
        TextView status;

        MeetingViewHolder(ViewGroup viewGroup) {
            super(viewGroup);
            this.date = viewGroup.findViewById(R.id.item_date);
            this.holdingName = viewGroup.findViewById(R.id.item_holding_name);
            this.collegialBody = viewGroup.findViewById(R.id.item_collegial_body);
            this.status = viewGroup.findViewById(R.id.item_status);
        }
    }
}
