package de.orome.tourenapp6.model.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.orome.tourenapp6.model.database.entities.Tour
import kotlinx.coroutines.flow.Flow

@Dao
interface TourDao {

    @Insert
    suspend fun insertInitialTour(tour: Tour)

    @Update
    suspend fun updateTour(tour: Tour)

    @Query("SELECT * FROM tbl_touren order by tour_datum DESC LIMIT 10")
    fun getTop10Touren(): Flow<List<Tour>>

    @Query("SELECT * FROM tbl_touren WHERE tour_nummer LIKE :tourNummer")
    suspend fun getTourByNumber(tourNummer: String): Tour?
}