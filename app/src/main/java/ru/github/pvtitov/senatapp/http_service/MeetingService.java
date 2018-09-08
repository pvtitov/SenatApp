package ru.github.pvtitov.senatapp.http_service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import ru.github.pvtitov.senatapp.pojos.Meeting;

public interface MeetingService {

    @GET("api/v2.0/meetings")
    Call<Meeting> meeting();

    @GET("api/v2.0/meeting/{id}")
    Call<Meeting> meeting(@Path("id") String id);
}
