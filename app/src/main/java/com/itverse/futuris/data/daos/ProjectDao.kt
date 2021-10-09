package com.itverse.futuris.data.daos

import androidx.room.*
import com.itverse.futuris.data.entities.Composant
import com.itverse.futuris.data.entities.Project
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(project: Project?): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProjectWithComposants(project: Project, composants: List<Composant>)

    @Delete
    suspend fun delete(project: Project?)

    @Query("SELECT * FROM project_table WHERE id = :projectId")
    suspend fun get(projectId: Long): Project

    @Query("DELETE FROM project_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM project_table")
    fun getAll(): Flow<List<Project>>

    @Query("SELECT * FROM project_table")
    fun getAllList(): List<Project>



}