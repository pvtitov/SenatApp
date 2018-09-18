package ru.github.pvtitov.senatapp;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ru.github.pvtitov.senatapp.pojos.Meeting;

import static org.junit.Assert.*;

public class GsonTest {

    private StringBuilder json = new StringBuilder();

    @Before
    public void readJsonFromFile() {
        File file = new File("/home/pavel/AndroidStudioProjects/SenatApp/app/src/test/java/ru/github/pvtitov/senatapp/meeting.json");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenJsonMeeting_whenDeserialize_thenEveryFieldConverted() {


        Meeting meeting = new Gson().fromJson(json.toString(), Meeting.class);

        assertEquals("Increase in the interest rate on consumer loans", meeting.getAgenda().get(0).getTitle());
        assertEquals("COMMITTEE SECRETARY", meeting.getParticipants().get(1).getLastName());
        //assertEquals("Moscow, Vavilova street, 19", meeting.getAddress());
    }
}
