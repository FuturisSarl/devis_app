package com.itverse.futuris.data.repositories

import androidx.annotation.WorkerThread
import com.itverse.futuris.data.daos.ProjectDao
import com.itverse.futuris.data.entities.Project
import kotlinx.coroutines.flow.Flow

/**
 * Abstracted Repository as promoted by the Architecture Guide.
 * https://developer.android.com/topic/libraries/architecture/guide.html
 */
class ProjectRepository (private val projectDao: ProjectDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allProjects: Flow<List<Project>> = projectDao.getAll()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(project: Project) {
        projectDao.insert(project)
    }
}