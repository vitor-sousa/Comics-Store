package com.vitorsousa.comicsstore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vitorsousa.comicsstore.HQDetails.HQDetails
import com.vitorsousa.comicsstore.placeholder.PlaceholderContent
import com.vitorsousa.comicsstore.utils.SingleLiveData

class HQViewModel: ViewModel() {

    val hqDetailsLiveData: LiveData<HQDetails>
        get() = _hqDetailsLiveData
    private val _hqDetailsLiveData = MutableLiveData<HQDetails>()

    val hqListLiveData: LiveData<MutableList<PlaceholderContent.PlaceholderItem>>
        get() = _hqListLiveData
    private val _hqListLiveData = MutableLiveData<MutableList<PlaceholderContent.PlaceholderItem>>()

    val navigationToDetailsLive: LiveData<Unit>
        get() = _navigationToDetailsLive
    private val _navigationToDetailsLive = SingleLiveData<Unit>()



    init {
        _hqListLiveData.postValue(PlaceholderContent.ITEMS)
    }


    fun onHQSelected(position: Int) {
        _hqDetailsLiveData.postValue(HQDetails ("Minha HQ 2", "2 - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
        _navigationToDetailsLive.postValue(Unit)
    }


}