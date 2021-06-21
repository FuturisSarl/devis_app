package com.itverse.futuris.mViewModels

import androidx.lifecycle.*
import com.itverse.futuris.data.entities.Composant
import com.itverse.futuris.data.repositories.ComposantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.lang.IllegalArgumentException


class ComposantViewModel(private val repository: ComposantRepository): ViewModel()  {

    suspend fun allComposantsFrom(projectId: Long): Flow<List<Composant>> {
        return repository.allComposantsFromProject(projectId)
    }

    suspend fun allComposantsFrom_(projectId: Long): List<Composant> {
        return repository.allComposantsFromProject_(projectId)
    }

    suspend fun insert(composant: Composant): Long {
        return repository.insert(composant)
    }
    /*fun insert(composant: Composant) = viewModelScope.launch {
        repository.insert(composant)
    }*/
}


class ComposantViewModelFactory(private val repository: ComposantRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ComposantViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ComposantViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}