package com.itverse.futuris.data.repositories

import androidx.annotation.WorkerThread
import com.itverse.futuris.data.daos.ComposantDao
import com.itverse.futuris.data.entities.Composant
import kotlinx.coroutines.flow.Flow

class ComposantRepository (private val composantDao: ComposantDao){

    fun allComposantsFrom(projectId: Long): Flow<List<Composant>> {
        return composantDao.getAllFromProject(projectId)
    }

    suspend fun insert(composant: Composant): Long {
        return composantDao.insert(composant)
    }
}
