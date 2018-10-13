package ru.github.pvtitov.senatapp.http_service

import ru.github.pvtitov.senatapp.pojos.Item
import ru.github.pvtitov.senatapp.pojos.Meeting
import ru.github.pvtitov.senatapp.pojos.Meetings

interface HttpClient {

    fun requestMeetingsList()
    fun requestMeeting(id: String)
    fun setHttpResponseListener(listener: HttpClient.HttpResponseListener)

    interface HttpResponseListener {
        fun onSuccess(meetings: Meetings)
        fun onSuccess(meeting: Meeting)
        fun onError(message: String)
    }
}
