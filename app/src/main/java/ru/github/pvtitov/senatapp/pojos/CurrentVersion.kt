package ru.github.pvtitov.senatapp.pojos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CurrentVersion {

    @SerializedName("version")
    @Expose
    var version: Int = 0
    @SerializedName("fileName")
    @Expose
    var fileName: String = ""
    @SerializedName("createdBy")
    @Expose
    var createdBy: CreatedBy? = null
    @SerializedName("createdAt")
    @Expose
    var createdAt: String = ""
    @SerializedName("size")
    @Expose
    var size: Int = 0
    @SerializedName("encrypted")
    @Expose
    var isEncrypted: Boolean = false

}
