package de.orome.tourenapp6.model.repository

import androidx.annotation.WorkerThread
import de.orome.tourenapp6.model.database.daos.TourDao
import de.orome.tourenapp6.model.database.entities.Tour
import kotlinx.coroutines.flow.Flow

class TourenRepository(private val tourDao: TourDao) {

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertNewTour(tour: Tour) {
        tourDao.insertInitialTour(tour)
    }

    val getTop10TourenList: Flow<List<Tour>> = tourDao.getTop10Touren()
}