package ru.github.pvtitov.senatapp.main;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.github.pvtitov.senatapp.App;
import ru.github.pvtitov.senatapp.http_service.ErrorResponseParser;
import ru.github.pvtitov.senatapp.http_service.MeetingService;
import ru.github.pvtitov.senatapp.pojos.Item;
import ru.github.pvtitov.senatapp.pojos.Meeting;
import ru.github.pvtitov.senatapp.pojos.Meetings;

import static ru.github.pvtitov.senatapp.main.MainMvpContract.*;

public class MainModelImpl implements MainModel {

    private MeetingsListener meetingsListener;
    private SingleMeetingListener singleMeetingListener;
    private MeetingService service = App.getRetrofit().create(MeetingService.class);

    @Override
    public void downloadMeetings() {
        service.meetings().enqueue(new Callback<Meetings>() {
            @Override
            public void onResponse(Call<Meetings> call, Response<Meetings> response) {
                if (response.isSuccessful()) {
                    meetingsListener.onSuccess(response.body());
                }
                else {
                    ErrorResponseParser parser = new ErrorResponseParser();
                    List<String> errorMessages = parser.parse(response);
                    for(String message: errorMessages) meetingsListener.onError(message);
                }
            }

            @Override
            public void onFailure(Call<Meetings> call, Throwable t) {
                meetingsListener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void downloadSingleMeeting(Item item) {
        service.meeting(item.getId()).enqueue(new Callback<Meeting>() {
            @Override
            public void onResponse(Call<Meeting> call, Response<Meeting> response) {
                if (response.isSuccessful()) {
                    singleMeetingListener.onSuccess(response.body());
                }
                else {
                    ErrorResponseParser parser = new ErrorResponseParser();
                    List<String> errorMessages = parser.parse(response);
                    for(String message: errorMessages) singleMeetingListener.onError(message);
                }
            }

            @Override
            public void onFailure(Call<Meeting> call, Throwable t) {
                singleMeetingListener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void setMeetingsListener(MeetingsListener listener) {
        this.meetingsListener = listener;
    }

    @Override
    public void setSingleMeetingListener(SingleMeetingListener listener) {
        this.singleMeetingListener = listener;
    }
}
