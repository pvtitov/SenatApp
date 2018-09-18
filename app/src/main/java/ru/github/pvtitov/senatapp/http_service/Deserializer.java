package ru.github.pvtitov.senatapp.http_service;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class Deserializer<T> implements JsonDeserializer<T> {

    public Deserializer(String elementName) {
        super();
        this.elementName = elementName;
    }

    private String elementName;
    private Gson gson = new Gson();

    @Override
    public T deserialize(JsonElement rootElement, Type type, JsonDeserializationContext context) throws JsonParseException {

        JsonElement element = rootElement.getAsJsonObject().get(elementName);
        return gson.fromJson(element, type);
    }
}