package ru.github.pvtitov.senatapp.http_service

import com.google.gson.Gson
import ru.github.pvtitov.senatapp.pojos.Item

import java.io.BufferedReader
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException

import ru.github.pvtitov.senatapp.pojos.Meeting
import ru.github.pvtitov.senatapp.pojos.Meetings

class DummyHttpClient(private val httpResponseListener: HttpClient.HttpResponseListener) : HttpClient {

    override fun requestMeetingsList() {
        val meetingsContainer = Meetings()
        val itemsList = ArrayList<Item>()
        for (i in 0..9) {
            val item = Item()
            item.id = "id-$i"
            itemsList.add(item)
        }
        meetingsContainer.items = itemsList
    }

    override fun requestMeeting(id: String) {
        val file = File("/home/pavel/AndroidStudioProjects/SenatApp/app/src/test/java/ru/github/pvtitov/senatapp/meeting.json")
        try {
            BufferedReader(FileReader(file)).use { reader ->
                val responseJson = StringBuilder()
                for (line in reader.readLines()) {
                    responseJson.append(line)
                }
                val meeting = Gson().fromJson(responseJson.toString(), Meeting::class.java)
                httpResponseListener.onSuccess(meeting)
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}
