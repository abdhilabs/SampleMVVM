package com.abdhilabs.samplemvvm.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.abdhilabs.samplemvvm.model.ResponseModel

class ItemPlaceViewModel(model: ResponseModel.PlaceModel) : ViewModel() {

    var title:ObservableField<String> = ObservableField()
    var location:ObservableField<String> = ObservableField()
    var image:ObservableField<String> = ObservableField()

    init {

        title.set(model.name)
        location.set(model.location)
        image.set(model.image)
    }
}