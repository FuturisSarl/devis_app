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

    @Query("DELETE FROM project_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM project_table WHERE name = :projectName")
    suspend fun get(projectName: String?): Project
    // The flow always holds/caches latest version of data. Notifies its observers when the
    // data has changed.
    @Query("SELECT * FROM project_table")
    fun getAll(): Flow<List<Project>>

    @Query("SELECT * FROM project_table")
    suspend fun getAllList(): List<Project>



}