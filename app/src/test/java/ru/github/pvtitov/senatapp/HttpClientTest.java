package ru.github.pvtitov.senatapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import ru.github.pvtitov.senatapp.http_service.HttpClient;
import ru.github.pvtitov.senatapp.http_service.HttpClientRetrofitImpl;
import ru.github.pvtitov.senatapp.main.MainModelImpl;
import ru.github.pvtitov.senatapp.mvp.MainMvpContract;

@RunWith(MockitoJUnitRunner.class)
public class HttpClientTest {

    private HttpClient mockedHttpClient = Mockito.mock(HttpClientRetrofitImpl.class);

    @Test
    public void httpClient_WhenModelDownloadMeetings_ThenHtttpClientSendsRequest() {
        MainMvpContract.MainModel model = new MainModelImpl(mockedHttpClient);

        model.downloadMeetings();
        model.downloadSingleMeeting(Mockito.anyString());

        Mockito.verify(mockedHttpClient).requestMeetingsList();
        Mockito.verify(mockedHttpClient).requestMeeting(Mockito.anyString());
    }
}
