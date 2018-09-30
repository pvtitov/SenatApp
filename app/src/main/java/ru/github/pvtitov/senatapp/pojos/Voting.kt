package ru.github.pvtitov.senatapp.pojos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Voting {

    @SerializedName("id")
    @Expose
    var id: String = ""
    @SerializedName("for")
    @Expose
    var `for`: Int = 0
    @SerializedName("against")
    @Expose
    var against: Int = 0
    @SerializedName("abstain")
    @Expose
    var abstain: Int = 0
    @SerializedName("veto")
    @Expose
    var veto: Int = 0

}
