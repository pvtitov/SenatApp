package ru.github.pvtitov.senatapp.pojos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Protocol {

    @SerializedName("name")
    @Expose
    var name: String = ""
    @SerializedName("category")
    @Expose
    var category: String = ""
    @SerializedName("currentVersion")
    @Expose
    var currentVersion: CurrentVersion? = null
    @SerializedName("id")
    @Expose
    var id: String = ""

}