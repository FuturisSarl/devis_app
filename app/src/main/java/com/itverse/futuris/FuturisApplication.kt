package com.itverse.futuris

import android.app.Application
import com.itverse.futuris.data.AppDatabase
import com.itverse.futuris.data.repositories.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class FuturisApplication : Application() {
    // No need to cancel this scope as it'll be torn down with the process
    private val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { AppDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ProjectRepository(database.projectDao()) }
    val composantRepository by lazy { ComposantRepository(database.composantDao()) }
    val groupedElementsWithElementsRepository by lazy { GroupedElementsWithElementsRepository(database.groupedElementsDao()) }
    val materielRepository by lazy { MaterielRepository(database.materielDao()) }
    val elementRepository by lazy { ElementRepository(database.elementDao()) }
}
