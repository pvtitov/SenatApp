package ru.github.pvtitov.senatapp.http_service;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ru.github.pvtitov.senatapp.pojos.Meeting;

public class DummyHttpClient implements HttpClient {

    public DummyHttpClient(HttpResponseListener httpResponseListener) {
        this.httpResponseListener = httpResponseListener;
    }

    private HttpResponseListener httpResponseListener;

    @Override
    public void requestMeetingsList() {
        requestMeeting("");
    }

    @Override
    public void requestMeeting(String id) {
        File file = new File("/home/pavel/AndroidStudioProjects/SenatApp/app/src/test/java/ru/github/pvtitov/senatapp/meeting.json");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder responseJson = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseJson.append(line);
            }
            Meeting meeting = new Gson().fromJson(responseJson.toString(), Meeting.class);
            httpResponseListener.onSuccess(meeting);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
