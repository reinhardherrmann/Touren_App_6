package de.orome.tourenapp6.model.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import de.orome.tourenapp6.model.database.entities.Tour
import kotlinx.coroutines.flow.Flow

@Dao
interface TourDao {

    @Insert
    suspend fun insertInitialTour(tour: Tour)

    @Query("SELECT * FROM tbl_touren order by tour_datum DESC LIMIT 10")
    fun getTop10Touren(): Flow<List<Tour>>
}