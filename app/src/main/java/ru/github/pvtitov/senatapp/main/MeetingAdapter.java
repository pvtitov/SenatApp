package ru.github.pvtitov.senatapp.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import ru.github.pvtitov.senatapp.R;
import ru.github.pvtitov.senatapp.pojos.Item;
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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.meetings_item, viewGroup, false);
        return new MeetingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingViewHolder viewHolder, int i) {
        Item item = meetings.getItems().get(i);
        try {
            if (item.getDate() != null) {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date millis = format.parse(item.getDate());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(millis);
                String[] months = {"января", "февраля", "марта", "апреля", "мая", "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря"};
                StringBuilder dataText = new StringBuilder()
                        .append(calendar.get(Calendar.DAY_OF_MONTH))
                        .append(" ")
                        .append(months[calendar.get(Calendar.MONTH)])
                        .append(" ")
                        .append(calendar.get(Calendar.YEAR));
                viewHolder.date.setText(dataText);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (item.getCollegialBody() != null) viewHolder.collegialBody.setText(item.getCollegialBody().getName());
        viewHolder.status.setText(item.getStatus());
        viewHolder.container.setOnClickListener(view -> MainPresenterImpl.getInstance().itemClicked(item));
    }

    @Override
    public int getItemCount() {
        if (meetings == null) return 0;
        return meetings.getItems().size();
    }


    static class MeetingViewHolder extends RecyclerView.ViewHolder {

        ViewGroup container;
        TextView date;
        TextView collegialBody;
        TextView status;

        MeetingViewHolder(View view) {
            super(view);
            this.date = view.findViewById(R.id.item_date_value);
            this.collegialBody = view.findViewById(R.id.item_collegial_body_value);
            this.status = view.findViewById(R.id.item_status_value);
            this.container = view.findViewById(R.id.meetings_item_container);
        }
    }
}
