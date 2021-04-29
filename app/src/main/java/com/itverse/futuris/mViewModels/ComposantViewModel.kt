package com.itverse.futuris.mViewModels

import androidx.lifecycle.*
import com.itverse.futuris.data.entities.Composant
import com.itverse.futuris.data.repositories.ComposantRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException


class ComposantViewModel(private val repository: ComposantRepository): ViewModel()  {

    fun allProjectComposants(projectId: Int): LiveData<List<Composant>> {
        return repository.allProjectComposants(projectId).asLiveData()
    }

    fun insert(composant: Composant) = viewModelScope.launch {
        repository.insert(composant)
    }
}


class ComposantViewModelFactory(private val repository: ComposantRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProjectViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ComposantViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}