package de.orome.tourenapp6.model.repository

import android.app.Application
import androidx.lifecycle.LiveData
import de.orome.tourenapp6.model.database.TourenDatabase
import de.orome.tourenapp6.model.database.daos.TourDao
import de.orome.tourenapp6.model.database.entities.Tour
import de.orome.tourenapp6.viewmodel.tourenViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TourenDetailRepository(application: Application) {

    private var tourDao: TourDao


    init {
        var touren_db = TourenDatabase.getDatabase(application)
        tourDao = touren_db.tourDao()
    }

    // Methoden zur Bearbeitung der Tourdaten
    suspend fun updateTour(tour: Tour){
        withContext(Dispatchers.IO){
            tourDao.updateTour(tour)
        }
    }

    suspend fun getTourByNumber(tourNummer: String): Tour?{
        var tour: Tour? = null
        withContext(Dispatchers.IO){
            tour = tourDao.getTourByNumber(tourNummer)
        }
        return tour
    }

}