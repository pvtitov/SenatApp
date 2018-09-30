package ru.github.pvtitov.senatapp.pojos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Meeting {

    @SerializedName("id")
    @Expose
    var id: String = ""
    @SerializedName("num")
    @Expose
    var num: String = ""
    @SerializedName("status")
    @Expose
    var status: String = ""
    @SerializedName("type")
    @Expose
    var type: String = ""
    @SerializedName("date")
    @Expose
    var date: String = ""
    @SerializedName("createDate")
    @Expose
    var createDate: String = ""
    @SerializedName("address")
    @Expose
    var address: String = ""
    @SerializedName("head")
    @Expose
    var head: Head? = null
    @SerializedName("secretary")
    @Expose
    var secretary: Secretary? = null
    @SerializedName("agenda")
    @Expose
    var agenda: List<Agenda>? = null
    @SerializedName("participants")
    @Expose
    var participants: List<Participant>? = null
    @SerializedName("collegialBody")
    @Expose
    var collegialBody: CollegialBody? = null
    @SerializedName("hasProtocol")
    @Expose
    var isHasProtocol: Boolean = false
}
