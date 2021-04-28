package com.itverse.futuris.viewModels

import android.app.Application
import androidx.lifecycle.*
import com.itverse.futuris.data.AppDatabase
import com.itverse.futuris.data.entities.Project
import com.itverse.futuris.data.repositories.ProjectRepository
import kotlinx.coroutines.launch

class ProjectViewModel (application: Application): AndroidViewModel(application)  {

    private val allProjects: LiveData<List<Project?>?>?
    private  val repository: ProjectRepository

    init {
        val projectDao = AppDatabase.getDatabase(application)?.mProjectDao()
        repository = ProjectRepository(application)
        allProjects = repository.allProjects
    }
    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(project: Project) = viewModelScope.launch {
        repository.insert(project)
    }
}
