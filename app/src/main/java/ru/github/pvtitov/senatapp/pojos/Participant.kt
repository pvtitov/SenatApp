package ru.github.pvtitov.senatapp.pojos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Participant {

    @SerializedName("role")
    @Expose
    var role: String = ""
    @SerializedName("firstName")
    @Expose
    var firstName: String = ""
    @SerializedName("lastName")
    @Expose
    var lastName: String = ""
    @SerializedName("middleName")
    @Expose
    var middleName: String = ""
    @SerializedName("id")
    @Expose
    var id: String = ""

}