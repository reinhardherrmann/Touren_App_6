package de.orome.tourenapp6.viewmodel

import android.app.Application
import androidx.lifecycle.*
import de.orome.tourenapp6.application.TourenApplication
import de.orome.tourenapp6.model.database.entities.Tour
import de.orome.tourenapp6.model.repository.TourenRepository
import kotlinx.coroutines.launch

class TourenViewModel(private val tourenRepository: TourenRepository, application: TourenApplication) : AndroidViewModel(
    application
) {


    // launch a new Coroutine to insert Tour
    fun insertTour(tour: Tour){
        viewModelScope.launch {
            tourenRepository.insertNewTour(tour)
        }
    }

    // ------------- füllt das Textfeld als Dummy. kann gelöscht werden -----------------
    private val _text = MutableLiveData<String>().apply {
        value = "This is all Touren Fragment"
    }
    val text: LiveData<String> = _text
}

class tourenViewModelFactory(private val repository: TourenRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TourenViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TourenViewModel(repository, TourenApplication()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}