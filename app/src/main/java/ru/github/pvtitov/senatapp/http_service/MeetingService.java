package ru.github.pvtitov.senatapp.http_service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.github.pvtitov.senatapp.pojos.Meeting;

public interface MeetingService {

    @GET("api/v2/meetings")
    Call<List<Meeting>> meetings();

    @GET("api/v2/meeting/{id}")
    Call<Meeting> meeting(@Path("id") String id);
}
