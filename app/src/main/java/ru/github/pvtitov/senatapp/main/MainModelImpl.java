package ru.github.pvtitov.senatapp.main;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.github.pvtitov.senatapp.App;
import ru.github.pvtitov.senatapp.http_service.ErrorResponseParser;
import ru.github.pvtitov.senatapp.http_service.MeetingService;
import ru.github.pvtitov.senatapp.pojos.Meeting;

public class MainModelImpl implements MainModel {

    private MeetingListener meetingListener;
    private MeetingService service = App.getRetrofit().create(MeetingService.class);

    @Override
    public Meeting downloadMeeting() {
        service.meeting().enqueue(new Callback<Meeting>() {
            @Override
            public void onResponse(Call<Meeting> call, Response<Meeting> response) {
                if (response.isSuccessful()) {
                    meetingListener.onSuccess(response.body());
                }
                else {
                    ErrorResponseParser parser = new ErrorResponseParser();
                    List<String> errorMessages = parser.parse(response);
                    for(String message: errorMessages) meetingListener.onError(message);
                }
            }

            @Override
            public void onFailure(Call<Meeting> call, Throwable t) {
                Log.d("happy", t.getStackTrace().toString());
                t.printStackTrace();
            }
        });
        return null;
    }


    @Override
    public void setMeetingListener(MeetingListener listener) {
        this.meetingListener = listener;
    }
}
