package com.abdhilabs.samplemvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.abdhilabs.samplemvvm.model.ResponseModel
import com.abdhilabs.samplemvvm.network.MainRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MainRepository()

    var listPlace: MutableLiveData<ResponseModel> = MutableLiveData()
    var error: MutableLiveData<Throwable> = MutableLiveData()

    fun getListPlace() {
        repository.requestListPlace({
            listPlace.postValue(it)
        }, {
            error.postValue(it)
        })
    }

    override fun onCleared() {
        super.onCleared()
        repository.onDestroy()
    }
}