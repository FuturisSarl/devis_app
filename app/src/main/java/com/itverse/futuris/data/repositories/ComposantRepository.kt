package com.itverse.futuris.data.repositories

import androidx.annotation.WorkerThread
import com.itverse.futuris.data.daos.ComposantDao
import com.itverse.futuris.data.entities.Composant
import kotlinx.coroutines.flow.Flow

class ComposantRepository (private val composantDao: ComposantDao){

    fun allComposantsFromProject(projectId: Long): Flow<List<Composant>> {
        return composantDao.getAllComposantsFromProject(projectId)
    }

    suspend fun allComposantsFromProject_(projectId: Long): List<Composant> {
        return composantDao.getAllComposantsFromProject_(projectId)
    }

    suspend fun insert(composant: Composant): Long {
        return composantDao.insert(composant)
    }
}
