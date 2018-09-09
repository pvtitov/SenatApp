package ru.github.pvtitov.senatapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthRequest {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("rememberMe")
    @Expose
    private boolean rememberMe;

    public String getUsername() {
        return username;
    }

    public AuthRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public AuthRequest setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
        return this;
    }

}
