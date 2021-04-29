package com.itverse.futuris.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.itverse.futuris.data.entities.Project
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(project: Project?)

    @Delete
    fun delete(project: Project?)

    @Query("DELETE FROM project_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM project_table WHERE project_name = :projectName")
    fun get(projectName: String?): Project
    // The flow always holds/caches latest version of data. Notifies its observers when the
    // data has changed.
    @Query("SELECT * FROM project_table")
    fun getAll(): Flow<List<Project>>

}