package ru.github.pvtitov.senatapp

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

import ru.github.pvtitov.senatapp.http_service.HttpClient
import ru.github.pvtitov.senatapp.http_service.HttpClientRetrofitImpl
import ru.github.pvtitov.senatapp.main.MainModelImpl
import ru.github.pvtitov.senatapp.mvp.MainMvpContract

@RunWith(MockitoJUnitRunner::class)
class HttpClientTest {

    private val mockedHttpClient = Mockito.mock(HttpClientRetrofitImpl::class.java)

    @Test
    fun httpClient_WhenModelDownloadMeetings_ThenHttpClientSendsRequest() {
        val model = MainModelImpl(mockedHttpClient)

        model.downloadMeetings()
        model.downloadSingleMeeting(Mockito.anyString())

        Mockito.verify<HttpClient>(mockedHttpClient).requestMeetingsList()
        Mockito.verify<HttpClient>(mockedHttpClient).requestMeeting(Mockito.anyString())
    }
}
