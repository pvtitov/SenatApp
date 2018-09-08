package ru.github.pvtitov.senatapp.http_service;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import ru.github.pvtitov.senatapp.App;
import ru.github.pvtitov.senatapp.pojos.AuthError;

public class ErrorResponseParser {

    public List<String> parse(Response<?> response){
        Converter<ResponseBody, AuthError> errorConverter = App.getRetrofit().responseBodyConverter(AuthError.class, new Annotation[0]);
        AuthError error;
        try {
            if (response.errorBody() != null) {
                error = errorConverter.convert(response.errorBody());
                List<String> messages = new ArrayList<>();
                for(AuthError e: error.getErrors()) messages.add(e.getMessage());
                return messages;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
