package ru.github.pvtitov.senatapp.pojos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Agenda {

    @SerializedName("id")
    @Expose
    var id: String = ""
    @SerializedName("order")
    @Expose
    var order: Int = 0
    @SerializedName("title")
    @Expose
    var title: String = ""
    @SerializedName("description")
    @Expose
    var description: String = ""
    @SerializedName("author")
    @Expose
    var author: Author? = null
    @SerializedName("status")
    @Expose
    var status: String = ""

}
