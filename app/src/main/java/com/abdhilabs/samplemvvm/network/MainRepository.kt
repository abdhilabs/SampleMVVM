package com.abdhilabs.samplemvvm.network

import com.abdhilabs.samplemvvm.model.ResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Buat Repository
 */

class MainRepository {

    private val apiService = ServiceRetrofit.create()
    private val compositeDisposable = CompositeDisposable()

    fun requestListPlace(onResult: (ResponseModel) -> Unit, onError: (Throwable) -> Unit) {
        apiService.getListPlace()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<ResponseModel>(compositeDisposable) {
                override fun onApiSuccess(data: ResponseModel) {
                    onResult(data)
                }

                override fun onApiError(e: Throwable) {
                    onError(e)
                }

            })
    }

    fun onDestroy() {
        compositeDisposable.clear()
    }
}