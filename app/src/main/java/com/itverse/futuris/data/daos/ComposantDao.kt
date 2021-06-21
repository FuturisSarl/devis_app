package com.itverse.futuris.data.daos

import androidx.room.*
import com.itverse.futuris.data.entities.Composant
import kotlinx.coroutines.flow.Flow

@Dao
interface ComposantDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(composant: Composant): Long

    @Delete
    fun delete(composant: Composant)

    @Transaction
    @Query("SELECT * FROM composant_table WHERE projectId = :projectId")
    fun getAllComposantsFromProject(projectId: Long): Flow<List<Composant>>

    @Transaction
    @Query("SELECT * FROM composant_table WHERE projectId = :projectId")
    suspend fun getAllComposantsFromProject_(projectId: Long): List<Composant>

    //TODO: remove this query as it's not really useful :)
    @Query("SELECT * FROM composant_table")
    fun getAll(): Flow<List<Composant>>
}