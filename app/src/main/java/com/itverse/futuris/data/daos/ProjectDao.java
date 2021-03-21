package com.itverse.futuris.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.itverse.futuris.data.entities.Project;

import java.util.List;

@Dao
public interface ProjectDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertProject(Project project);
    @Delete
    void deleteProject(Project project);
    @Query("SELECT * FROM project_table WHERE project_name = :projectName")
    LiveData<Project> getProject(String projectName);
    @Query("SELECT * FROM project_table")
    LiveData<List<Project>> getAllProjects();
}
