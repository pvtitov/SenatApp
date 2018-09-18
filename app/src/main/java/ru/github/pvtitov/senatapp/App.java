package ru.github.pvtitov.senatapp;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.github.pvtitov.senatapp.http_service.AddCookiesInterceptor;
import ru.github.pvtitov.senatapp.http_service.Deserializer;
import ru.github.pvtitov.senatapp.pojos.Agenda;
import ru.github.pvtitov.senatapp.pojos.CollegialBody;
import ru.github.pvtitov.senatapp.pojos.Head;
import ru.github.pvtitov.senatapp.pojos.Holding;
import ru.github.pvtitov.senatapp.pojos.Participant;
import ru.github.pvtitov.senatapp.pojos.Secretary;
import ru.github.pvtitov.senatapp.pojos.Voting;

public class App extends Application {

    public static final String COOKIES = "ru.github.pvtitov.senatapp.COOKIES";

    private static Retrofit retrofit;
    private static SharedPreferences sharedPreferences;

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AddCookiesInterceptor())
                .build();

        Gson gson = new GsonBuilder()
                //.registerTypeAdapter(Voting.class, new Deserializer<Voting>("voting"))
                //.registerTypeAdapter(Holding.class, new Deserializer<Holding>("holding"))
                .registerTypeAdapter(CollegialBody.class, new Deserializer<CollegialBody>("collegialBody"))
                //.registerTypeAdapter(Head.class, new Deserializer<Head>("head"))
                //.registerTypeAdapter(Secretary.class, new Deserializer<Secretary>("secretary"))
                //.registerTypeAdapter(Participant.class, new Deserializer<List<Participant>>("participant"))
                //.registerTypeAdapter(Agenda.class, new Deserializer<List<Agenda>>("agenda"))
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://senat.azurewebsites.net/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
