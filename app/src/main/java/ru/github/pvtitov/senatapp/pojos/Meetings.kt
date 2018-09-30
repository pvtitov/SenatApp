package ru.github.pvtitov.senatapp.pojos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Meetings {

    @SerializedName("pageNum")
    @Expose
    var pageNum: Int = 0
    @SerializedName("pageSize")
    @Expose
    var pageSize: Int = 0
    @SerializedName("items")
    @Expose
    var items: List<Item>? = null
    @SerializedName("itemsTotal")
    @Expose
    var itemsTotal: Int = 0
}