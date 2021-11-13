package de.orome.tourenapp6.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import de.orome.tourenapp6.helper.Helper
import de.orome.tourenapp6.model.database.entities.Tour
import de.orome.tourenapp6.model.repository.TourenDetailRepository
import kotlinx.coroutines.launch

/**
 * ViewModel mit allen Zugriffen auf TourDaten, Userdaten Fahrzeugdaten Märkte und Stopps
 * Stellt Werte für TabLayout und Fragemnts zur Verfügung
 */


class TourenDetailViewModel(application: Application): AndroidViewModel(application) {

    private var context = application
    private var helper = Helper()
    private var tourenDetailRepository = TourenDetailRepository(application)


    ///////////////////////////////////////////////////////////////////
    // Funktionen, um auf Tourdaten zuzgreifen
    fun updateTour(tour: Tour){
        viewModelScope.launch {
            tourenDetailRepository.updateTour(tour)
        }
    }

    fun getTourByNumber(tourNummer: String): Tour?{
        var tour: Tour? = null
        viewModelScope.launch {
            tour = tourenDetailRepository.getTourByNumber(tourNummer)
        }
        return tour
    }


    ///////////////////////////////////////////////////////////////////

}