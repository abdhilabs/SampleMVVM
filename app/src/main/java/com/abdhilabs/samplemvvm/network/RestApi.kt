package com.abdhilabs.samplemvvm.network

import com.abdhilabs.samplemvvm.model.ResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {

    @GET("Sample.json")
    fun getListPlace():Observable<ResponseModel>
}