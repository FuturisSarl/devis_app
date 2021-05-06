package com.itverse.futuris.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.itverse.futuris.data.entities.Composant
import com.itverse.futuris.data.entities.Project
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(project: Project?): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProjectWithComposants(project: Project, composants: List<Composant>)

    @Delete
    fun delete(project: Project?)

    @Query("DELETE FROM project_table")
    fun deleteAll()

    @Query("SELECT * FROM project_table WHERE name = :projectName")
    fun get(projectName: String?): Project
    // The flow always holds/caches latest version of data. Notifies its observers when the
    // data has changed.
    @Query("SELECT * FROM project_table")
    fun getAll(): Flow<List<Project>>

    @Query("SELECT * FROM project_table")
    fun getAllList(): List<Project>



}