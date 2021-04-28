package com.itverse.futuris.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.itverse.futuris.data.entities.Project

@Dao
interface ProjectDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProject(project: Project?)

    @Delete
    fun deleteProject(project: Project?)

    @Query("SELECT * FROM project_table WHERE project_name = :projectName")
    fun getProject(projectName: String?): LiveData<Project?>?

    @Query("SELECT * FROM project_table")
    fun getAllProjects(): LiveData<List<Project?>?>?
}