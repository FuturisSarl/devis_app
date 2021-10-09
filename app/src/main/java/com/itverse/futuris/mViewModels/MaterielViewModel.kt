package com.itverse.futuris.mViewModels

import androidx.lifecycle.*
import com.itverse.futuris.data.entities.Materiel
import com.itverse.futuris.data.repositories.MaterielRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MaterielViewModel (private val repository: MaterielRepository): ViewModel(){

    suspend fun allMaterielsFrom (composantId: Long): LiveData<List<Materiel>> {
        return repository.allMaterielsFrom(composantId).asLiveData()
    }

    suspend fun allMaterielsFrom_ (composantId: Long): List<Materiel> {
        return repository.allMaterielsFrom_(composantId)
    }

    suspend fun insert(materiel: Materiel): Long {
        return repository.insert(materiel)
    }

    /*fun insert(materiel: Materiel) = viewModelScope.launch {
        repository.insert(materiel)
    }

     */


    fun increment(materielId: Long) = viewModelScope.launch{
        repository.increment(materielId)
    }

    fun decrement(materielId: Long) = viewModelScope.launch{
        repository.decrement(materielId)
    }
}


class MaterielViewModelFactory(private val repository: MaterielRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MaterielViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MaterielViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}