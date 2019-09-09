package com.abdhilabs.samplemvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseModel(

    @Expose
    @SerializedName("status_code")
    var statusCode: Int,

    @Expose
    @SerializedName("results")
    var data: MutableList<PlaceModel>
) {
    data class PlaceModel(
        @Expose
        @SerializedName("title")
        var name: String,

        @Expose
        @SerializedName("release_date")
        var location: String,

        @Expose
        @SerializedName("poster_path")
        var image: String
    )
}