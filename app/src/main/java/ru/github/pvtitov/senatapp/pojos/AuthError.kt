package ru.github.pvtitov.senatapp.pojos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import ru.github.pvtitov.senatapp.http_service.HttpClient

class AuthError {

    @SerializedName("key")
    @Expose
    var key: String = ""
    @SerializedName("message")
    @Expose
    var message: String = ""

    @SerializedName("errors")
    @Expose
    var errors: List<AuthError>? = null
}