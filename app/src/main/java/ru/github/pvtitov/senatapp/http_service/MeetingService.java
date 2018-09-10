package ru.github.pvtitov.senatapp.http_service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.github.pvtitov.senatapp.pojos.Meeting;
import ru.github.pvtitov.senatapp.pojos.Meetings;

public interface MeetingService {

    @GET("api/v2.0/meetings")
    Call<Meetings> meetings();

    @GET("api/v2.0/meetings/{id}")
    Call<Meeting> meeting(@Path("id") String id);
}
