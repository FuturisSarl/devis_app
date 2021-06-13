package com.itverse.futuris.mViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.itverse.futuris.data.entities.Materiel
import com.itverse.futuris.data.entities.relations.GroupedElementsWithElements
import com.itverse.futuris.data.repositories.ElementRepository
import com.itverse.futuris.data.repositories.GroupedElementsWithElementsRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ElementViewModel(private val repository: ElementRepository): ViewModel()  {

    fun update(elementId: Long, value: Int) = viewModelScope.launch {
        repository.update(elementId, value)
    }
}


class ElementViewModelFactory(private val repository: ElementRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ElementViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ElementViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}