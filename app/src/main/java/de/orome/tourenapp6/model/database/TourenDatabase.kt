package de.orome.tourenapp6.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.orome.tourenapp6.model.database.daos.TourDao
import de.orome.tourenapp6.model.database.entities.Tour

// Annotates class to be a Room Database with a table (entity) of the Touren class
@Database(entities = arrayOf(Tour::class), version = 1, exportSchema = false)
public abstract class TourenDatabase : RoomDatabase() {

    abstract fun tourDao(): TourDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: TourenDatabase? = null

        fun getDatabase(context: Context): TourenDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        TourenDatabase::class.java,
                        "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
