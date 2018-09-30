package ru.github.pvtitov.senatapp.pojos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.text.ParseException
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class Item {

    @SerializedName("_type")
    @Expose
    var type: String = ""
    @SerializedName("date")
    @Expose
    var date: String = ""
    @SerializedName("id")
    @Expose
    var id: String = ""
    @SerializedName("num")
    @Expose
    var num: String = ""
    @SerializedName("holding")
    @Expose
    var holding: Holding? = null
    @SerializedName("collegialBody")
    @Expose
    var collegialBody: CollegialBody? = null
    @SerializedName("status")
    @Expose
    var status: String = ""
    @SerializedName("voting")
    @Expose
    var voting: Voting? = null
    @SerializedName("hasProtocol")
    @Expose
    var isHasProtocol: Boolean = false
    @SerializedName("createDate")
    @Expose
    var createDate: String = ""
    @SerializedName("startDate")
    @Expose
    var startDate: String = ""
    @SerializedName("endDate")
    @Expose
    var endDate: String = ""

}
