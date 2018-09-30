package ru.github.pvtitov.senatapp.pojos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Holding {

    @SerializedName("name")
    @Expose
    var name: String = ""
    @SerializedName("id")
    @Expose
    var id: String = ""

}
