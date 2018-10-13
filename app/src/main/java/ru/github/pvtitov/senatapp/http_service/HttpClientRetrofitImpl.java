package ru.github.pvtitov.senatapp.http_service;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.github.pvtitov.senatapp.App;
import ru.github.pvtitov.senatapp.pojos.Meeting;
import ru.github.pvtitov.senatapp.pojos.Meetings;

public class HttpClientRetrofitImpl implements HttpClient {

    @Inject MainService service;
    private HttpResponseListener responseListener;

    public HttpClientRetrofitImpl() {
        service = App.getComponent().mainService();
    }

    @Override
    public void requestMeetingsList() {
        service.meetings().enqueue(new Callback<Meetings>() {
            @Override
            public void onResponse(Call<Meetings> call, Response<Meetings> response) {
                if (response == null) return;
                if (response.isSuccessful()) {
                    responseListener.onSuccess(response.body());
                }
                else {
                    ErrorResponseParser parser = new ErrorResponseParser();
                    List<String> errorMessages = parser.parse(response);
                    for(String message: errorMessages) responseListener.onError(message);
                }
            }

            @Override
            public void onFailure(Call<Meetings> call, Throwable t) {
                responseListener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void requestMeeting(String id) {
        service.meeting(id).enqueue(new Callback<Meeting>() {
            @Override
            public void onResponse(Call<Meeting> call, Response<Meeting> response) {
                if (response.isSuccessful()) {
                    responseListener.onSuccess(response.body());
                }
                else {
                    ErrorResponseParser parser = new ErrorResponseParser();
                    List<String> errorMessages = parser.parse(response);
                    for(String message: errorMessages) responseListener.onError(message);
                }
            }

            @Override
            public void onFailure(Call<Meeting> call, Throwable t) {
                responseListener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void setHttpResponseListener(@NotNull HttpResponseListener listener) {
        responseListener = listener;
    }
}
