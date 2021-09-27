package de.orome.tourenapp6.model.database.daos

import androidx.room.Dao
import androidx.room.Insert
import de.orome.tourenapp6.model.database.entities.Tour

@Dao
interface TourDao {

    @Insert
    suspend fun insertInitialTour(tour: Tour)
}