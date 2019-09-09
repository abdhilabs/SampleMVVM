package com.abdhilabs.samplemvvm.network

import com.abdhilabs.samplemvvm.model.ResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Buat API nya
 */

interface RestApi {

    @GET("movie/now_playing?api_key=995351073e521ebe15db309b37cc0ca2&language=en-US")
    fun getListPlace():Observable<ResponseModel>
}