package com.itverse.futuris.mViewModels

import androidx.lifecycle.*
import com.itverse.futuris.data.entities.relations.GroupedElementsWithElements
import com.itverse.futuris.data.repositories.GroupedElementsWithElementsRepository
import java.lang.IllegalArgumentException



class GroupedElementsViewModel(private val repository: GroupedElementsWithElementsRepository): ViewModel()  {

    fun allGroupedElementsFrom(composantId: Long): LiveData<List<GroupedElementsWithElements>> {
        return repository.allComposantsWithElementsFrom(composantId).asLiveData()
    }
}


class GroupedElementsViewModelFactory(private val repository: GroupedElementsWithElementsRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GroupedElementsViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return GroupedElementsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}