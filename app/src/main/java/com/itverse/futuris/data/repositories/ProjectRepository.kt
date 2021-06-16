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

    suspend fun insert(project: Project): Long {
        return projectDao.insert(project)
    }
}