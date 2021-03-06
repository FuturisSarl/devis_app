package com.itverse.futuris.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.itverse.futuris.data.entities.Composant
import kotlinx.coroutines.flow.Flow

@Dao
interface ComposantDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(composant: Composant): Long

    @Delete
    fun delete(composant: Composant)

    // Returns all composants of project with id `projectId`
    @Transaction
    @Query("SELECT * FROM composant_table WHERE projectId = :projectId")
    fun getAllFromProject(projectId: Long): Flow<List<Composant>>

    //TODO: remove this query as it's not really useful :)
    @Query("SELECT * FROM composant_table")
    fun getAll(): Flow<List<Composant>>
}