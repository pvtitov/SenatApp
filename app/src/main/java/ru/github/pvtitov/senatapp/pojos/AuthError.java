package ru.github.pvtitov.senatapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.github.pvtitov.senatapp.http_service.HttpClient;

public class AuthError {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("errors")
    @Expose
    private List<AuthError> errors = null;

    public List<AuthError> getErrors() {
        return errors;
    }

    public void setErrors(List<AuthError> errors) {
        this.errors = errors;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}