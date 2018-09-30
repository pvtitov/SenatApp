package ru.github.pvtitov.senatapp

import com.google.gson.Gson

import org.junit.Before
import org.junit.Test

import java.io.BufferedReader
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException

import ru.github.pvtitov.senatapp.pojos.Meeting

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GsonTest {

    private val json = StringBuilder()

    @Before
    fun readJsonFromFile() {
        val file = File("/home/pavel/StudioProjects/SenatApp/app/src/test/java/ru/github/pvtitov/senatapp/meeting.json")
        try {
            BufferedReader(FileReader(file)).use { reader ->
                for (line in reader.readLines()) {
                    json.append(line)
                }
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    @Test
    fun givenJsonMeeting_whenDeserialize_thenEveryFieldConverted() {


        val meeting = Gson().fromJson(json.toString(), Meeting::class.java)

        assertEquals("Increase in the interest rate on consumer loans", meeting.agenda!![0].title)
        assertEquals("COMMITTEE SECRETARY", meeting.participants!![1].lastName)
        assertEquals("Moscow, Vavilova street, 19", meeting.address)
    }
}
