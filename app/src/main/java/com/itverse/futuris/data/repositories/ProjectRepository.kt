package com.itverse.futuris.data.repositories

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.itverse.futuris.data.AppDatabase.Companion.getDatabase
import com.itverse.futuris.data.daos.ProjectDao
import com.itverse.futuris.data.entities.Project

class ProjectRepository internal constructor(application: Application?) {
    private val mProjectDao: ProjectDao?
    var allProjects: LiveData<List<Project?>?>?

    init {
        val database = getDatabase(application!!)
        mProjectDao = database!!.mProjectDao()
        allProjects = mProjectDao!!.getAllProjects()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(project: Project) {
        mProjectDao?.insertProject(project)
    }
}