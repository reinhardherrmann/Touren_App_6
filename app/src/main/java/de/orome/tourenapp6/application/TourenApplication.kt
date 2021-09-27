package de.orome.tourenapp6.application

import android.app.Application
import de.orome.tourenapp6.model.database.TourenDatabase
import de.orome.tourenapp6.model.repository.TourenRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * class to set up database, repositories and so forth to get them in the
 * whole application
 */

class TourenApplication: Application() {

   //val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { TourenDatabase.getDatabase(this@TourenApplication) }
    val repository by lazy { TourenRepository(database.tourDao()) }
}