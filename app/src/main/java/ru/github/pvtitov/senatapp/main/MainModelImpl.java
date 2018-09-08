package ru.github.pvtitov.senatapp.main;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.github.pvtitov.senatapp.App;
import ru.github.pvtitov.senatapp.http_service.ErrorResponseParser;
import ru.github.pvtitov.senatapp.http_service.HttpResponseListener;
import ru.github.pvtitov.senatapp.http_service.MeetingService;
import ru.github.pvtitov.senatapp.pojos.Meeting;

public class MainModelImpl implements MainModel {

    private HttpResponseListener<List<Meeting>> meetingsListener;
    private HttpResponseListener<Meeting> meetingListener;
    private MeetingService service = App.getRetrofit().create(MeetingService.class);

    @Override
    public List<Meeting> downloadMeetings() {
        service.meetings().enqueue(new Callback<List<Meeting>>() {
            @Override
            public void onResponse(Call<List<Meeting>> call, Response<List<Meeting>> response) {
                if (response.isSuccessful()) {
                    meetingsListener.onSuccess(response);
                }
                else {
                    ErrorResponseParser parser = new ErrorResponseParser();
                    parser.extractMessages(response, meetingsListener);
                }
            }

            @Override
            public void onFailure(Call<List<Meeting>> call, Throwable t) {

            }
        });
        return null;
    }

    @Override
    public Meeting downloadMeeting(String id) {
        service.meeting(id).enqueue(new Callback<Meeting>() {
            @Override
            public void onResponse(Call<Meeting> call, Response<Meeting> response) {
                if (response.isSuccessful()) {
                    meetingListener.onSuccess(response);
                }
                else {
                    ErrorResponseParser parser = new ErrorResponseParser();
                    parser.extractMessages(response, meetingListener);
                }
            }

            @Override
            public void onFailure(Call<Meeting> call, Throwable t) {

            }
        });
        return null;
    }

    @Override
    public void setMeetingsListener(HttpResponseListener<List<Meeting>> listener) {
        this.meetingsListener = listener;
    }

    @Override
    public void setMeetingListener(HttpResponseListener<Meeting> listener) {
        this.meetingListener = listener;
    }
}
