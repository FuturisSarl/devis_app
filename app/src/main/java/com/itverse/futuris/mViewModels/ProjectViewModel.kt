package com.itverse.futuris.mViewModels

import androidx.lifecycle.*
import com.itverse.futuris.data.entities.Project
import com.itverse.futuris.data.entities.relations.ProjectWithComposants
import com.itverse.futuris.data.repositories.ProjectRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ProjectViewModel (private val repository: ProjectRepository): ViewModel(){

    // Using LiveData and caching what allProjects returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allProjects: LiveData<List<Project>> = repository.allProjects.asLiveData()

    suspend fun get(projectId: Long): Project {
        return repository.get(projectId)
    }
    suspend fun insert(project: Project): Long {
        return repository.insert(project)
    }

}


class ProjectViewModelFactory(private val repository: ProjectRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProjectViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ProjectViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}