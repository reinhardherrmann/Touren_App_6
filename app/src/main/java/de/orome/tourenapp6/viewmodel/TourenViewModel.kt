package de.orome.tourenapp6.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TourenViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is all Touren Fragment"
    }
    val text: LiveData<String> = _text
}