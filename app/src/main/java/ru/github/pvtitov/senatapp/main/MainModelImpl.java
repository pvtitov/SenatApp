package ru.github.pvtitov.senatapp.main;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.github.pvtitov.senatapp.App;
import ru.github.pvtitov.senatapp.http_service.MeetingService;
import ru.github.pvtitov.senatapp.pojos.Meeting;

public class MainModelImpl implements MainModel {

    @Override
    public List<Meeting> downloadMeetings() {
        MeetingService service = App.getRetrofit().create(MeetingService.class);
        service.meetings().enqueue(new Callback<List<Meeting>>() {
            @Override
            public void onResponse(Call<List<Meeting>> call, Response<List<Meeting>> response) {

            }

            @Override
            public void onFailure(Call<List<Meeting>> call, Throwable t) {

            }
        });
        return null;
    }

    @Override
    public Meeting downloadMeeting(String id) {
        return null;
    }

    @Override
    public void setDownloadListener(DownloadListener downloadListener) {

    }
}
