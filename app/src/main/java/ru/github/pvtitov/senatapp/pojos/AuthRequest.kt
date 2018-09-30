package ru.github.pvtitov.senatapp.pojos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuthRequest {

    @SerializedName("username")
    @Expose
    private var username: String = ""
    @SerializedName("password")
    @Expose
    private var password: String = ""
    @SerializedName("rememberMe")
    @Expose
    private var rememberMe: Boolean = false

    fun getUsername(): String? {
        return username
    }

    fun setUsername(username: String): AuthRequest {
        this.username = username
        return this
    }

    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String): AuthRequest {
        this.password = password
        return this
    }

    fun isRememberMe(): Boolean {
        return rememberMe
    }

    fun setRememberMe(rememberMe: Boolean): AuthRequest {
        this.rememberMe = rememberMe
        return this
    }

}
