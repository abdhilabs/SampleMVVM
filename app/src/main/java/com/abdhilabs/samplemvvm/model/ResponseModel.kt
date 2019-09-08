package com.abdhilabs.samplemvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseModel(

    @Expose
    @SerializedName("status_code")
    var statusCode: Int,

    @Expose
    @SerializedName("data")
    var data: MutableList<PlaceModel>

) {
    data class PlaceModel(
        @Expose
        @SerializedName("name")
        var name: String,

        @Expose
        @SerializedName("location")
        var location: String,

        @Expose
        @SerializedName("image")
        var image: String
    )
}