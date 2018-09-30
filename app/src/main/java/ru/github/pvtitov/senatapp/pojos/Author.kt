package ru.github.pvtitov.senatapp.pojos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Author {

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